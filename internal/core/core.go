package core

import (
	"fmt"
	"log"
	"os"
	"strings"
	"sync"

	"github.com/sounishnath003/leetcode-practice-solutions/internal/models"
	"github.com/sounishnath003/leetcode-practice-solutions/internal/utils"
)

type Core struct {
	DirectoryPath string

	jobsOutChan chan *models.QuestionModel
	mu          *sync.Mutex
	wg          *sync.WaitGroup
}

func NewCore(solutionDirectoryPath string) *Core {
	return &Core{
		DirectoryPath: solutionDirectoryPath,
		mu:            &sync.Mutex{},
		wg:            &sync.WaitGroup{},
	}
}

func (c *Core) PrepareQuestionDatabase() (string, error) {
	if err := utils.CheckIfPathExists(c.DirectoryPath); err != nil {
		utils.HandleError(err, true)
	}

	// read the directory
	files, err := os.ReadDir(c.DirectoryPath)
	utils.HandleError(err, true)
	log.Printf("total files found in %s directory are %d\n", c.DirectoryPath, len(files))

	c.jobsOutChan = make(chan *models.QuestionModel, len(files))

	// iterate all jobs and all thems
	for _, file := range files {
		c.wg.Add(1)
		go c.processJob(file.Name(), fmt.Sprintf("%s/%s", c.DirectoryPath, file.Name()))
	}

	// wait for all jobs to complete
	c.wg.Wait()

	// close the channel to signal no more jobs
	close(c.jobsOutChan)

	// print all jobs from the channel
	var db models.QuestionDb
	for job := range c.jobsOutChan {
		db.Add(*job)
	}

	jsonFileDb, err := db.SaveToDisk("data")
	utils.HandleError(err, false)

	return jsonFileDb, err

}

func (c *Core) processJob(fID, filename string) {
	defer c.wg.Done()

	readBytes, err := os.ReadFile(filename)
	utils.HandleError(err, false)

	tokens := strings.Split(fID, ".")
	id := tokens[0]
	lang := tokens[len(tokens)-1]

	data := models.QuestionModel{
		ID:   id,
		Name: tokens[1],
		Lang: lang,
		Code: string(readBytes),
	}
	c.jobsOutChan <- &data
}

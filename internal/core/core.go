package core

import (
	"fmt"
	"log"
	"os"
	"strconv"
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

// MustPrepareQuestionDatabase prepares the question database by reading files from the specified directory,
// processing each file as a job, and saving the processed data to a JSON file.
func (c *Core) MustPrepareQuestionDatabase() (string, error) {
	// Check if the directory path exists
	if err := utils.CheckIfPathExists(c.DirectoryPath); err != nil {
		utils.HandleError(err, true)
		return "", err
	}

	// Read the directory to get a list of files
	files, err := os.ReadDir(c.DirectoryPath)
	utils.HandleError(err, true)
	log.Printf("total files found in %s directory are %d\n", c.DirectoryPath, len(files))

	// Initialize a channel to handle jobs
	c.jobsOutChan = make(chan *models.QuestionModel, len(files))

	// Process each file as a job
	for _, file := range files {
		c.wg.Add(1)
		go c.processJob(file.Name(), fmt.Sprintf("%s/%s", c.DirectoryPath, file.Name()))
	}

	// Wait for all jobs to complete
	c.wg.Wait()

	// Close the channel to signal no more jobs
	close(c.jobsOutChan)

	// Collect all processed jobs from the channel
	var db models.QuestionDb
	for job := range c.jobsOutChan {
		db.Add(*job)
	}

	// Save the processed data to a JSON file
	jsonFileDb, err := db.SaveToDisk("data")
	utils.HandleError(err, true)

	return jsonFileDb, err
}

func (c *Core) processJob(fID, filename string) {
	defer c.wg.Done()

	readBytes, err := os.ReadFile(filename)
	utils.HandleError(err, false)

	tokens := strings.Split(fID, ".")
	id, err := strconv.Atoi(tokens[0])
	if err != nil {
		id = 10e5
		utils.HandleError(err, false)
	}

	lang := tokens[len(tokens)-1]

	data := models.QuestionModel{
		ID:   id,
		Name: tokens[1],
		Lang: lang,
		Code: string(readBytes),
	}
	c.jobsOutChan <- &data
}

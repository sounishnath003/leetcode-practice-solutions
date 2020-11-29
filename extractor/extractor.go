package extractor

import (
	"fmt"
	"io/ioutil"
	"log"
	"os"
	"sync"
)

// applying concurrency to 100 different go routines
var mu sync.RWMutex
var wg sync.WaitGroup

// ExtractDirectoryContent : Extract your file Data
func ExtractDirectoryContent() {

	file, err := dataJSONFileCreator()
	warn(err)
	fmt.Println(file.Name(), " has been created...")

	files, err := ioutil.ReadDir("./solutions")
	warn(err)

	for index, f := range files {
		wg.Add(1)
		mu.Lock()
		go processFileInfo(index, f)
	}
	wg.Wait()

}

func processFileInfo(index int, f os.FileInfo) {
	defer mu.Unlock()
	defer wg.Done()

	fmt.Println(f.Name())
	content, err := ioutil.ReadFile("./solutions/" + f.Name())
	warn(err)
	jsonFile, err := os.OpenFile("data.json", os.O_APPEND|os.O_WRONLY, 0644)
	defer jsonFile.Close()
	warn(err)

	rawData := QuestionModel{ID: index + 1, Content: string(content)}
	jsonData, err := RecieveByteConvertJSON(rawData)
	warn(err)
	jsonFile.Write(jsonData)
	jsonFile.Write([]byte(","))
}

func warn(err error) {
	if err != nil {
		log.Fatalln("Error occured :", err.Error())
	}
}

func dataJSONFileCreator() (*os.File, error) {
	file, err := os.Create("data.json")
	return file, err
}

package extractor

import (
	"fmt"
	"io/fs"
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

	// delete previous database contents
	// wg.Add(1)
	// go func() {
	// 	defer wg.Done()
	// 	err = os.Remove("data.json")
	// 	warn(err)
	// 	fmt.Println("### Old Data.json file has been formated")
	// }()

	// start writing in new file
	jsonFile, err := os.OpenFile("data.json", os.O_APPEND|os.O_WRONLY, 0644)
	warn(err)
	defer jsonFile.Close()
	jsonFile.Write([]byte{'['})

	for index, f := range files {
		wg.Add(1)
		mu.Lock()
		go processFileInfo(index, f, files)
	}
	wg.Wait()

	jsonFile.Write([]byte{']'})
}

func processFileInfo(index int, f os.FileInfo, files []fs.FileInfo) {
	defer mu.Unlock()
	defer wg.Done()

	go func(index int) {
		fmt.Println("started parseing data to json encode : ", index)
	}(index)

	fmt.Println(f.Name())
	content, err := ioutil.ReadFile("./solutions/" + f.Name())
	warn(err)
	jsonFile, err := os.OpenFile("data.json", os.O_APPEND|os.O_WRONLY, 0644)
	defer jsonFile.Close()
	warn(err)

	rawData := QuestionModel{ID: index + 1, Name: f.Name(), Content: string(content)}
	jsonData, err := RecieveByteConvertJSON(rawData)
	warn(err)
	jsonFile.Write(jsonData)
	if index <= len(files)-2 {
		jsonFile.Write([]byte(","))
	}
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

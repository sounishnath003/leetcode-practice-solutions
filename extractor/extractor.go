package extractor

import (
	"fmt"
	"io/ioutil"
	"log"
)

func ExtractDirectoryContent() {
	files, err := ioutil.ReadDir("./solutions")
	if err != nil {
		log.Fatalln("Error in reading Directory: ", err.Error())
	}
	for index, f := range files {
		fmt.Println(index, " : ", f.Name())
	}

}

package utils

import (
	"encoding/json"
	"log"
	"os"
)

// HandleError - works to handle the error occured. captures when to panic as well.
// Helps to stop the execution if major incident happened
func HandleError(err error, shouldPanic bool) {
	if err != nil {
		log.Printf("error occured: %s\n", err)
		// if panic is true then only PANICs
		if shouldPanic {
			panic(err)
		}
	}
}

// checkIfPathExists - helps to check whether the filepath or directory present
func CheckIfPathExists(path string) error {
	_, err := os.Stat(path)
	return err
}

// ParseIntoJson - parse the QuestionModel into JSON byte string
// Returns the error also.
func ParseIntoJson(data any) ([]byte, error) {
	return json.Marshal(data)
}

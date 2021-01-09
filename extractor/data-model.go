package extractor

import (
	"encoding/json"
)

// QuestionModel json file structer
type QuestionModel struct {
	ID      int
	Name    string
	Content string
}

// RecieveByteConvertJSON : convert []byte qmodel to json
func RecieveByteConvertJSON(qdata QuestionModel) ([]byte, error) {
	jsonData, err := json.Marshal(qdata)
	return jsonData, err
}

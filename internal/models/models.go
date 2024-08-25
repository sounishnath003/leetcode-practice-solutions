package models

import (
	"fmt"
	"os"
	"path"
	"sort"
	"time"

	"github.com/sounishnath003/leetcode-practice-solutions/internal/utils"
)

// QuestionModel - defines the structure of the question model.
//
// Act like a data model for building the app solution
type QuestionModel struct {
	ID   int    `json:"id"`
	Name string `json:"name"`
	Lang string `json:"language"`
	Code string `json:"code"`
}

// QuestionDb - stores all the questions into the in memory store
type QuestionDb struct {
	Questions []QuestionModel `json:"questions"`
}

func NewQuestionDb() *QuestionDb {
	return &QuestionDb{
		Questions: make([]QuestionModel, 1),
	}
}

func (qdb *QuestionDb) Add(data QuestionModel) error {
	qdb.Questions = append(qdb.Questions, data)
	return nil
}

func (qDb *QuestionDb) SearchByID(id int) (QuestionModel, error) {
	for _, q := range qDb.Questions {
		if q.ID == id {
			return q, nil
		}
	}

	return QuestionModel{}, fmt.Errorf("invalid id %d not found", id)
}

func (qdb *QuestionDb) SortByID() {
	sort.Slice(qdb.Questions, func(i, j int) bool {
		return qdb.Questions[i].ID < qdb.Questions[j].ID
	})
}

func (qdb *QuestionDb) SaveToDisk(filename string) (string, error) {
	qdb.SortByID()
	filepath := fmt.Sprintf("%s-%s.json", filename, time.Now().Format(time.DateOnly))

	curDir, err := os.Getwd()
	utils.HandleError(err, true)
	if err != nil {
		return "", err
	}

	// Create directory if not exists
	err = os.MkdirAll(path.Join(curDir, "data"), 0o744)
	utils.HandleError(err, true)

	file, err := os.Create(path.Join(curDir, "data", filepath))
	utils.HandleError(err, false)

	bytes, err := utils.ParseIntoJson(qdb)
	if err != nil {
		return "", err
	}
	utils.HandleError(err, true)

	utils.ParseIntoJson(qdb)
	_, err = file.Write(bytes)
	if err != nil {
		return "", err
	}

	return path.Join(curDir, "data", filepath), nil
}

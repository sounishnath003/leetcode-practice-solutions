package main

import (
	"path"

	"github.com/sounishnath003/leetcode-practice-solutions/internal/core"
	"github.com/sounishnath003/leetcode-practice-solutions/internal/server"
	"github.com/sounishnath003/leetcode-practice-solutions/internal/utils"
)

func main() {
	solutionDir := path.Join("solutions")

	core := core.NewCore(solutionDir)
	JsonfileDb, err := core.PrepareQuestionDatabase()
	utils.HandleError(err, true)

	server.InitWebServer(JsonfileDb)
}

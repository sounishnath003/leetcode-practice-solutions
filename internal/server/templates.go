package server

import (
	"html/template"
	"io"
	"path"

	"github.com/sounishnath003/leetcode-practice-solutions/internal/utils"
)

func LoadHtmlTemplates(templateFileName string) *template.Template {
	err := utils.CheckIfPathExists(templateFileName)
	utils.HandleError(err, true)

	tmpl := template.Must(template.ParseFiles(path.Join(templateFileName)))

	return tmpl
}

func RenderTemplate(w io.Writer, t *template.Template, name string, data interface{}) {
	t.ExecuteTemplate(w, name, data)
}

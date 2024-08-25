package server

import (
	"encoding/json"
	"log"
	"net/http"
	"os"
	"time"

	"github.com/sounishnath003/leetcode-practice-solutions/internal/models"
	"github.com/sounishnath003/leetcode-practice-solutions/internal/utils"
)

// loggingMiddleware - middleware to log each incoming request
func loggingMiddleware(next http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		startTime := time.Now()
		w.Header().Add("Content-Type", "application/json; charset=utf-8")
		next.ServeHTTP(w, r)
		utils.HandleError(nil, false) // Assuming no error handling needed for logging
		log.Printf("Request: %s %s %s %v\n", r.Method, r.URL.Path, r.RemoteAddr, time.Since(startTime))
	})
}

// InitWebServer - runs the API endpoint which serves the data/data.json file as API with logging middleware
func InitWebServer(jsonFile string) error {
	if err := utils.CheckIfPathExists(jsonFile); err != nil {
		utils.HandleError(err, true)
	}

	readBytes, err := os.ReadFile(jsonFile)
	utils.HandleError(err, true)
	qDb := models.QuestionDb{}

	err = json.Unmarshal(readBytes, &qDb)
	utils.HandleError(err, true)

	mux := http.NewServeMux()
	mux.HandleFunc("/api/solutions/", func(w http.ResponseWriter, r *http.Request) {
		ReturnApiResponse(w, http.StatusOK, qDb, nil)
	})

	mux.HandleFunc("/api/solutions/{ID}", func(w http.ResponseWriter, r *http.Request) {
		id := r.PathValue("ID")

		result, err := qDb.SearchByID(id)
		if err != nil {
			utils.HandleError(err, false)
			ReturnApiResponse(w, http.StatusBadRequest, result, err)
			return
		}
		ReturnApiResponse(w, http.StatusAccepted, result, nil)
	})

	log.Println("api is up and running on port http://localhost:3000/")
	// Wrap the mux with logging middleware
	http.ListenAndServe(":3000", loggingMiddleware(mux))
	return nil
}

// ReturnApiResponse - return API Response in a Specific Order and Model
func ReturnApiResponse(w http.ResponseWriter, status int, data interface{}, err error) {
	w.WriteHeader(status)
	w.Header().Add("Content-Type", "application/json; charset=utf-8")
	errMsg := "None"
	if err != nil {
		errMsg = err.Error()
	}
	json.NewEncoder(w).Encode(map[string]any{
		"data":      data,
		"timestamp": time.Now().Format(time.DateTime),
		"error":     errMsg,
		"status":    status,
	})
}

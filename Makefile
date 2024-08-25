
AppName=dist/leetcode-practice-book

.PHONY: install
install:
	go mod tidy
	go mod download
	go mod verify

.PHONY: build
build:
	CGO_ENABLED=0 go build -ldflags "-s -w" -o $(AppName) cmd/*.go

.PHONY: run
run: build
	$(AppName)
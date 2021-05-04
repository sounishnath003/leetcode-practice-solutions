git pull origin master
xcopy solutions ..\solutions
git switch master
del /f/q/s solutions
copy ..\solutions solutions
del /f/q/s ..\solutions
rmdir ..\solutions
xcopy ..\solutions solutions
go run main.go
xcopy solutions leetcode-practice-app\src\data
git add .
git commit -am "Updated database on timestamp: " < date /t
git push
cd leetcode-practice-app
yarn dev
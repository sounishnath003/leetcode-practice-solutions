git pull origin master
cp -r solutions ..\solutions
git switch master
rm -fr solutions
cp -R ../solutions solutions
rm -fr ../solutions
rm -fr ../solutions
cp -R ../solutions solutions
go run main.go
cp -R solutions leetcode-practice-app/src/data
git add .
git commit -am "Updated database on timestamp: " < date /t
git push
cd leetcode-practice-app
yarn dev
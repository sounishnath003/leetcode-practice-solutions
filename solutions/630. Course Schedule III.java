class Solution {
    /*
    
    This is one of the correct solution as of my 1st intution to approch the problem
    however; it's getting `TLE`; which is obious.
    ---
    
    
    public int scheduleCourse(int[][] courseee) {
        Arrays.sort(courseee, (a, b) -> b[1] < a[1] ? 1 : -1);
        return f(courseee, 0, 0);
    }
​
    private int f(int[][] courses, int curIndex, int timeSpend){
        if(curIndex == courses.length) return 0;
​
        int[] course = courses[curIndex];
        int alreadyDone = 0;
        if(timeSpend + course[0] <= course[1])
            alreadyDone = 1 + f(courses, curIndex+1, timeSpend + course[0]);
​
        // if we don't take up that course
        int otherMax = f(courses, curIndex+1, timeSpend);
        return Math.max(otherMax, alreadyDone);
    }
    */
    
    class Course {
        int duration;
        int lastDay;
        Course(int d, int l){
            this.duration = d;
            this.lastDay = l;
        }
    }
    public int scheduleCourse(int[][] courseee) {
    Comparator<Course> comp = (a, b) -> a.lastDay - b.lastDay;
        PriorityQueue<Course> courses = new PriorityQueue<Course>(courseee.length + 1, comp);
        for(int[] c : courseee) {
            courses.add(new Course(c[0], c[1]));
        }
        PriorityQueue<Integer> alreadyTaken = new PriorityQueue<>((a, b) -> (b-a));
        int time = 0;
        for(Course course : courses) {
            if(time+course.duration <= course.lastDay) {
                alreadyTaken.add(course.duration);
                time += course.duration;
            } else {
                if (alreadyTaken.isEmpty()==false && alreadyTaken.peek() > course.duration) {
                    int x = alreadyTaken.poll();
    time -= x;
                    time += course.duration;
                    alreadyTaken.add(course.duration);
                }
            }
        }
        return alreadyTaken.size();
    }
}

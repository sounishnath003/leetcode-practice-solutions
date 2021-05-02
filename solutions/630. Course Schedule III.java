class Solution {
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

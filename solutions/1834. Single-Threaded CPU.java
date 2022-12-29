class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        int[] ans=new int[n];
        Task[] extTasks=new Task[n];  //extTasks : exist Tasks
        
        for(int i=0;i<n;i++){
            Task nt=new Task(tasks[i][0],tasks[i][1],i);  //nt:new task
            extTasks[i]=nt;
        }
        Arrays.sort(extTasks,new StartTime());
        
        PriorityQueue<Task> pq=new PriorityQueue<>(new Duration());
        
        int ai=0;  //ai : answer index [will help to fill answer array]
        int ti=0;  //ti : task index [ iterate over existing tasks,will help to know tasks pending]
        int currentTime=0;
        
        while(ai<n){
            while(ti<n && extTasks[ti].startTime<=currentTime){
                pq.add(extTasks[ti++]);
            }
            
            if(pq.size()==0){
                currentTime=extTasks[ti].startTime;
                continue;
            }
            
            Task bestFit=pq.remove();
            ans[ai++]=bestFit.index;
            currentTime+=bestFit.processTime;
        }
        return ans;
    }
    
    // will use this to sort on the basis of start time
    public class StartTime implements Comparator<Task>{
        @Override
        public int compare(Task one,Task two){
            return one.startTime-two.startTime;
        }
    }
    
    //will use this in priorityQueue
    public class Duration implements Comparator<Task>{
        @Override
        public int compare(Task one,Task two){
            if(one.processTime==two.processTime) return one.index-two.index;
            return one.processTime-two.processTime;
        }
    }
    
    public class Task{
        int startTime;
        int processTime;
        int index;
        
        Task(int startTime,int processTime,int index){
            this.startTime=startTime;
            this.processTime=processTime;
            this.index=index;
        }
    }
}

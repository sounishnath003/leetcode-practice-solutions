class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    boolean[] explored;
    Stack<Integer> stk;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        explored = new boolean[numCourses];
        visited = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                if(isCyclic(i)){
                    return new int[]{};
                }
            }
        }
        
        visited = new boolean[numCourses];
        stk = new Stack<>();
        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                topologicalSort(i);
            }
        }
        
        int[] res = new int[stk.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = stk.pop();
        }
        
        return res;
    }
    
    boolean isCyclic(int i){
        visited[i] = true;
        for(Integer j : graph[i]){
            if(!visited[j]){
                if(isCyclic(j)){
                    return true;
                }
            }
            else if(!explored[j]){
                return true;
            }
        }
        explored[i] = true;
        return false;
    }
    
    void topologicalSort(int i){
        visited[i] = true;
        for(Integer j : graph[i]){
            if(!visited[j]){
                topologicalSort(j);
            }
        }
        stk.push(i);
    }
    
    
}

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

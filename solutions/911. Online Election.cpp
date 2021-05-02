class TopVotedCandidate {
    map<int, int> vote_count, most_prefered_by_time;
public:
    TopVotedCandidate(vector<int>& persons, vector<int>& times) {
        int max_voted_person = -1;
        for (int i = 0; i < persons.size(); i++) {
            int person = persons[i];
            vote_count[person]++; 
            if(max_voted_person <= vote_count[person]) {
                max_voted_person = vote_count[person];
                most_prefered_by_time[times[i]] = person;    
            }
            
        }
    }
    
    int q(int t) {
     auto itr = most_prefered_by_time.lower_bound(t);
       if(itr->first != t) {
           itr--;
       }
       return itr->second;
    }
};
​
/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate* obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj->q(t);
 */

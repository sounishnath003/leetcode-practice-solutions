class TopVotedCandidate {
    map<int, int> voteCount, winnerCount;
public:
    TopVotedCandidate(vector<int>& persons, vector<int>& times) {
        int mv=-1,lc=-1;
        for(int i = 0; i < persons.size(); i++) {
            int person = persons[i];
            voteCount[person]++;
            if(mv <= voteCount[person]) { mv = voteCount[person]; lc=person; }
            winnerCount[times[i]] = lc;
        }
​
    }
    
    int q(int t) {
        auto itr = winnerCount.lower_bound(t);
        if(itr->first != t) {itr-- ;}
        return itr->second;
    }
};
​
/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate* obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj->q(t);
 */

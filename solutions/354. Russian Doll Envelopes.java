class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        class Env {
            int w;
            int h;
            int area;
            Env(int w, int h, int a) {
                this.w = w;
                this.h = h;
                this.area = a;
            }
        }
        
        Env[] arr = new Env[n];
        int i = 0;
        for(int[] envelop : envelopes) {
            arr[i++] = new Env(envelop[0], envelop[1], envelop[0]*envelop[1]);
        }
        
        Arrays.sort(arr, new Comparator<Env>() {
​
            @Override
            public int compare(Env a, Env b) {
                // TODO Auto-generated method stub
                if (a.area < b.area) {
                    return 1;
                }
                return -1;
            }
        });
        
        int lis[] = new int[n];
        Arrays.fill(lis, 1);
        i = 0;
        for (int j = 1; j < n; j++) {
            while(i < j) {
                if (arr[i].w > arr[j].w && arr[i].h > arr[j].h) {
                    lis[j] = Math.max(lis[j], lis[i] + 1);
                }
                i++;
            }
            i=0;
        }
        int mx = -1;
        for (int a : lis)
            mx = Math.max(mx, a);
        
        return mx;
    }
}

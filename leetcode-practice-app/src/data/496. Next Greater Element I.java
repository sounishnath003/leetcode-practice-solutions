class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterElems = findNextGreaterElems(nums2);
        HashMap<Integer,Integer> cache = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            cache.put( nums2[i], nextGreaterElems[i] );
        }
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            ans[i] = cache.get(nums1[i]);
        }
        return ans;
    }
    
    private static int[] findNextGreaterElems(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        /**
           traverse korbo backward ar ans[] te rightside 
           ...er big elem store korbo!
           ---
           [4,1,2] ~> -1  2 -1
        */
        int[] elems = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            while(stack.isEmpty()==false && stack.peek() < arr[i]) stack.pop();
            elems[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(arr[i]);
        }
        return elems;
    }
}

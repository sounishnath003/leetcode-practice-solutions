    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] arr = fs.readArray(n);
        List<Integer> ans = new MinimumAfterSelf().countSmaller(arr);
        System.out.println(ans);
    }
​
    // Optimation Using BST / MinHeap
​
    class Node {
        Node left;
        Node right;
        int data;
        int count;
​
        Node(int d, Node l, Node r) {
            this.data = d;
            this.left = l;
            this.right = r;
            this.count = 1;
        }
    }
​
    public List<Integer> countSmaller(int[] nums) {
        /*
         * Build BST and Count
         */
​
        final int n = nums.length;
        List<Integer> smallers = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return smallers;
​
        Node root = new Node(nums[n - 1], null, null);
        smallers.add(0);
​
        for (int i = n - 2; i >= 0; i--) {
            int smallerElems = construct(root, nums[i]);
            smallers.add(smallerElems);
        }
        Collections.reverse(smallers);
        return smallers;
    }
​
    private int construct(Node root, int data) {
        // TODO Auto-generated method stub
        int smallerNodes = 0;
​
        while (true) {
            if (data <= root.data) {
                // go left
                root.count++;
                if (root.left == null) {
                    root.left = new Node(data, null, null);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                // go right
                smallerNodes += root.count;
                if (root.right == null) {
                    root.right = new Node(data, null, null);
                    break;
                } else {
                    root = root.right;
                }
            }

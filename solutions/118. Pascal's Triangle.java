class Solution {
    public List<List<Integer>> generate(int numRows) {
        return generatePascalsTrianle(numRows);
    }
    
    private static List<List<Integer>> generatePascalsTrianle(int numRows) {
        // TODO Auto-generated method stub
        List<List<Integer>> finalSet = new ArrayList<List<Integer>>();
​
        int curRow = 1;
        List<Integer> sublist = new ArrayList<Integer>();
        sublist.add(1);
​
        // generating 1st row of triangle
        finalSet.add(sublist);
​
        while(curRow < numRows) {
            // get the prev. row
            // create new row 
            // 0...curRow
                // get leftNum, get rightNum
                // simply add in new row
​
            List<Integer> prevRow = finalSet.get( curRow - 1 );
            List<Integer> newRow = new ArrayList<Integer>();
​
            for (int i = 0; i <= curRow; i++) {
                int leftElem = i >= 1 ? prevRow.get(i-1) : 0;
                int rightElem = i < curRow ? prevRow.get(i) : 0;
                int sum = leftElem + rightElem;
                newRow.add(sum);
            }
​
            finalSet.add(newRow);
            curRow++;
        }
​
        return finalSet;
    }
}

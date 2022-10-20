class Solution {
    public String intToRoman(int num) {
        /**
         * XIV --> 14
         * X I V
         * i i+1
         * 1 < 5 ----> (-) ---> 4
         * i i+1
         * 10 > 1 --------> (+) ---> 10
         * --------------------------------
         * (+) ---> 14
         */
​
        final Map<Integer, String> map = prepareRomanTableMapper();
        System.out.println(map);
        final int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        final String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
​
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                sb.append(roman[i]);
                num = num - value[i];
            }
        }
​
        return sb.toString();
    }
​
    final private Map<Integer, String> prepareRomanTableMapper() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        return map;
    }
}

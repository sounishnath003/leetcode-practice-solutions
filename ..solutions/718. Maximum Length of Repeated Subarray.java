            HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
​
            for (int i = 0; i < arr1.length; i++) {
                int key = arr1[i];
                if (map.containsKey(key) == true) {
                    map.get(key).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(key, list);
                }
            }
​
            System.out.println(map);
​
            // checking weither the length of the array subarray;
​
            int maxLength = 0;
​
            for (int i = 0; i < arr2.length; i++) {
                int key = arr2[i];
​
                // check if key presents in map
                if (map.containsKey(key) == true) {
                    int ii = i;
                    for (int jj : map.get(key)) {
                        while ((ii < arr2.length && jj < arr1.length) && arr2[ii] == arr1[jj]) {
                            ii++;
                            jj++;
                        }
                        ii--;
                        int len = Math.abs(ii - i);
                        maxLength = Math.max(len, maxLength);
                    }
                }
​
            }
​
            return maxLength;
        }
    }
​

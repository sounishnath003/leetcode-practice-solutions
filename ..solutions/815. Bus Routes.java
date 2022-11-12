class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
​
        for (int bus_no = 0; bus_no < routes.length; bus_no++) {
            for (int c = 0; c < routes[bus_no].length; c++) {
                int stand = routes[bus_no][c];
​
                if (map.containsKey(stand) == true)
                    map.get(stand).add(bus_no);
                else {
                    List<Integer> _bus_no = new ArrayList<>();
                    _bus_no.add(bus_no);
                    map.put(stand, _bus_no);
                }
            }
        }
​
        Set<Integer> visited_buses = new HashSet<>();
        Set<Integer> visited_stands = new HashSet<>();
​
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        int level = -1;
​
        while (queue.isEmpty() == false) {
            int size = queue.size();
            level++;
​
            while (size-- > 0) {
                int current_stand = queue.remove();
​
                if (current_stand == target)
                    return level;
​
                for (int bus_no : map.get(current_stand)) {
                    if (visited_buses.contains(bus_no) == false) {
                        for (int bus_stand : routes[bus_no]) {
                            if (visited_stands.contains(bus_stand) == false) {
                                visited_stands.add(bus_stand);
                                queue.add(bus_stand);
                            }
                        }
                    }
                    visited_buses.add(bus_no);
                }
            }
        }
​
        return -1; // if no route found
    }
}

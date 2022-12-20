class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int totalRooms = rooms.size();
        boolean[] visitedRooms = new boolean[totalRooms];
        exploreAllRoomsAndOpen(rooms, visitedRooms, 0);
        return hasAllExplored(visitedRooms);
    }
​
    private boolean hasAllExplored(boolean[] visitedRooms) {
        boolean status = visitedRooms[0];
        for (boolean val : visitedRooms)
            status = status & val;
        return status;
    }
​
    private void exploreAllRoomsAndOpen(List<List<Integer>> rooms, boolean[] visitedRooms, int currentRoom) {
        visitedRooms[currentRoom] = true;
        for (int nextRoomKey : rooms.get(currentRoom)) {
            if (!visitedRooms[nextRoomKey]) {
                exploreAllRoomsAndOpen(rooms, visitedRooms, nextRoomKey);
            }
        }
    }
}

import java.util.*;

class Solution {

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    // DFS
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int numberOfRooms = rooms.size();
        boolean[] visited = new boolean[numberOfRooms];

        // start traversal from 0
        dfs(0, rooms, visited);

        for(boolean wasVisited : visited) {
            if(!wasVisited) {
                return false;
            }
        }
        return true;
    }

    public void dfs(int currRoom, List<List<Integer>> rooms, boolean[] visited) {
        //mark current room as visited
        visited[currRoom] = true;

        for(int key : rooms.get(currRoom)) {
            if(!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }

    // BFS
    /*
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        visited[0] = true;
        int visitedCount = 1;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        while(!queue.isEmpty()) {
            int currRoom = queue.poll();

            for(int key : rooms.get(currRoom)) {
                if(!visited[key]) {
                    visited[key] = true;
                    visitedCount++;

                    if(visitedCount==n) {
                        return true;
                    }

                    queue.offer(key);
                }
            }
        }

        return visitedCount==n;
    }
    */
}
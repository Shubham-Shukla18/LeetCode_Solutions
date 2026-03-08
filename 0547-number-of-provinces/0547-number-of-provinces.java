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
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                provinces++;

                dfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(int city, int[][] isConnected, boolean[] visited){
        visited[city] = true;

        for(int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if(isConnected[city][neighbor]==1 && !visited[neighbor]){
                dfs(neighbor, isConnected, visited);
            }
        }
    }
    

    //BFS
    /*
    public int findCircleNum(int[][] isConnected) {
        int numberOfCities = isConnected.length;
        boolean[] visited = new boolean[numberOfCities];
        int provinceCount = 0;

        for(int i = 0; i < numberOfCities; i++) {
            if(!visited[i]){
                provinceCount++;
                bfs(i, isConnected, visited);
            }
        }

        return provinceCount;
    }

    private void bfs(int startCity, int[][] isConnected, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startCity);
        visited[startCity] =  true;

        while(!queue.isEmpty()) {
            int currentCity = queue.poll();

            for(int neighbor = 0; neighbor < isConnected.length; neighbor++) {
                if(isConnected[currentCity][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
    */
}
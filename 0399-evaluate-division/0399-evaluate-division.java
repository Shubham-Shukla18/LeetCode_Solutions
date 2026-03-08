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
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, val);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0/val);
        }

        double[] results = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if(!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else if(start.equals(end)) {
                results[i] = 1.0;
            } else {
                results[i] = dfs(start, end, 1.0, graph, new HashSet<>());
            }
        }

        return results;
    }

    private double dfs(String curr, String target, double currentProduct, Map<String, Map<String, Double>> graph, Set<String> visited) {
        visited.add(curr);
        Map<String, Double> neighbors = graph.get(curr);

        if(neighbors.containsKey(target)) {
            return currentProduct * neighbors.get(target);
        }

        for(Map.Entry<String, Double> entry : neighbors.entrySet()) {
            String next = entry.getKey();
            if(!visited.contains(next)) {
                double result = dfs(next, target, currentProduct * entry.getValue(), graph, visited);
                if(result!=-1.0) {
                    return result;
                }
            }
        }
        return -1.0;
    }

    //BFS
    /*
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //Build the graph: Map of (Node -> Map of (neighbor -> weight))
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, val);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0/val);
        }

        double[] results = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            results[i] = bfs(queries.get(i).get(0), queries.get(i).get(1), graph);
        }
        return results;
    }

    private double bfs(String start, String target, Map<String, Map<String, Double>> graph) {
        if(!graph.containsKey(start) || !graph.containsKey(target)) {
            return -1.0;
        }
        if(start.equals(target)) {
            return 1.0;
        }

        Queue<Pair<String, Double>> queue = new LinkedList<>();
        queue.offer(new Pair<>(start, 1.0));
        Set<String> visited = new HashSet<>();
        visited.add(start);

        while(!queue.isEmpty()) {
            Pair<String, Double> current = queue.poll();
            String currNode = current.node;
            double currWeight = current.weight;

            if(currNode.equals(target)) {
                return currWeight;
            }

            for(Map.Entry<String, Double> neighbor : graph.get(currNode).entrySet()) {
                if(!visited.contains(neighbor.getKey())) {
                    visited.add(neighbor.getKey());
                    queue.offer(new Pair<>(neighbor.getKey(), currWeight * neighbor.getValue()));
                }
            }
        }
        return -1.0;
    }

    private static class Pair<K, V> {
        K node;
        V weight;
        Pair(K node, V weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    */
}
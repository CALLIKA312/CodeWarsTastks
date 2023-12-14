package OptimizationProcesses.L2;


import java.util.*;

public class Graph {
    private int V; // Количество вершин
    private final LinkedList<Integer>[] adj; // Список смежности

    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    boolean isReachableBFS(int s, int d) {
        if (s == d) return true;
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            for (Integer n : adj[s]) {
                if (n == d) return true;
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }

    boolean isReachableDFS(int s, int d) {
        if (s == d) return true;
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        visited[s] = true;
        stack.push(s);
        while (!stack.isEmpty()) {
            s = stack.pop();
            for (Integer n : adj[s]) {
                if (n == d) return true;
                if (!visited[n]) {
                    visited[n] = true;
                    stack.push(n);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int u = 1, v = 3;
        if (g.isReachableDFS(u, v))
            System.out.println("Существует маршрут между " + u + " и " + v);
        else
            System.out.println("Маршрут между " + u + " и " + v + " не существует");
    }
}
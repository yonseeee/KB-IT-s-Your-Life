package week2;

import java.util.*;

public class BFS {
    public void bfs(List<List<Integer>> graph, int startVertex) {
        Queue<Integer>queue=new ArrayDeque<>();
        Set<Integer>visited=new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while(!queue.isEmpty()){
            int currentVertex=queue.poll();
            for(int nextVertex:graph.get(currentVertex)){
                if(!visited.contains(nextVertex)){
                    queue.add(nextVertex);
                    visited.add(nextVertex);
                }
            }
        }
    }

    public void solve(List<List<Integer>> graph) {
        bfs(graph, 0);
    }

    // 실행용 메소드
    public static void main(String[] args) {
        (new BFS()).solve(makeGraph());
    }

    public static List<List<Integer>> makeGraph() {
        return new ArrayList<>() {{
            add(List.of(1, 3, 6));
            add(List.of(0, 3));
            add(List.of(3));
            add(List.of(0, 1, 2, 7));
            add(List.of(5));
            add(List.of(4, 6, 7));
            add(List.of(0, 5));
            add(List.of(3, 5));
        }};
    }

}
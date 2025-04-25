package week2;

import java.util.*;

public class FarthestNode {
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) {
        int [][]edge={{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        solution(6,edge);
    }
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n+1];
        dist=new int[n+1];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }

        for(int[] e:edge){
            int a=e[0];
            int b=e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dist[1]=1;
        BFS(1,graph);

//        for(int i=1;i<=n;i++){
//            System.out.println(i+" "+dist[i]);
//        }

        int cnt=0;
        int max=-1;
        for(int i=1;i<=n;i++){
            if(dist[i]>max){
                max=dist[i];
            }
        }
        for(int i=1;i<=n;i++){
            if(dist[i]==max){
                cnt++;
            }
        }
        return cnt;
    }

    static void BFS(int i,Map<Integer, List<Integer>> graph){
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(i);
        visited[i]=true;

        while(!queue.isEmpty()){
            int curVertex=queue.poll();

            for(int nextVertex:graph.get(curVertex)){
                if(!visited[nextVertex]){
                    dist[nextVertex]=dist[curVertex]+1;
                    queue.add(nextVertex);
                    visited[nextVertex]=true;
                }
            }
        }
    }
}

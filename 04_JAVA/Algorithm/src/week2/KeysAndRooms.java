package week2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    static boolean[] visited;
    public static void main(String[] args) {
        List<List<Integer>> graph =makeGraph();
        System.out.println(canVisitAllRooms(graph));
    }
    public static List<List<Integer>> makeGraph(){
        return new ArrayList<>(){{
           add(List.of(1));
           add(List.of(2));
           add(List.of(3));
           add(List.of());
        }};
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        BFS(0,rooms);
        for(int i=0;i<rooms.size();i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    static void BFS(int i,List<List<Integer>> rooms){
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(i);
        visited[i]=true;

        while(!queue.isEmpty()){
            int curVertex=queue.poll();

            for(int nextVertex:rooms.get(curVertex)){
                if(!visited[nextVertex]){
                    queue.add(nextVertex);
                    visited[nextVertex]=true;
                }
            }
        }
    }
}

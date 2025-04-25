package week2;

import java.util.*;

public class Network {
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] computers={{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution(3,computers));


    }
    public static int solution(int n, int[][]computers){
        int answer=0;
        visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                BFS(i,computers);
                answer++;
            }
        }

        return answer;

    }
    static void BFS(int  i,int[][]computers){
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(i);
        visited[i]=true;

        while(!queue.isEmpty()){
            int curVertex=queue.poll();

            for(int nextVertex=0;nextVertex<computers[curVertex].length;nextVertex++){
                if(computers[curVertex][nextVertex]==1&&!visited[nextVertex]){
                    queue.add(nextVertex);
                    visited[nextVertex]=true;
                }
            }
        }
    }
}

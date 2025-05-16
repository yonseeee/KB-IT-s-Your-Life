package week4;

import java.util.ArrayList;
import java.util.List;

public class Wire {
    static int cnt;
    private static boolean[]visited;
    public static void main(String[] args) {
        int[][] wires={{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(9,wires));
    }
    public static int solution(int n, int[][] wires) {
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            tree.add(new ArrayList<>());
        }

        for(int[] wire:wires){
            int parent = wire[0];
            int child = wire[1];
            tree.get(parent).add(child);
            tree.get(child).add(parent);
        }

        int minCnt=200;
        for(int[]wire:wires){

            int parent = wire[0];
            int child = wire[1];
            tree.get(parent).remove((Integer) child);
            tree.get(child).remove((Integer) parent);

            visited=new boolean[n+1];
            cnt=0;
            dfs(tree,parent);
            int first=cnt;
//            System.out.println(cnt);
            visited=new boolean[n+1];
            cnt=0;
            dfs(tree,child);
//            System.out.println(cnt);
            int second=cnt;
//            System.out.println("==========");
            tree.get(parent).add(child);
            tree.get(child).add(parent);

            minCnt=Math.min(Math.abs(first-second),minCnt);
        }
        return minCnt;
    }
    public static void dfs(List<List<Integer>> tree, int startNode){
        cnt++;
        visited[startNode]=true;
        for(int child:tree.get(startNode)){
            if(visited[child]==false) {
                dfs(tree, child);
            }
        }
    }
}

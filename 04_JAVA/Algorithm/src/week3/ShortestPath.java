package week3;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPath {
    static int[]dr={0,1,1,1,0,-1,-1,-1};
    static int[]dc={1,1,0,-1,-1,-1,0,1};
    static int rowLength;
    static int colLength;
    static boolean[][] visited;
    public static void main(String[] args) {
//        int[][] grid={{0,1},{1,0}};
//        int[][] grid={{0,0,0},{1,1,0},{1,1,0}};
        int[][] grid={{1,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        rowLength= grid.length;
        colLength= grid[0].length;
        visited=new boolean[rowLength][colLength];

        return bfs(0,0,grid);
    }
    public static int bfs(int row,int col,int[][] grid){
        if(grid[0][0]==1||grid[rowLength-1][colLength-1]==1){return -1;}

        Queue<int[]> queue=new ArrayDeque<>();
        visited[row][col]=true;
        queue.offer(new int[]{row,col,1});

        while(!queue.isEmpty()){
            int[]cur=queue.poll();
            int curRow=cur[0];
            int curCol=cur[1];
            int dist=cur[2];

            if(curRow==rowLength-1&&curCol==colLength-1){
                return dist;
            }

            for(int i=0;i<8;i++){
                int nextRow=curRow+dr[i];
                int nextCol=curCol+dc[i];

                if(isValid(nextRow,nextCol,grid)){
                    if(!visited[nextRow][nextCol]){
                        visited[nextRow][nextCol]=true;
                        queue.offer(new int[]{nextRow,nextCol,dist+1});
                    }
                }
            }
        }
        return -1;
    }
    public static boolean isValid(int r, int c, int[][] grid){
        return r>=0&&r<rowLength&&c>=0&&c<colLength&&grid[r][c]==0;
    }
}

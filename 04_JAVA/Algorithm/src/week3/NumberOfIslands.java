package week3;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
    public static boolean[][]visited;
    public static int[] dr={0,1,0,-1};
    public static int[] dc={1,0,-1,0};
    public static int rowLength;
    public static int colLength;

    public static void main(String[] args) {
//        char[][]grid={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][]grid={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
        visited=new boolean[rowLength][colLength];

        int cnt=0;
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
                    bfs(i,j,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void bfs(int row, int col, char[][]grid){
        Queue<int[]> queue=new ArrayDeque<>();
        queue.offer(new int[]{row,col});
        visited[row][col]=true;

        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            int curRow=cur[0];
            int curCol=cur[1];

            for(int i=0;i<4;i++){
                int nextRow=curRow+dr[i];
                int nextCol=curCol+dc[i];

                if(isValid(nextRow,nextCol,grid)){
                    if(!visited[nextRow][nextCol]){
                        visited[nextRow][nextCol]=true;
                        queue.offer(new int[]{nextRow,nextCol});
                    }
                }

            }
        }

    }

    public static boolean isValid(int r, int c, char[][] grid){
        return r>=0&&r<rowLength && c>=0&&c<colLength &&grid[r][c]=='1';
    }
}

package week3;

import java.util.ArrayDeque;
import java.util.Queue;

public class Miro {
    static boolean[][]visited;
    static int rowLength;
    static int colLength;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};

    public static void main(String[] args) {
        String[]maps={"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(solution(maps));
    }
    public static int solution(String[] maps) {
        int startRow=0, startCol=0, leverRow=0, leverCol=0,endRow=0, endCol=0;
        rowLength=maps.length;
        colLength=maps[0].length();
        visited=new boolean[rowLength][colLength];

        char[][] grid=new char[rowLength][colLength];

        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                grid[i][j]=maps[i].charAt(j);
                if(grid[i][j]=='S'){
                    startRow=i;
                    startCol=j;
                }
                else if(grid[i][j]=='L'){
                    leverRow=i;
                    leverCol=j;
                }
                else if(grid[i][j]=='E'){
                    endRow=i;
                    endCol=j;
                }
            }
        }

        int toLever=bfs(startRow,startCol,leverRow,leverCol,grid);
        if(toLever==-1){
            return -1;
        }

        visited=new boolean[rowLength][colLength];
        int toEnd=bfs(leverRow,leverCol,endRow,endCol,grid);
        if(toEnd==-1){
            return -1;
        }
        return toLever+toEnd;
    }

    public static int bfs(int sr, int sc, int er, int ec, char[][]grid){
        Queue<int[]> queue=new ArrayDeque<>();

        visited[sr][sc]=true;
        queue.add(new int[]{sr,sc,0});

        while(!queue.isEmpty()){
            int[]cur=queue.poll();

            int curRow=cur[0];
            int curCol=cur[1];
            int dist=cur[2];

            if(curRow==er&&curCol==ec){
                return dist;
            }

            for(int i=0;i<4;i++){
                int nextRow=cur[0]+dr[i];
                int nextCol=cur[1]+dc[i];

                if(isValid(nextRow,nextCol,grid)){
                    if(!visited[nextRow][nextCol]){
                        visited[nextRow][nextCol]=true;
                        queue.add(new int[]{nextRow,nextCol,dist+1});
                    }
                }

            }

        }
        return -1;
    }

    public static boolean isValid(int r, int c, char[][] grid){
        return r>=0&&r<rowLength&&c>=0&&c<colLength&&grid[r][c]!='X';

    }
}

package com.samjin.bfs;

import java.util.PriorityQueue;

public class PathWithMaximumMinimumVale {

    public class Unit{
        public int value;
        public int row;
        public int cal;
        public Unit(int value, int i , int j ){
            this.value = value;
            this.row = i;
            this.cal = j;
        }
    }

    public int maximumMinimumPath(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
        int min = Math.min(grid[r-1][c-1], grid[0][0]);

        PriorityQueue<Unit> pq = new PriorityQueue<>((a,b) -> b.value - a.value);

        int[][] visited = new int[r][c];

        int i = 0, j = 0;

        while(i != r-1 || j != c-1){
            visited[i][j] = 1;
            int curr = grid[i][j];

            if(i-1>=0&& visited[i-1][j]==0){
                visited[i-1][j] = 1;
                pq.offer(new Unit(grid[i-1][j],i-1,j));
            }
            //down
            if(i+1<r&& visited[i+1][j]==0){
                if(reach(i+1,j,r,c))return min;
                visited[i+1][j] = 1;
                pq.offer(new Unit(grid[i+1][j],i+1,j));
            }
            //left
            if(j-1>=0&& visited[i][j-1]==0){
                visited[i][j-1] = 1;
                pq.offer(new Unit(grid[i][j-1],i,j-1));
            }
            //right
            if(j+1<c&& visited[i][j+1]==0){
                if(reach(i,j+1,r,c))return min;
                visited[i][j+1] = 1;
                pq.offer(new Unit(grid[i][j+1],i,j+1));
            }

            Unit next = pq.poll();
            if(next.value<min) min = next.value;
            i = next.row;
            j = next.cal;
        }
        return min;
    }

    public boolean reach(int i , int j , int r , int c){
        if(i==r-1 && j == c-1)return true;
        return false;
    }
}

class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;

    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) {
            throw new IllegalArgumentException("Invalid grid");
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int totalCells = rows*cols;

        // Primitive flat queue to avoid object creation and boxing overhead
        int[] queue = new int[totalCells];
        int head = 0;
        int tail = 0;
        int freshOrangesCount = 0;

        // Step 1: Initialize queue and count fresh oranges
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(grid[r][c]==ROTTEN) {
                    queue[tail++] = r*cols + c;
                } else if(grid[r][c]==FRESH) {
                    freshOrangesCount++;
                }
            }
        }

        if(freshOrangesCount==0) {
            return 0;
        }

        int minutesElapsed = 0;

        // Step 2: Multi-source BFS using flat queue pointers
        while(head<tail && freshOrangesCount>0) {
            int levelSize = tail-head;
            boolean rotSpreadThisMinute = false;

            for(int i=0; i<levelSize; i++) {
                int code = queue[head++];
                int r = code / cols;
                int c = code % cols;

                for(int[] dir: DIRECTIONS) {
                    int nextRow = r + dir[0];
                    int nextCol = c + dir[1];

                    if(nextRow>=0 && nextRow<rows && nextCol>=0 && nextCol<cols && grid[nextRow][nextCol]==FRESH) {
                        grid[nextRow][nextCol]=ROTTEN;
                        freshOrangesCount--;
                        queue[tail++]=nextRow*cols + nextCol;
                        rotSpreadThisMinute = true;
                    }
                }
            }
            if (rotSpreadThisMinute){
                minutesElapsed++;
            }
        }
        return freshOrangesCount==0?minutesElapsed:-1;
    }
}
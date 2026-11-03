import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final char WALL = '+';
    private static final char EMPTY = '.';

    public int nearestExit(char[][] maze, int[] entrance) {
        validateInput(maze, entrance);

        int rows = maze.length;
        int cols = maze[0].length;
        int startRow = entrance[0];
        int startCol = entrance[1];

        //Queue Stores elements as array:(row, col, distance)
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol, 0});

        //mark starting cell as visited to prevent re-entry
        maze[startRow][startCol] = WALL;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int steps = current[2];

            //check if current position is an exit (border cell, excluding starting point)
            if((r!=startRow || c!=startCol) && isBorderCell(r, c, rows, cols)) {
                return steps;
            }

            //Explore adjacent cells 
            for(int[] dir:DIRECTIONS) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];

                if(isValidMove(maze, nextR, nextC, rows, cols)) {
                    // mark visited immediately when enquequeing to avoid duplicate queue entries
                    maze[nextR][nextC]=WALL;
                    queue.offer(new int[]{nextR, nextC, steps+1});
                }
            }
        }

        return -1;

    }

    private static boolean isBorderCell(int r, int c, int rows, int cols) {
        return r==0 || r==rows-1 || c==0 || c==cols-1;
    }

    private static boolean isValidMove(char[][] maze, int r, int c, int rows, int cols) {
        return r>=0 && r<rows && c>=0 && c<cols && maze[r][c]==EMPTY;
    }

    private static void validateInput(char[][] maze, int[] entrance) {
        Objects.requireNonNull(maze, "Maze cannot be null");
        Objects.requireNonNull(entrance, "entrance cannot be null");
        if(maze.length==0 || maze[0].length==0) {
            throw new IllegalArgumentException("Maze dimensions must be greater than 0");
        }
        if(entrance.length!=2) {
            throw new IllegalArgumentException("Entrance must contain exactly 2 elements [row, col]");
        }
        int r = entrance[0];
        int c = entrance[1];
        if(r<0 || r>=maze.length || c<0 || c>=maze[0].length) {
            throw new IndexOutOfBoundsException("Entrance indices are out of maze bounds");
        }

    }
}
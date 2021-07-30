package life;

import java.util.Random;

public class GameOfLife {
    // initialize variable
    private int len;
    private int seed;
    private int generation;
    private final char ALIVE = 'O';
    private final char DEAD = ' ';
    private char[][] universe;

    public GameOfLife(int len,int seed, int generation) {
        this.len = len;
        this.seed = seed;
        this.generation = generation;
        universe = new char[len][len];
        createBoard();

    }
    private void createBoard() {
        Random random = new Random(seed);
        for (int i =0;i<len;i++) {
            for (int j =0;j<len;j++) {
                if (random.nextBoolean()) universe[i][j] = ALIVE;
                else {
                    universe[i][j] = DEAD; } } }
    }

    public void print() {
        for (int i =0;i<len;i++) {
            for (int j=0;j<len;j++) {
                System.out.print(universe[i][j]);
            } System.out.println("");
        }
    }
    public void findGeneration() {
        while (generation > 0) {
            doBoardOperation();
            generation -=1;
        }
    }

    private void doBoardOperation() {
        char[][] copy = new char[len][len];
        for (int i =0;i<len;i++) {
            for (int j =0;j<len;j++) {
                int neighbors = numberOfNeighbor(i,j);
                if (neighbors == 3) copy[i][j] = ALIVE;
                else if (neighbors == 2) copy[i][j] = universe[i][j];
                else {
                    copy[i][j] = DEAD;
                }
            }
        }
        universe = copy;

    }

    private int numberOfNeighbor(int a, int b) {
        int count = 0;
        for (int i =-1;i<=1;i++) {
            for (int j =-1;j<=1;j++) {
                if (i == 0 && j == 0) continue;
                if (checkLive(a+i,b+j)) count +=1;
            }
        }
        return count;
    }

    private boolean checkLive(int row, int col) {
      int maxLen = len - 1;
      if (row < 0) row = maxLen;
      if (row > maxLen) row = 0;
      if (col < 0) col = maxLen;
      if (col > maxLen) col = 0;
      return universe[row][col] == ALIVE;
    }
}

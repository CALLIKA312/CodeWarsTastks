package Codewars.ConwayLife;

import java.util.Arrays;

public class ConwayLife {


    static int rowSize;
    static int colSize;

    public static void main(String[] args) {
        int[][][] gliders = {
                {{1, 0, 0},
                        {0, 1, 1},
                        {1, 1, 0}},
                {{0, 1, 0},
                        {0, 0, 1},
                        {1, 1, 1}}
        };
        System.out.println(Arrays.deepToString(gliders[0]));
        System.out.println(Arrays.deepToString(getGeneration(gliders[0], 1)));
    }

    public static int[][] getGeneration(int[][] cells, int generations) {
        if (cells == null) return cells;
        rowSize = cells.length;
        colSize = cells[0].length;
        int[][] newCells = new int[rowSize + 2][colSize + 2];
        for (int i = 1; i < rowSize - 1; i++) {
            if (colSize - 1 - 1 >= 0) System.arraycopy(cells[i], 1, newCells[i], 1, colSize - 1 - 1);
        }
        for (int i = 0; i < generations; i++) {
            newCells = makeIteration(newCells);
        }
        return newCells;
    }

    public static int[][] makeIteration(int[][] cells) {
        int[][] newCells = new int[rowSize + 2][colSize + 2];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                int neighbours = countNeighbours(i, j, cells);
                if (cells[i][j] == 1) {
                    if (neighbours < 2) newCells[i][j] = 0;
                    else if (neighbours > 3) newCells[i][j] = 0;
                    else if (neighbours == 2 || neighbours == 3) newCells[i][j] = 1;
                } else if (cells[i][j] == 0 && neighbours == 3) newCells[i][j] = 1;
            }
        }
        return newCells;
    }

    public static int countNeighbours(int i, int j, int[][] cells) {
        int count = 0;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (k == 0 && l == 0) continue;
                int xPos = i + k;
                int yPos = j + l;
                if (xPos > rowSize - 1) continue;
                if (xPos < 0) continue;
                if (yPos > colSize - 1) continue;
                if (yPos < 0) continue;
                if (cells[xPos][yPos] == 1) count++;
            }
        }
        return count;
    }


//    public static int countNeighbours(int i, int j, int[][] cells) {
//        int count = 0;
//        for (int k = -1; k < 2; k++) {
//            for (int l = -1; l < 2; l++) {
//                if (k == 0 && l == 0) continue;
//                int xPos = i + l;
//                int yPos = j + k;
//                if (xPos > rowSize - 1) xPos = 0;
//                if (xPos < 0) xPos = rowSize - 1;
//                if (yPos > colSize - 1) yPos = 0;
//                if (yPos < 0) yPos = colSize - 1;
//                if (cells[xPos][yPos] == 1) count++;
//            }
//        }
//        return count;
//    }

}

class Solution {

    public boolean isMagic(int[][] grid, int row, int col) {
        // Validate that all numbers are in the range [1, 9]
        boolean[] digits = new boolean[10];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || digits[num]) {
                    return false;
                }
                digits[num] = true;
            }
        }

        // Check the sum of rows, columns, and diagonals
        int sum1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int sum2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
        int sum3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];
        int sum4 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int sum5 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
        int sum6 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];
        int sumDiag1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int sumDiag2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];

        return sum1 == 15 && sum2 == 15 && sum3 == 15 && sum4 == 15 && 
               sum5 == 15 && sum6 == 15 && sumDiag1 == 15 && sumDiag2 == 15;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (grid[i + 1][j + 1] == 5) { // center of the magic square must be 5
                    if (isMagic(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

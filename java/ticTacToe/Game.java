package ticTacToe;

import javafx.scene.control.Button;

public class Game {
    private char turn;
    private final Button[][] grid;

    public Game() {
        this.turn = 'X';
        this.grid = new Button[3][3];
    }

    public char getTurn() {
        return this.turn;
    }

    public Button[][] getGrid() {
        return this.grid;
    }

    public void handleMove(int row, int col) {
        if (this.grid[row][col].getText().equals(" ")) {
            this.grid[row][col].setText("" + getTurn());
            switchTurn();
        }
    }

    public void switchTurn() {
        this.turn = this.turn == 'X' ? 'O' : 'X';
    }

    public boolean win() {
        // horizontal check
        for (int row = 0; row < 3; row++) {
            int col = 0;
            if (grid[row][col].getText().equals(grid[row][col + 1].getText())
                    && grid[row][col].getText().equals(grid[row][col + 2].getText())) {
                if (!grid[row][col].getText().equals(" ")) {
                    return true;
                }

            }
        }

        // vertical check
        for (int col = 0; col < 3; col++) {
            int row = 0;
            if (grid[row][col].getText().equals(grid[row + 1][col].getText())
                && grid[row][col].getText().equals(grid[row + 2][col].getText())) {
                if (!grid[row][col].getText().equals(" ")) {
                    return true;
                }
            }
        }

        // diagonal check
        if (grid[0][0].getText().equals(grid[1][1].getText())
                && grid[0][0].getText().equals(grid[2][2].getText())) {
            if (!grid[0][0].getText().equals(" ")) {
                return true;
            }
        }
        if (grid[0][2].getText().equals(grid[1][1].getText())
                && grid[0][2].getText().equals(grid[2][0].getText())) {
            if (!grid[0][2].getText().equals(" ")) {
                return true;
            }
        }

        return false;
    }

}

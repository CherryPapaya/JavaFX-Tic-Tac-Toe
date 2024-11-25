package ticTacToe;

import javafx.scene.control.Button;

public class Game {
    private char turn;
    private final Button[][] grid;
    private int numberOfMoves;

    public Game() {
        this.turn = 'X';
        this.grid = new Button[3][3];
        this.numberOfMoves = 0;
    }

    public char getTurn() {
        return this.turn;
    }

    public Button[][] getGrid() {
        return this.grid;
    }

    public int getNumberOfMoves() {
        return this.numberOfMoves;
    }

    public void handleMove(int row, int col) {
        if (this.grid[row][col].getText().equals(" ")) {
            this.grid[row][col].setText("" + getTurn());
            numberOfMoves++;
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
            if (this.grid[row][col].getText().equals(this.grid[row][col + 1].getText())
                    && this.grid[row][col].getText().equals(this.grid[row][col + 2].getText())) {
                if (!this.grid[row][col].getText().equals(" ")) {
                    return true;
                }

            }
        }

        // vertical check
        for (int col = 0; col < 3; col++) {
            int row = 0;
            if (this.grid[row][col].getText().equals(this.grid[row + 1][col].getText())
                && this.grid[row][col].getText().equals(this.grid[row + 2][col].getText())) {
                if (!this.grid[row][col].getText().equals(" ")) {
                    return true;
                }
            }
        }

        // diagonal check
        if (this.grid[0][0].getText().equals(this.grid[1][1].getText())
                && this.grid[0][0].getText().equals(this.grid[2][2].getText())) {
            if (!this.grid[0][0].getText().equals(" ")) {
                return true;
            }
        }
        if (this.grid[0][2].getText().equals(this.grid[1][1].getText())
                && this.grid[0][2].getText().equals(this.grid[2][0].getText())) {
            if (!this.grid[0][2].getText().equals(" ")) {
                return true;
            }
        }

        return false;
    }
}

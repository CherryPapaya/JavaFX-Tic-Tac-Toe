package ticTacToe;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {
    Game game = new Game();
    @Override
    public void start(Stage window) throws Exception {

        BorderPane layout = new BorderPane();
        Label label = new Label("Turn: " + game.getTurn());
        Font font = new Font("Courier New", 40);

        GridPane grid = new GridPane();

        layout.setPadding(new Insets(10, 10, 10, 10));
        grid.setAlignment(Pos.CENTER);

        label.setFont(font);
        layout.setTop(label);
        layout.setCenter(grid);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                game.getGrid()[row][col] = new Button(" ");

                grid.add(game.getGrid()[row][col], col, row);
                game.getGrid()[row][col].setFont(font);

                int r = row;
                int c = col;
                game.getGrid()[row][col].setOnAction((event) -> {
                    game.handleMove(r, c);
                    label.setText("Turn: " + game.getTurn());
                    if (game.win()) {
                        label.setText("The end!");
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                game.getGrid()[i][j].setOnAction((null));
                            }
                        }
                    }
                });

            }
        }


        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    // hello there
}

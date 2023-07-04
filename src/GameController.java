import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameController implements ActionListener {

    boolean game_over; //bool to determine if game has ended
    String symbol = "";
    boolean turn_x; //bool to determine player of current turn
    boolean computerPlaying = false; // bool to determine game mode - 1 vs 1 or 1 vs Computer
    Random random = new Random();

    int[][] winConditions = {
            {0, 1, 2}, // Rows
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6}, // Columns
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8}, // Diagonals
            {2, 4, 6}
    };

    GameUI gameUI;

    public void setGameUI(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    public GameController() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void moveMade() {
        check();
        if (turn_x) {
            turn_x = false;
            symbol = "O";
        } else {
            turn_x = true;
            symbol = "X";
        }
        if(!game_over && computerPlaying) {
            computerMove();
        }
    }

    public void check() {
        for (int[] condition : winConditions) {
            if (gameUI.buttons[condition[0]].getText().equals(symbol) &&
                gameUI.buttons[condition[1]].getText().equals(symbol) &&
                gameUI.buttons[condition[2]].getText().equals(symbol))
            {
                game_over = true;
                gameUI.gameWon(condition[0], condition[1], condition[2]);
                break; // Exit the loop if a win condition is found
            }
        }

        //calculate if game is a draw
        int counter = 0;
        for (JButton button : gameUI.buttons) {
            if (!button.getText().equals("")) {
                counter++;
            }
        }
        if (counter == 9 && !game_over){
            game_over = true;
            gameUI.gameDrawn();
        }
    }

    public void firstTurn() {
        //give random player first turn
        game_over = false;
        if(random.nextBoolean()) {
            turn_x = true;
            symbol = "X";
            gameUI.label_turn.setText("X begins");
            gameUI.label_turn.setForeground(gameUI.custom_red);
            if(gameUI.button_player.getBackground() == gameUI.custom_red){
                computerMove();
            }
        } else {
            turn_x = false;
            symbol = "O";
            gameUI.label_turn.setText("O begins");
            gameUI.label_turn.setForeground(gameUI.custom_blue);
            if(gameUI.button_player.getBackground() == gameUI.custom_blue){
                computerMove();
            }
        }
    }

    public void computerMove() {
        //so far, the computer just plays a random move
        //TODO improve quality Computer moves
        if(turn_x){
            playRandomMove();
            gameUI.label_turn.setText("O's turn");
            gameUI.label_turn.setForeground(gameUI.custom_blue);
            check();
            turn_x = false;
            symbol = "O";
        }else{
            playRandomMove();
            gameUI.label_turn.setText("X's turn");
            gameUI.label_turn.setForeground(gameUI.custom_red);
            check();
            turn_x = true;
            symbol = "X";
        }
    }

    public void playRandomMove() {
        //Plays a random move - used for playing against computer
        JButton[] candidates = new JButton[9];
        int candidates_counter = 0;
        for (JButton button : gameUI.buttons) {
            if (button.getText().equals("")) {
                candidates[candidates_counter] = button;
                candidates_counter++;
            }
        }
        int buttonNr = random.nextInt(candidates_counter);
        candidates[buttonNr].setText(symbol);
        if(turn_x) {
            candidates[buttonNr].setForeground(gameUI.custom_red);
            //audioPlayer.playSound("src/Audio/Cross.wav");
        }else{
            candidates[buttonNr].setForeground(gameUI.custom_blue);
            //audioPlayer.playSound("src/Audio/Circle.wav");
        }
    }
}

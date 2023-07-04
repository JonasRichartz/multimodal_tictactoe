public class Main {

    public static void main(String[] args) {
        //TicTacToe tictactoe = new TicTacToe();

        GameController gameController = new GameController();
        GestureFrame gestureFrame = new GestureFrame(gameController);
        GameUI gameUI = new GameUI( gameController, gestureFrame );
        gameController.setGameUI(gameUI);
        gameController.firstTurn();
    }
}

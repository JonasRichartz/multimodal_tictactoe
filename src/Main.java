public class Main {

    public static void main(String[] args) {
        //TicTacToe tictactoe = new TicTacToe();

        GameController gameController = new GameController();
        GestureFrame gestureFrame = new GestureFrame(gameController);
        MmiFrame mmiFrame = new MmiFrame(gameController);
        GameUI gameUI = new GameUI(gameController, gestureFrame, mmiFrame);
        gameController.setGameUI(gameUI);
        gameController.firstTurn();
    }
}

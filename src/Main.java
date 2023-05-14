public class Main {

    public static void main(String[] args) {
        //TicTacToe tictactoe = new TicTacToe();

        GameController gameController = new GameController();
        GameUI gameUI = new GameUI( gameController );
        gameController.setGameUI(gameUI);
        gameController.firstTurn();
    }
}

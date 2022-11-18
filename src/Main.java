public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        board.startGame();
        board.firstMove(1,1);
        board.move("Reveal",0,0);
    }
}
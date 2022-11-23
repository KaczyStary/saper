import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        for (int i = 0; i < 100; i++) {
//            Board board = new Board();
//            board.startGame();
//            board.firstMove(1,1);
//        }

        Board board = new Board();
        board.startGame();
        board.firstMove();
        board.move();

//        Scanner scan = new Scanner(System.in);
//        String z=scan.nextLine();
//        int x=scan.nextInt();
//        int y=scan.nextInt();
//        board.move(z,x,y);
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner switchMenu = new Scanner(System.in);

        System.out.println("1. Start ");
        System.out.println("2. Exit");
        System.out.println("3. ");
        int switchCaseMenu=switchMenu.nextInt();

        switch (switchCaseMenu){
            case 1:{
                board.setBoard();
                board.startGame();
                board.firstMove();
                board.move();
            }
            case 2:{
                break;
            }
            case 3:{

            }
        }
    }
}
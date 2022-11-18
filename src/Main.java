public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        board.fillFields();
        System.out.println("Ilosc bomb: "+board.numberOfBombs());

        board.showFieldsStatus();
        System.out.println();
        board.showFieldBoard();
        board.toggleFlag(1,1);
        board.toggleReveal(1,1);

        board.toggleBomb(1,1);
        board.toggleBomb(1,0);
        board.toggleBomb(0,1);

        board.showFieldBoard();
        board.bombsLeftInfo();
        board.bombsAroundFieldInfo(0,0);
    }
}
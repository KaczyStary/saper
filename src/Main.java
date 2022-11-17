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
        board.showFieldBoard();
        board.bombsLeftInfo();

    }
}
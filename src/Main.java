public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        board.fillFields();

        //System.out.println("Ilosc bomb: "+board.numberOfBombs());
        //board.showFieldsStatus();

        board.showFieldBoard();
        board.toggleFlag(1,1);
        board.toggleReveal(1,1);

        board.toggleBomb(0,0);
        board.toggleBomb(1,1);
        board.toggleBomb(1,0);
        board.toggleBomb(0,1);

        board.toggleBomb(7,7);
        board.toggleBomb(8,7);
        board.toggleBomb(7,8);
        board.toggleBomb(8,8);
        board.toggleBomb(6,8);
        board.toggleBomb(7,6);
        board.toggleBomb(6,6);
        board.toggleBomb(6,7);
        board.toggleBomb(8,6);

        board.showFieldBoard();
        board.bombsLeftInfo();
        board.bombsAroundFieldInfo(0,0);
        board.bombsAroundFieldInfo(7,7);
        board.bombsAroundFieldInfo(8,8);
        board.bombsAroundFieldInfo(8,0);
        board.bombsAroundFieldInfo(0,8);

    }
}
import java.util.Random;
import java.util.Scanner;

public class Board {

    Field field = new Field(); //funkcje
    Field[][] fields; //tablica planszy
    Scanner fieldInput = new Scanner(System.in);

    int setHeight(){
        int height=fieldInput.nextInt();
        field.setHeight(height);
        return field.getHeight();
    }

    int setWidth(){
        int width=fieldInput.nextInt();
        field.setWidth(width);
        return field.getWidth();
    }

    void infoDifficluty(){
        System.out.println("1. Easy (10% of board filled with mines)");
        System.out.println("2. Medium (20% of board filled with mines)");
        System.out.println("3. Hard (30% of board filled with mines)");
    }
    double setDifficulty(){
        infoDifficluty();
        int difficulty=fieldInput.nextInt();
        switch(difficulty){
            case 1:{
                field.setDifficulty(0.1);
                break;
            }
            case 2:{
                field.setDifficulty(0.2);
                break;
            }
            case 3:{
                field.setDifficulty(0.3);
                break;
            }
        }
        return field.getDifficulty();
    }

    void setBoard(){
        System.out.print("set width of a board: ");
        setWidth();
        System.out.print("set height of a board: ");
        setHeight();
        System.out.println("set difficulty of a game: ");
        setDifficulty();
    }

    int numberOfBombs(){
        field.setNumberOfBombs((int) (field.getWidth()*field.getHeight()*field.getDifficulty()));
        return field.getNumberOfBombs();
    }

    void toggleFlag(int x, int y){
        if(!fields[x][y].isRevealed()) {
            if (fields[x][y].isFlag()) {
                fields[x][y].setFlag(false);
            } else if (!fields[x][y].isFlag()) {
                fields[x][y].setFlag(true);
            }
        }else{
            System.out.println("field already revealed, nthng to do");
        }
    }

    void toggleReveal(int height, int width){
        if (!fields[height][width].isFlag()&&!fields[height][width].isRevealed()) {
            fields[height][width].setRevealed(true);
        }
    }

    void toggleBomb(int x, int y){
        fields[x][y].setBomb(true);
    }

    void fillFields(){

        fields = new Field[field.getHeight()][field.getWidth()];

        //tworzymy obiekty w tablicy
        for (int i = 0; i < field.getHeight(); i++) {
            for (int j = 0; j < field.getWidth(); j++) {
                fields[i][j]=new Field();
            }
        }

        //wypelnaimy obiekty w tablicy
        for (int i = 0; i < (field.getHeight()); i++) {
            for (int j = 0; j < (field.getWidth()); j++) {
                fields[i][j].setFlag(false);
                fields[i][j].setRevealed(false);
                fields[i][j].setBomb(false);
            }
        }
    }

    void fillFieldsBombs(){
        field.setBombs(0);
        while (field.getBombs()<numberOfBombs()){
            Random random1 = new Random();
            int rand1=random1.nextInt(field.getHeight());

            Random random2 = new Random();
            int rand2=random2.nextInt(field.getWidth());

            if(!fields[rand1][rand2].isBomb()&&!fields[rand1][rand2].isRevealed()){
                    fields[rand1][rand2].setBomb(true);
                    field.setBombs(field.getBombs()+1);

            }
        }
    }

    void showFieldBoard(){

        for (int i = 0; i < field.getHeight(); i++) {
            System.out.print(" i"+i+"  ");
                for (int j=0 ; j < field.getHeight(); j++) {
                System.out.print("{");
                    if (!fields[i][j].isFlag()){
                        System.out.print("_");
                    } else if (fields[i][j].isFlag()) {
                        System.out.print("F");
                    }
                    if (!fields[i][j].isRevealed()){
                        System.out.print("_");
                    }else if (fields[i][j].isRevealed()) {
                        System.out.print(bombsAroundField(i,j));
                    }
                    if (!fields[i][j].isBomb()){
                        System.out.print("_");
                    }else{
                        System.out.print("B");
                    }
                System.out.print("}");

                    if (i == (fields.length-1)&&j==(fields.length)-1){
                        System.out.println();
                    for (int k = 0; k < fields.length; k++) {
                        if (k==0){
                            System.out.print("     ");
                        }
                    System.out.print(" j"+k+"  ");
                }
            }
        }
        System.out.println();
    }
}

    int bombsLeft(){
        int bombsLeft;
        bombsLeft=0;
        for (int i = 0; i < field.getHeight(); i++) {
            for (int j = 0; j < field.getWidth(); j++) {
                if(fields[i][j].isBomb()){
                    bombsLeft++;
                }
            }
        }

        for (int i = 0; i < field.getHeight(); i++) {
            for (int j = 0; j < field.getWidth(); j++) {
                if(fields[i][j].isBomb()&&fields[i][j].isFlag()){
                    bombsLeft--;
                }
            }
        }

        return bombsLeft;
    }

    void updateBombStatus(){
        bombsLeft();
        if (bombsLeft()==0){
            field.setGameOver(true);
        }
    }

    void bombsLeftInfo(){
        System.out.println("There is "+bombsLeft()+" mines left on board");
    }

    int bombsAroundField(int x, int y){
        int bombsaroundfield=0;

        for (int i = (x-1); i < (x+2); i++) {
            for (int j = (y-1); j < (y+2) ; j++) {
                if(i<0||j<0||i>field.getHeight()||j>field.getWidth()) {
                    //skip
                }else if (fields[i][j].isBomb()){
                    bombsaroundfield+=1;
                }
            }
        }
        if (fields[x][y].isBomb()&&fields[x][y].isFlag()){
            bombsaroundfield-=1;
        }
        
        return bombsaroundfield;
    }

    void bombsAroundFieldInfo(int x, int y){
        System.out.println("ilosc bomb wokol pola "+"["+x+","+y+"]: "+bombsAroundField(x,y));
    }
    void startGame(){
        fillFields();
        showFieldBoard();
    }

    void firstMove(){
        System.out.println("FIRST MOVE");
        System.out.print("input i: ");
        field.setMoveX(fieldInput.nextInt());
        System.out.print("input j: ");
        field.setMoveY(fieldInput.nextInt());
          toggleReveal(field.getMoveX(), field.getMoveY());
          fillFieldsBombs();
          bombsLeftInfo();
          showFieldBoard();
    }

    void move(){
          while (!field.isGameOver()){
            System.out.println("what do u want to do: ");
            System.out.println("1. toggleFlag");
            System.out.println("2. revealField");
            System.out.println("3. quitGame");

            int playerMove = fieldInput.nextInt();

            switch (playerMove){
                case 1: {
                    System.out.print("case 1, input i ");
                    field.setMoveX(fieldInput.nextInt());
                    System.out.print("case 1, input j");
                    field.setMoveY(fieldInput.nextInt());
                    toggleFlag(field.getMoveX(), field.getMoveY());
                    break;
                }
                case 2: {
                    System.out.print("case 2, input i ");
                    field.setMoveX(fieldInput.nextInt());
                    System.out.print("case 2, input j");
                    field.setMoveY(fieldInput.nextInt());
                    toggleReveal(field.getMoveX(), field.getMoveY());
                    break;
                }
                case 3: {
                    return;
                }
            }
            gameStatus(field.getMoveX(),field.getMoveY());
            bombsLeftInfo();
            showFieldBoard();

        }
        showFieldBoard();
        if (bombsLeft()==0){
            System.out.println("Win");
        }else {
            System.out.println("Lose");
        }
    }

    void gameStatus(int a, int b){
        if (fields[a][b].isRevealed()&&fields[a][b].isBomb()){
            field.setGameOver(true);
        }
        updateBombStatus();
    }
}

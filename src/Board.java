import java.util.Random;
import java.util.Scanner;

public class Board {

    int x=9;
    int y=9;
    boolean gameOver=false;

    Field[][] fields;

    int numberOfBombs(){
        int numberOfFields=fields.length* fields.length;
        int numberOfBombs;
        numberOfBombs= (int) (numberOfFields*0.2);
        return numberOfBombs;
    }

    void toggleFlag(int x, int y){

        if(fields[x][y].isFlag()){
            fields[x][y].setFlag(false);
        }else if (!fields[x][y].isFlag()){
            fields[x][y].setFlag(true);
        }
    }

    void toggleReveal(int x, int y){
        this.x=x;
        this.y=y;
        fields[x][y].setRevealed(true);
    }

    void toggleBomb(int x, int y){
        this.x=x;
        this.y=y;
        fields[x][y].setBomb(true);
    }

void fillFields(){

    fields = new Field[x][y];

    //tworzymy obiekty w tablicy
    for (int i = 0; i < fields.length; i++) {
        for (int j = 0; j < fields.length; j++) {
            fields[i][j]=new Field();
        }
    }

    //wypelnaimy obiekty w tablicy
    for (int i = 0; i < (fields.length); i++) {
        for (int j = 0; j < (fields.length); j++) {
            fields[i][j].setFlag(false);
            fields[i][j].setRevealed(false);
            fields[i][j].setBomb(false);
        }
    }
}

    void fillFieldsBombs(){
//        for (int i = 0; i < numberOfBombs();) {
//
//            Random random1 = new Random();
//            int rand1=random1.nextInt(fields.length);
//
//            Random random2 = new Random();
//            int rand2=random2.nextInt(fields.length);
//
//            for (int j = 0; j < fields.length; j++) {
//                for (int k = 0; k < fields.length; k++) {
//                    if (!fields[rand1][rand2].isBomb()){
//                        if (!fields[j][k].isRevealed()) {
//                            fields[rand1][rand2].setBomb(true);
//                            i++;
//                        }
//                    }
//                }
//            }
//        }
        int xd=0;
        while (xd<numberOfBombs()){
            Random random1 = new Random();
            int rand1=random1.nextInt(fields.length);

            Random random2 = new Random();
            int rand2=random2.nextInt(fields.length);

            if(!fields[rand1][rand2].isBomb()&&!fields[rand1][rand2].isRevealed()){
//                    System.out.println("ustawiam bombe");
//                    System.out.println("rand1: "+rand1);
//                    System.out.println("rand2: "+rand2);
                    fields[rand1][rand2].setBomb(true);
                    xd++;

            }
        }
    }

    void showFieldBoard(){
        int j;
        for (int i = 0; i < fields.length; i++) {
            System.out.print(" i"+i+"  ");
                for (j=0 ; j < fields.length; j++) {
                System.out.print("{");
                    if (!fields[i][j].isFlag()){
                        System.out.print(".");
                    } else if (fields[i][j].isFlag()) {
                        System.out.print("F");
                    }
                    if (!fields[i][j].isRevealed()){
                        System.out.print(".");
                    }else if (fields[i][j].isRevealed()) {
                        System.out.print(bombsAroundField(i,j));
                    }
                    if (!fields[i][j].isBomb()){
                        System.out.print(".");
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
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                if(fields[i][j].isBomb()){
                    bombsLeft++;
                }
            }
        }

        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
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
            gameOver=true;
        }
    }

    void bombsLeftInfo(){
        System.out.println("There is "+bombsLeft()+" mines left on board");
    }

    int bombsAroundField(int x, int y){
        int bombsaroundfield=0;

        for (int i = (x-1); i < (x+2); i++) {
            for (int j = (y-1); j < (y+2) ; j++) {
                if(i<0||j<0||i>8||j>8) {
                    //skip
                }else if (fields[i][j].isBomb()){
                    bombsaroundfield+=1;
                }
            }
        }
        if (fields[x][y].isBomb()){
            bombsaroundfield-=1;
        }
        
        return bombsaroundfield;
    }

    void bombsAroundFieldInfo(int x, int y){
        System.out.println("ilosc bomb wokol pola "+"["+x+","+y+"]: "+bombsAroundField(x,y));
    }

    void showFieldsStatus(){
        int z=1;
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                System.out.print("Czy pole nr "+z+" jest odkryte: ");
                System.out.println(fields[i][j].isRevealed());
                System.out.print("Czy pole nr "+z+" zawiera flage: ");
                System.out.println(fields[i][j].isFlag());
                System.out.print("Czy pole nr "+z+" zawiera bombe: ");
                System.out.println(fields[i][j].isBomb());
                System.out.println();
                z=z+1;
            }
        }
    }

    void startGame(){
        fillFields();
        showFieldBoard();
    }

    void firstMove(){
        Scanner scan = new Scanner(System.in);
        System.out.println("podaj i: ");
        int x=scan.nextInt();
        System.out.println("podaj j: ");
        int y=scan.nextInt();
          toggleReveal(x,y);
          fillFieldsBombs();
          showFieldBoard();
    }

    void move(){
        int a=0;
        int b=0;

        while (!gameOver){
            Scanner scanner = new Scanner(System.in);

            System.out.println("what do u want to do: ");
            System.out.println("1. toggleFlag");
            System.out.println("2. revealField");
            System.out.println("3. bombsLeft");

            int playerMove = scanner.nextInt();

            switch (playerMove){
                case 1: {
                    System.out.println("case 1, input i ");
                    a = scanner.nextInt();
                    System.out.println("case 1, input j");
                    b = scanner.nextInt();
                    toggleFlag(a, b);
                    break;
                }
                case 2: {
                    System.out.println("case 2, input i ");
                    a = scanner.nextInt();
                    System.out.println("case 2, input j");
                    b = scanner.nextInt();
                    toggleReveal(a, b);
                    break;
                }
                case 3: {
                    bombsLeftInfo();
                    break;
                }
            }

            gameStatus(a,b);
            showFieldBoard();

        }
        showFieldBoard();
        if (bombsLeft()==0){
            System.out.println("Win");
        }else {
            System.out.println("Lose");
        }

        return;
    }

    void gameStatus(int a, int b){
        if (fields[a][b].isRevealed()&&fields[a][b].isBomb()){
            gameOver=true;
        }
        updateBombStatus();
    }

//    boolean gameOverFinal(){
//
//       boolean gameOver = false;
//        for (int i = 0; i < fields.length; i++) {
//            for (int j = 0; j < fields.length; j++) {
//                if (fields[i][j].isRevealed()&&fields[i][j].isBomb()){
//                    gameOver=true;
//                }else {
//                    gameOver=false;
//                }
//            }
//        }
//
//        return gameOver;
//    }
}

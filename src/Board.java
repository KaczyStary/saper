import java.util.Random;

public class Board {

    Field[][] fields;

    int numberOfBombs(){
        int numberOfFields=fields.length* fields.length;
        int numberOfBombs;
        numberOfBombs= (int) (numberOfFields*0.2);
        return numberOfBombs;
    }

void fillFields(){

    fields = new Field[9][9];

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

    for (int i = 0; i < numberOfBombs();) {

        Random random1 = new Random();
        int rand1=random1.nextInt(fields.length);

        Random random2 = new Random();
        int rand2=random2.nextInt(fields.length);


        if (fields[rand1][rand2].isBomb()==false){
            fields[rand1][rand2].setBomb(true);
            i++;
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
            }
            if (!fields[i][j].isRevealed()){
                System.out.print(".");
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

}

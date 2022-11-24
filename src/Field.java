public class Field {

    private boolean bomb;
    private boolean revealed;
    private boolean flag;
    private int width;
    private int height;
    private boolean gameOver=false;
    private double difficulty;
    private int numberOfBombs;
    private int bombs;
    private int moveX;
    private int moveY;
    public int getMoveX() {
        return moveX;
    }

    public void setMoveX(int moveX) {
        if (moveX>=0&&moveX<=getHeight()) {
            this.moveX = moveX;
        }else {
            System.out.println("liczba niepoprawna");
        }
    }

    public int getMoveY() {
        return moveY;
    }

    public void setMoveY(int moveY) {
        if (moveY>=0&&moveY<=getWidth()) {
            this.moveY = moveY;
        }else {
            System.out.println("liczba niepoprawna");
        }
    }

    public int getBombs() {
        return bombs;
    }

    public void setBombs(int bombs) {
        this.bombs = bombs;
    }

    public int getNumberOfBombs() {
        return numberOfBombs;
    }

    public void setNumberOfBombs(int numberOfBombs) {
        this.numberOfBombs = numberOfBombs;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Field(boolean bomb, boolean revealed, boolean flag) {
        this.bomb = bomb;
        this.revealed = revealed;
        this.flag = flag;
    }

    public Field() {

    }
}

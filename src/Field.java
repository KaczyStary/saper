public class Field {

    private boolean bomb;
    private boolean revealed;
    private boolean flag;

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

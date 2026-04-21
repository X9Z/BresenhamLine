public class SelectedPixel {
    private int x;
    private int y;
    private boolean marked;

    public SelectedPixel() {
    }

    public void mark(int x, int y){
        if (x >= 0 && y >= 0){
            setX(x);
            setY(y);
            setMarked(true);
        }
    }

    public void unMark(){
        setX(-1);
        setY(-1);
        setMarked(false);
    }

    public boolean isPixelMarked(){
        if (getX() >= 0 && getY() >= 0 && isMarked()){
            return true;
        } else {
            return false;
        }
    }



    private int getX() {
        return x;
    }

    private void setX(int x) {
        this.x = x;
    }

    private int getY() {
        return y;
    }

    private void setY(int y) {
        this.y = y;
    }

    private boolean isMarked() {
        return marked;
    }

    private void setMarked(boolean marked) {
        this.marked = marked;
    }

    @Override
    public String toString() {
        return "SelectedPixel{" +
                "x=" + x +
                ", y=" + y +
                ", marked=" + marked +
                '}';
    }
}

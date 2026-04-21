import java.util.ArrayList;

public class Line implements Runnable {
    private ArrayList<PaintingPixelData> backgroundGraphics = new ArrayList<>();
    private ArrayList<PaintingPixelData> foregroundGraphics = new ArrayList<>();
    private int cellSize;
    private int numberOfRectOnXAxis;
    private int numberOfRectOnYAxis;

    public Line(ArrayList<PaintingPixelData> backgroundGraphics, ArrayList<PaintingPixelData> foregroundGraphics, int cellSize, int numberOfRectOnXAxis, int numberOfRectOnYAxis) {
        this.backgroundGraphics = backgroundGraphics;
        this.foregroundGraphics = foregroundGraphics;
        this.cellSize = cellSize;
        this.numberOfRectOnXAxis = numberOfRectOnXAxis;
        this.numberOfRectOnYAxis = numberOfRectOnYAxis;
    }

    @Override
    public void run() {

    }
}

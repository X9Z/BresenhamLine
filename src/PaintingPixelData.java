import java.awt.*;

public class PaintingPixelData {
    private int pixelIndex;
    private boolean burned;
    private Color color;

    public PaintingPixelData() {
    }

    public PaintingPixelData(int pixelIndex, boolean burned, Color color) {
        this.pixelIndex = pixelIndex;
        this.burned = burned;
        this.color = color;
    }

    public int getPixelIndex() {
        return pixelIndex;
    }

    public void setPixelIndex(int pixelIndex) {
        this.pixelIndex = pixelIndex;
    }

    public boolean isBurned() {
        return burned;
    }

    public void setBurned(boolean burned) {
        this.burned = burned;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

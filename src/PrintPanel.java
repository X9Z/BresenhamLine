import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class PrintPanel extends JPanel {
    private boolean painting;

    public boolean isPainting() {
        return painting;
    }

    public void setPainting(boolean painting) {
        this.painting = painting;
    }

    private ArrayList<PaintingPixelData> backgroundGraphics = new ArrayList<>();
    private ArrayList<PaintingPixelData> foregroundGraphics = new ArrayList<>();
    private int cellSize;
    private int numberOfRectOnXAxis;
    private int numberOfRectOnYAxis;
    private SelectedPixel start = new SelectedPixel();
    private SelectedPixel end = new SelectedPixel();
    private ControlPanel.Controls controls;
    private Bresenham bresenham = new Bresenham();
    private Dimension dimension;
    int speed = 150;

    public PrintPanel(Dimension dimension){
        this.dimension = dimension;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (isPainting()){
                    JOptionPane.showMessageDialog(null, "Can't select any end until previous line is finished!", "Wait", JOptionPane.OK_CANCEL_OPTION, null);
                } else {
                    checker(e.getX(), e.getY());
                }
            }
        });

        // Set button controls
        setControls(new ControlPanel.Controls() {
            @Override
            public void burnPixel() {
                drawLine();
            }

            @Override
            public void clearForeground() {
                clearForegroundPaint();
            }

            @Override
            public void clearAll() {
                clearAllPaint();
            }

            @Override
            public void speed(int speed) {
                setSpeed(speed);
            }
        });

        init();
    }

    // Initialize background adn foreground
    private void init(){
        setSize(dimension);

        cellSize = Math.max((Math.min(dimension.width, dimension.height) / 30), 1);
        numberOfRectOnXAxis = dimension.width / cellSize;
        numberOfRectOnYAxis = dimension.height / cellSize;

        int pixelIndex = 0;
        for (int i = 0; i < numberOfRectOnXAxis; i++) {
            for (int j = 0; j < numberOfRectOnYAxis; j++) {
                backgroundGraphics.add(new PaintingPixelData(pixelIndex, false, Color.LIGHT_GRAY));
                foregroundGraphics.add(new PaintingPixelData(pixelIndex, false, Color.getColor("#FF000000")));
                pixelIndex ++;
            }
        }
    }

    // Check for click and click location
    public void checker(int x, int y) {
        int pixelIndex = 0;
        for (int i = 0; i < numberOfRectOnXAxis; i++) {
            for (int j = 0; j < numberOfRectOnYAxis; j++) {
                if (x > (i * cellSize) && x < ((i + 1) * cellSize) && y > (j * cellSize) && y < ((j + 1) * cellSize)) {
                    System.out.println("Clicked");
                    if (start.isPixelMarked() && end.isPixelMarked()){
                        clearForegroundPaint();
                        start.unMark();
                        end.unMark();
                        System.out.println("Marked");
                    }
                    if (!start.isPixelMarked()){
                        start.mark(i, j);
                        bresenham.setX0(i);
                        bresenham.setY0(j);
                        foregroundGraphics.set(pixelIndex, new PaintingPixelData(pixelIndex, true, Color.BLUE));
                        repaint();
                    } else if (!end.isPixelMarked()) {
                        end.mark(i, j);
                        bresenham.setXn(i);
                        bresenham.setYn(j);
                        bresenham.Loop();
                        foregroundGraphics.set(pixelIndex, new PaintingPixelData(pixelIndex, true, Color.BLUE));
                        repaint();
                    }

                }
                pixelIndex ++;
            }
        }
    }

    // Generate Frames
    private void generateFrames(Graphics2D g2) {

            int pixelIndex = 0;
            for (int i = 0; i < numberOfRectOnXAxis; i++) {
                for (int j = 0; j < numberOfRectOnYAxis; j++) {
                    // Background
                    g2.setColor(getBackgroundGraphics().get(pixelIndex).getColor());
                    g2.fillRect(i * cellSize, j * cellSize, cellSize - 1, cellSize - 1);

                    // Foreground
                    g2.setColor(getForegroundGraphics().get(pixelIndex).getColor());
                    g2.fillRect(i * cellSize, j * cellSize, cellSize - 1, cellSize - 1);

                    pixelIndex ++;

                }
            }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Anti-Aliasing
        Graphics2D g2 = (Graphics2D) g;
        generateFrames(g2);
    }

    public void BurnPixels(int X[], int Y[], int o) {
        setPainting(true);
        start.unMark();
        end.unMark();
        Color color = getRandomColor();
        new Thread(() -> {
            int index = 0;
            while (index != o) {
                int pixelIndex = 0;
                for (int i = 0; i < numberOfRectOnXAxis; i++) {
                    for (int j = 0; j < numberOfRectOnYAxis; j++) {
                        if (X[index] == i && Y[index] == j) {
                            getBackgroundGraphics().set(pixelIndex, new PaintingPixelData(pixelIndex, true, color));
                            getForegroundGraphics().set(pixelIndex, new PaintingPixelData(pixelIndex, true, color));
                        }
                        pixelIndex++;
                    }
                }
                delay(getSpeed());
                index++;
                repaint();
            }
            setPainting(false);
        }).start();
    }

    // Clear only the foreground
    public void clearForegroundPaint(){
        start.unMark();
        end.unMark();
        int pixelIndex = 0;
        for (int i = 0; i < numberOfRectOnXAxis; i++) {
            for (int j = 0; j < numberOfRectOnYAxis; j++) {
                getForegroundGraphics().set(pixelIndex, new PaintingPixelData(pixelIndex, false, Color.getColor("#FF000000")));
                pixelIndex ++;
            }
        }
        repaint();
    }

    // Clear all paint
    public void clearAllPaint(){
        start.unMark();
        end.unMark();
        int pixelIndex = 0;
        for (int i = 0; i < numberOfRectOnXAxis; i++) {
            for (int j = 0; j < numberOfRectOnYAxis; j++) {
                getBackgroundGraphics().set(pixelIndex, new PaintingPixelData(pixelIndex, false, Color.LIGHT_GRAY));
                getForegroundGraphics().set(pixelIndex, new PaintingPixelData(pixelIndex, false, Color.getColor("#FF000000")));
                pixelIndex ++;
            }
        }
        repaint();
    }

    // Start drawing the line
    private void drawLine(){
        if (start.isPixelMarked() && end.isPixelMarked()){
            BurnPixels(bresenham.ArrayOfX, bresenham.ArrayOfY, bresenham.j);
        } else {
            JOptionPane.showMessageDialog(null, "Please select both ends", "Missing", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    // Get random color every time
    public static Color getRandomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    // Get controls
    public ControlPanel.Controls getControls() {
        return controls;
    }
    // Set Controls
    public void setControls(ControlPanel.Controls controls) {
        this.controls = controls;
    }

    // Get Speed
    public int getSpeed() {
        return speed;
    }
    // Set Speed
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // GET BG GRAPHICS
    public ArrayList<PaintingPixelData> getBackgroundGraphics() {
        return backgroundGraphics;
    }
    // SET BG GRAPHICS
    public void setBackgroundGraphics(ArrayList<PaintingPixelData> backgroundGraphics) {
        this.backgroundGraphics = backgroundGraphics;
    }

    // GET FOREGROUND GRAPHICS
    public ArrayList<PaintingPixelData> getForegroundGraphics() {
        return foregroundGraphics;
    }
    // SET FOREGROUND GRAPHICS
    public void setForegroundGraphics(ArrayList<PaintingPixelData> foregroundGraphics) {
        this.foregroundGraphics = foregroundGraphics;
    }

    // Delay ms
    private void delay(int ms){
        try {
            Thread.sleep(getSpeed());
        } catch (Exception e) {

        }
    }
}

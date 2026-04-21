import javax.swing.*;
import java.awt.*;

public class PrintFrame extends JFrame {
    private Dimension dimension;
    private PrintPanel printPanel;
    public PrintFrame(Dimension dimension){
        this.dimension = dimension;
        init();
    }

    private void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(this.dimension);
        printPanel = new PrintPanel(dimension);
        add(printPanel);
        printPanel.setVisible(true);
        setVisible(true);
    }

    public void genFrame(){
        printPanel.repaint();
    }

    public ControlPanel.Controls getControls(){
        return printPanel.getControls();
    }
}

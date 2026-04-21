import javax.swing.*;

public class ControlFrame extends JFrame {
    public ControlFrame(ControlPanel.Controls controls){
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        ControlPanel controlPanel = new ControlPanel(controls);
        add(controlPanel);
        controlPanel.setVisible(true);
        setVisible(true);
        pack();
    }
}

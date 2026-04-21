import javax.swing.*;

public class ControlPanel extends JPanel {
    private Controls controls;
    private JButton burnPixel = new JButton("Burn Pixel");
    private JButton clearForeground = new JButton("Clear Foreground");
    private JButton clearAll = new JButton("Clear All");
    private JSlider slider = new JSlider(0, 400, 150); // min, max, initial
    private JTextField jTextField = new JTextField("Step delay: " + slider.getValue() + "ms");
    public ControlPanel(Controls controls){
        this.controls = controls;
        add(burnPixel);
        add(clearForeground);
        add(clearAll);
        add(jTextField);
        add(slider);

        burnPixel.setVisible(true);
        clearForeground.setVisible(true);
        clearAll.setVisible(true);
        jTextField.setVisible(true);
        slider.setVisible(true);
        setVisible(true);

        jTextField.setEditable(false);
        slider.addChangeListener(changeEvent -> {
            if (controls != null){
                jTextField.setText("Step delay: " + slider.getValue() + "ms");
                controls.speed(slider.getValue());
            }
        });

        burnPixel.addActionListener(actionEvent -> {
            if (controls != null){
                controls.burnPixel();
            }
        });

        clearForeground.addActionListener(actionEvent -> {
            if (controls != null){
                controls.clearForeground();
            }
        });

        clearAll.addActionListener(actionEvent -> {
            if (controls != null){
                controls.clearAll();
            }
        });
    }


    public interface Controls{
        void burnPixel();
        void clearForeground();
        void clearAll();
        void speed(int speed);
    }
}

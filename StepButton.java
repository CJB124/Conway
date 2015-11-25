import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StepButton extends JButton {

  private Conway _main;

  public StepButton(Conway main) {
    _main = main;

    setText("Step");
    addActionListener(new ButtonListener());
  }

  class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      _main.step();
    }
  }

}

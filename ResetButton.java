import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResetButton extends JButton {

  private Conway _main;

  public ResetButton(Conway main) {
    _main = main;

    setText("Reset");
    addActionListener(new ButtonListener());
  }

  class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      _main.pause();
      _main.reset();
    }
  }

}

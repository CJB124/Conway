import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RunButton extends JButton {

  private Conway _main;

  public RunButton(Conway main) {
    _main = main;

    setText("Run");
    addActionListener(new ButtonListener());
  }

  class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      _main.run();
    }
  }

}

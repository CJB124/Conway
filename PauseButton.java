import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PauseButton extends JButton {

  private Conway _main;

  public PauseButton(Conway main) {
    _main = main;

    setText("Pause");
    addActionListener(new ButtonListener());
  }

  class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      _main.pause();
    }
  }

}

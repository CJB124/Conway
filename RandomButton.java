import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RandomButton extends JButton {

  private Conway _main;

  public RandomButton(Conway main) {
    _main = main;

    setText("Randomize");
    addActionListener(new ButtonListener());
  }

  class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      _main.random();
    }
  }

}

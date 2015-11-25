import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cell extends JButton {

  private boolean _alive = false;

  public Cell() {
    setBackground(Color.WHITE);
    setBorderPainted(true);
    setFocusPainted(false);
    setFont(new Font("Arial", Font.BOLD, 10));
    addActionListener(new CellListener());
  }

  public void setAlive(boolean alive) {
    _alive = alive;
    if (alive) {
      setBackground(Color.RED);
    } else {
      setBackground(Color.GREEN);
    }
  }

  public boolean getAlive() {
    return _alive;
  }

  public void toggle() {
    setAlive(!_alive);
  }

  class CellListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      toggle();
    }
  }

}

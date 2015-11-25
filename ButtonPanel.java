import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel extends JPanel {

  private Conway _main;
  private RunButton _run;
  private StepButton _step;
  private PauseButton _pause;
  private ResetButton _reset;
  private RandomButton _random;

  public ButtonPanel(Conway main) {

    _main = main;

    _run = new RunButton(_main);
    _step = new StepButton(_main);
    _pause = new PauseButton(_main);
    _reset = new ResetButton(_main);
    _random = new RandomButton(_main);

    add(_run);
    add(_step);
    add(_pause);
    add(_reset);
    add(_random);

    setVisible(true);

  }

}

import java.util.*;

public class RunHandler implements Runnable {

  private Conway _main;

  public RunHandler(Conway main) {
    _main = main;
  }

  public void run() {
    try {
      while (true) {
        Thread.sleep(50);
        _main.step();
      }
    } catch (Exception e) {}
  }

}

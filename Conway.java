//Created by Colton Blake
//Modeled after Bill Laboon

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Conway extends JFrame {

  private int _size;
  private final String TITLE = "Conway's Game of Life: ";
  private CellPanel _cellContainer;
  private ButtonPanel _buttons;
  private RunHandler _runHandler;
  private Thread _runThread;

  public Conway() {
    System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");

    _size = inputSize();

    setTitle(TITLE + "Paused");
    setSize(550,550);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    _cellContainer = new CellPanel(this, _size);
    _buttons = new ButtonPanel(this);

    add(_cellContainer);
    add(_buttons, BorderLayout.SOUTH);

    setVisible(true);

    _runHandler = new RunHandler(this);
    _runThread = new Thread(_runHandler);
  }

  public static void main(String[] args) {
    new Conway();
  }

  private int inputSize() {
    while (true) {
      try {
        String input = JOptionPane.showInputDialog(this, "Please input a size for your game.");
        if (input == null) System.exit(0);
        int size = Integer.parseInt(input);
        return size;
      } catch (Exception e) {}
    }
  }

  public void run() {
    setTitle(TITLE + "Running");
    _runThread.interrupt();
    _runThread = new Thread(_runHandler);
    _runThread.start();
  }

  public void pause() {
    setTitle(TITLE + "Paused");
    _runThread.interrupt();
  }

  public void step() {
    _cellContainer.run();
  }

  public void reset() {
    _cellContainer.reset();
  }

  public void random() {
    _cellContainer.random();
  }

}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CellPanel extends JPanel {

  private Conway _main;
  private Cell[][] _cells;
  private int _size;

  public CellPanel(Conway main, int size) {
    _main = main;
    _size = size;

    setLayout(new GridLayout(_size,_size));

    _cells = new Cell[_size][_size];

    initializeCells(_cells);

    setVisible(true);
  }

  private void initializeCells(Cell[][] cellArray) {
    for (int y = 0; y < _size; y++) {
      for (int x = 0; x < _size; x++) {
        cellArray[x][y] = new Cell();
        add(cellArray[x][y]);
      }
    }
  }

  public void run() {
    boolean[][] queue = new boolean[_size][_size];

    for (int y = 0; y < _size; y++) {
      for (int x = 0; x < _size; x++) {
        int neighbors = getNeighbors(x, y);
        if ((neighbors == 3) || (neighbors == 2 && _cells[x][y].getAlive())) {
          queue[x][y] = true;
        } else {
          queue[x][y] = false;
        }
      }
    }

    for (int y = 0; y < _size; y++) {
      for (int x = 0; x < _size; x++) {
        if (_cells[x][y].getAlive() != queue[x][y]) {
          _cells[x][y].setAlive(queue[x][y]);
        }
      }
    }

  }

  public void reset() {
    for (int y = 0; y < _size; y++) {
      for (int x = 0; x < _size; x++) {
        _cells[x][y].setAlive(false);
        _cells[x][y].setBackground(Color.WHITE);
      }
    }
  }

  public void random() {
    for (int y = 0; y < _size; y++) {
      for (int x = 0; x < _size; x++) {
        if (new Random().nextInt(6) == 5) {
          _cells[x][y].setAlive(true);
        } else {
          _cells[x][y].setAlive(false);
          _cells[x][y].setBackground(Color.WHITE);
        }
      }
    }
  }

  public int getNeighbors(int x, int y) {

    int neighbors = 0;

    int leftX = (x - 1) % _size;
    int rightX = (x + 1) % _size;
    int upY = (y + 1) % _size;
    int downY = (y - 1) % _size;

    if (leftX == -1) leftX = _size - 1;
    if (rightX == -1) rightX = _size - 1;
    if (upY == -1) upY = _size - 1;
    if (downY == -1) downY = _size - 1;

    if (_cells[rightX][y].getAlive()) neighbors++;
    if (_cells[leftX][y].getAlive()) neighbors++;
    if (_cells[rightX][upY].getAlive()) neighbors++;
    if (_cells[rightX][downY].getAlive()) neighbors++;
    if (_cells[leftX][upY].getAlive()) neighbors++;
    if (_cells[leftX][downY].getAlive()) neighbors++;
    if (_cells[x][upY].getAlive()) neighbors++;
    if (_cells[x][downY].getAlive()) neighbors++;

    return neighbors;
  }

}

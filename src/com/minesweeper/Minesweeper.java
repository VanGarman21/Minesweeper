package com.minesweeper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import javax.swing.*;

public class Minesweeper extends JFrame {
  private JButton[][] buttons;
  private boolean[][] mines;
  private int[][] surroundingMines;
  private boolean[][] visited;
  private int uncoveredCells;

  public Minesweeper() {
    setTitle("Minesweeper");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new GridLayout(10, 10));

    buttons = new JButton[10][10];
    mines = new boolean[10][10];
    surroundingMines = new int[10][10];
    visited = new boolean[10][10];
    uncoveredCells = 0;

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        buttons[i][j] = new JButton();
        buttons[i][j].addActionListener(new CellClickListener(i, j));
        add(buttons[i][j]);
      }
    }

    placeMines();
    countSurroundingMines();

    pack();
    setVisible(true);
  }

  private void placeMines() {
    Random random = new Random();
    int placedMines = 0;
    while (placedMines < 10) {
      int i = random.nextInt(10);
      int j = random.nextInt(10);
      if (!mines[i][j]) {
        mines[i][j] = true;
        placedMines++;
      }
    }
  }

  private void countSurroundingMines() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (!mines[i][j]) {
          int count = 0;
          if (i > 0 && mines[i - 1][j]) count++;
          if (i < 9 && mines[i + 1][j]) count++;
          if (j > 0 && mines[i][j - 1]) count++;
          if (j < 9 && mines[i][j + 1]) count++;
          if (i > 0 && j > 0 && mines[i - 1][j - 1]) count++;
          if (i < 9 && j < 9 && mines[i + 1][j + 1]) count++;
          if (i > 0 && j < 9 && mines[i - 1][j + 1]) count++;
          if (i < 9 && j > 0 && mines[i + 1][j - 1]) count++;
          surroundingMines[i][j] = count;
        }
      }
    }
  }

  private void uncoverCell(int i, int j) {
    if (mines[i][j]) {
      loseGame();
    } else {
      buttons[i][j].setText(Integer.toString(surroundingMines[i][j]));
      buttons[i][j].setEnabled(false);
      uncoveredCells++;
      if (uncoveredCells == 90) {
        winGame();
      }
      if (surroundingMines[i][j] == 0) {
        uncoverSurroundingCellsDFS(i, j);
      }
    }
  }

  private void uncoverSurroundingCellsDFS(int i, int j) {
    Deque<Point> stack = new ArrayDeque<>();
    stack.push(new Point(i, j));
    visited[i][j] = true;

    while (!stack.isEmpty()) {
      Point point = stack.pop();
      int x = point.x;
      int y = point.y;

      if (surroundingMines[x][y] == 0) {
        if (x > 0 && !visited[x - 1][y]) {
          uncoverCell(x - 1, y);
          visited[x - 1][y] = true;
          if (surroundingMines[x - 1][y] == 0) {
            stack.push(new Point(x - 1, y));
          }
        }
        if (x < 9 && !visited[x + 1][y]) {
          uncoverCell(x + 1, y);
          visited[x + 1][y] = true;
          if (surroundingMines[x + 1][y] == 0) {
            stack.push(new Point(x + 1, y));
          }
        }
        if (y > 0 && !visited[x][y - 1]) {
          uncoverCell(x, y - 1);
          visited[x][y - 1] = true;
          if (surroundingMines[x][y - 1] == 0) {
            stack.push(new Point(x, y - 1));
          }
        }
        if (y < 9 && !visited[x][y + 1]) {
          uncoverCell(x, y + 1);
          visited[x][y + 1] = true;
          if (surroundingMines[x][y + 1] == 0) {
            stack.push(new Point(x, y + 1));
          }
        }
        if (x > 0 && y > 0 && !visited[x - 1][y - 1]) {
          uncoverCell(x - 1, y - 1);
          visited[x - 1][y - 1] = true;
          if (surroundingMines[x - 1][y - 1] == 0) {
            stack.push(new Point(x - 1, y - 1));
          }
        }
        if (x < 9 && y < 9 && !visited[x + 1][y + 1]) {
          uncoverCell(x + 1, y + 1);
          visited[x + 1][y + 1] = true;
          if (surroundingMines[x + 1][y + 1] == 0) {
            stack.push(new Point(x + 1, y + 1));
          }
        }
        if (x > 0 && y < 9 && !visited[x - 1][y + 1]) {
          uncoverCell(x - 1, y + 1);
          visited[x - 1][y + 1] = true;
          if (surroundingMines[x - 1][y + 1] == 0) {
            stack.push(new Point(x - 1, y + 1));
          }
        }
        if (x < 9 && y > 0 && !visited[x + 1][y - 1]) {
          uncoverCell(x + 1, y - 1);
          visited[x + 1][y - 1] = true;
          if (surroundingMines[x + 1][y - 1] == 0) {
            stack.push(new Point(x +  1, y - 1));
          }
        }
      }
    }
  }

 
    private void winGame() {
      JOptionPane.showMessageDialog(this, "You won!");
      System.exit(0);
    }

    private void loseGame() {
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          if (mines[i][j]) {
            buttons[i][j].setText("*");
          }
          buttons[i][j].setEnabled(false);
        }
      }
      JOptionPane.showMessageDialog(this, "You lost.");
      System.exit(0);
    }

    private class CellClickListener implements ActionListener {
      private int i;
      private int j;

      public CellClickListener(int i, int j) {
        this.i = i;
        this.j = j;
      }

      public void actionPerformed(ActionEvent e) {
        uncoverCell(i, j);
      }
    }

    public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
        new Minesweeper();
      });
    }
  }

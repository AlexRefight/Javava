package org.zeroes;

public class Coords {
  public final int row;
  public final int col;

  public Coords(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public boolean isValid() {
    return (row >= 0 && row <= 2)  && col >= 0 && col <= 2;
  }

  @Override
  public String toString() {
    char[] cols = {'A', 'B', 'C'};
    return cols[this.col] + "" + (this.row + 1);
  }
}

package org.zeroes;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.zeroes.Field.State.*;

public class Field {
    public enum State {
        EMPTY,
        CROSS,
        ZERO;
        public String toString() {
            switch (this) {
                case EMPTY:
                    return " ";
                case CROSS:
                    return "X";
                case ZERO:
                    return "O";
                default:
                    throw new IllegalStateException();
            }
        }
    }

    private State[][] data = {
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY}
    };

    public Field() {
    }

    private Cell cell(int row, int col) {
        return new Cell(new Coords(row, col), this.data[row][col]);
    }

    public Iterable<Triplet> getTriplets() {
        var triplets = new ArrayList<Triplet>();

        for (int row = 0; row < 3; row++) {
            triplets.add(new Triplet(cell(row,0), cell(row, 1), cell(row, 2)));
        }
        for (int col = 0; col < 3; col++) {
            triplets.add(new Triplet(cell(0, col), cell(1, col), cell(2, col)));
        }
        triplets.add(new Triplet(cell(0, 0), cell(1, 1), cell(2, 2)));
        triplets.add(new Triplet(cell(0, 2), cell(1, 1), cell(2, 0)));

        return triplets;
    }

    public void setCell(State state, Coords c) {
        /// TODO: ...
        if (this.data[c.row][c.col] != State.EMPTY) {
            throw new IllegalArgumentException("Cell is occupied with " + this.data[c.row][c.col]);
        }
        this.data[c.row][c.col] = state;
    }

    public boolean isEmpty(Coords c) {
        return data[c.row][c.col] == EMPTY;
    }


    public void print(PrintStream out) {
        out.println("  A B C");
        int rowNo = 1;
        for (State[] row : this.data) {
            out.print(rowNo + " ");
            rowNo++;
            for (State cell : row) {
                out.print(cell);
                out.print(" ");
            }
            out.print("\n");
        }
    }
}

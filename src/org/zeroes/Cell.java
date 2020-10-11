package org.zeroes;

public class Cell {
    public final Coords coords;
    public final Field.State state;

    public Cell(Coords c, Field.State s) {
        this.coords = c;
        this.state = s;
    }
}

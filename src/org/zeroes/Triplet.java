package org.zeroes;

import java.util.ArrayList;
import java.util.Collections;

import static org.zeroes.Field.State;

public class Triplet {
    public final Cell a;
    public final Cell b;
    public final Cell c;

    public Triplet(Cell a, Cell b, Cell c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Iterable<Cell> cells() {
        var l = new ArrayList<Cell>(3);
        l.add(a);
        l.add(b);
        l.add(c);
        return l;
    }
}
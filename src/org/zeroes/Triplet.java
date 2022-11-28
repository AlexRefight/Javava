package org.zeroes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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

    //return coords of triplet that already have one comp element
    public Coords hasOneZeroElement() {

        if(a.state == State.ZERO && b.state == State.EMPTY && c.state == State.EMPTY) {
            if(new Random().nextBoolean()) return b.coords;
            return c.coords;
        } else if(b.state == State.ZERO && a.state == State.EMPTY && c.state == State.EMPTY) {
            if(new Random().nextBoolean()) return a.coords;
            return c.coords;
        } else if(c.state == State.ZERO && a.state == State.EMPTY && b.state == State.EMPTY) {
            if(new Random().nextBoolean()) return a.coords;
            return b.coords;
        } else return null;
    }
}
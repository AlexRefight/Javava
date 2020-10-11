package org.zeroes;

import java.util.*;

/**
 * TODO:
    1. fix canContinue()
    2. rewrite makeTurn to play for win
    3. rewrite makeTurn to avoid loosing
    3a. fix input exceptions (try/catch)
    4. rewrite while() loop in a generic way
    5. create Android app with GUI
    learn how to work with IDE
 */
public class Game {
    private Scanner turn = new Scanner(System.in);
    private Field field = new Field();

    private Coords readTurn() {
        System.out.println("Your turn [ABC][123]: ");
        String userTurn = turn.nextLine();
        if (userTurn.length() != 2) {
            // TODO: ...
        }
        var col = userTurn.charAt(0) - 'A';
        var row = Integer.parseInt(userTurn.substring(1)) - 1;

        return new Coords(row, col);
    }

    private Coords makeTurn() {
        var emptyCells = new ArrayList<Cell>();
        for (Triplet t : this.field.getTriplets()) {
            for (Cell c : t.cells()) {
                if (c.state == Field.State.EMPTY) {
                    emptyCells.add(c);
                }
            }
        }
        Collections.shuffle(emptyCells);
        return emptyCells.get(0).coords;
    }

    private Field.State getWinner() {
        for (Triplet t : this.field.getTriplets()) {
            // if all three elements are the same and not empty -> return winner
            if (t.a.state == t.b.state && t.b.state == t.c.state) {
                return t.a.state;
            }
        }
        return Field.State.EMPTY;
    }

    private boolean canContinue() {
        // X
        // [X] [ ] [O]
        for (Triplet t : this.field.getTriplets()) {
            boolean samePlayer = true;
            var ref = Field.State.EMPTY;
            for (Cell c : t.cells()) {
                if (c.state != ref && c.state != Field.State.EMPTY) {
                    if (ref != Field.State.EMPTY) {
                        samePlayer = false;
                        break;
                    }
                    ref = c.state;
                }
            }
            if (samePlayer) {
                //System.out.println("Free triplet: " + t);
                return true;
            }
        }
        return false;
    }

    public void run() {
        while (getWinner() == Field.State.EMPTY && canContinue()) {
            field.print(System.out);
            var userTurn = readTurn();

            if (!userTurn.isValid()) {
                System.out.println("Invalid move, try again");
                continue;
            }

            if (!field.isEmpty(userTurn)) {
                System.out.println("This cell is occupied, try another one...");
                continue;
            }

            field.setCell(Field.State.CROSS, userTurn);

            if (getWinner() != Field.State.EMPTY || !canContinue()) {
                break;
            }

            var computerTurn = makeTurn();

            field.setCell(Field.State.ZERO, computerTurn);

            System.out.println("Enemy's turn: " + computerTurn);
        }
        field.print(System.out);

        var winner = getWinner();
        if (winner != Field.State.EMPTY) {
            if (winner == Field.State.CROSS) {
                System.out.println("You WON!");
            } else {
                System.out.println("You are looooser!");
            }
        } else {
            System.out.println("'Druzhba' saw won!");
        }
    }
}






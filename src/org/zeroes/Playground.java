package org.zeroes;

public class Playground {
    public static void main(String[] args) {
        var field = new Field();

//        field.setCell(org.zeroes.Field.State.CROSS, 0, 1);
//        field.setCell(org.zeroes.Field.State.ZERO, 1, 1);
//        field.setCell(org.zeroes.Field.State.CROSS, 2, 2);

//        if (!field.isEmpty(0, 1)) {
//            System.out.println("This cell is occupied, try another one...");
//        }

        field.print(System.out);
    }
}

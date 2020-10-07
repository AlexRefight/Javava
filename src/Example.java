import java.util.Scanner;
public class Example {
    public static void main(String[] args) {
        int[][] Field = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        /*int [] line0 = {Field[0][0], Field[0][1], Field[0][2]};
        int [] line1 = {Field[1][0], Field[1][1], Field[1][2]};
        int [] line2 = {Field[2][0], Field[2][1], Field[2][2]};
        int [] line3 = {Field[0][0], Field[1][0], Field[2][0]};
        int [] line4 = {Field[0][1], Field[1][1], Field[2][1]};
        int [] line5 = {Field[0][2], Field[1][2], Field[2][2]};
        int [] line6 = {Field[0][0], Field[1][1], Field[2][2]};
        int [] line7 = {Field[0][2], Field[1][1], Field[2][0]};*/
        /*for (int i=0;i<8;i++){
                String current = ("line"+i);*/
        boolean win = false;
        Scanner turn = new Scanner(System.in);
        while (win == false) {
            System.out.println("Your turn: ");
            String yourTurn = turn.nextLine();
            if (yourTurn.equals("A1"))
                Field[0][0] = 1;
            else if (yourTurn.equals("B1"))
                Field[0][1] = 1;
            else if (yourTurn.equals("C1"))
                Field[0][2] = 1;
            else if (yourTurn.equals("A2"))
                Field[1][0] = 1;
            else if (yourTurn.equals("B2"))
                Field[1][1] = 1;
            else if (yourTurn.equals("C2"))
                Field[1][2] = 1;
            else if (yourTurn.equals("A3"))
                Field[2][0] = 1;
            else if (yourTurn.equals("B3"))
                Field[2][1] = 1;
            else if (yourTurn.equals("C3"))
                Field[2][2] = 1;

            for (int h = 0; h < Field.length; h++) {
                for (int u = 0; u < Field.length; u++) {
                    System.out.print(Field[h][u] + " ");
                }
                System.out.println();
                }
            if (Field[0][0]>0&&Field[0][0]==Field[0][1]&&Field[0][0]==Field[0][2])
                win=true;
            else if(Field[1][0]>0&&Field[1][0]==Field[1][1]&&Field[1][0]==Field[1][2])
                win=true;
            else if(Field[2][0]>0&&Field[2][0]==Field[2][1]&&Field[2][0]==Field[2][2])
                win=true;
            else if(Field[0][0]>0&&Field[0][0]==Field[1][0]&&Field[0][0]==Field[2][0])
                win=true;
            else if(Field[0][1]>0&&Field[0][1]==Field[1][1]&&Field[0][1]==Field[2][1])
                win=true;
            else if(Field[0][2]>0&&Field[0][2]==Field[1][2]&&Field[0][2]==Field[2][2])
                win=true;
            else if(Field[0][0]>0&&Field[0][0]==Field[1][1]&&Field[0][0]==Field[2][2])
                win=true;
            else if(Field[0][2]>0&&Field[0][2]==Field[1][1]&&Field[0][2]==Field[2][0])
                win=true;

            System.out.println("Enemy's turn:");





        }

    }
}






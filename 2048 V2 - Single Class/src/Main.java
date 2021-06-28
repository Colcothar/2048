import java.util.Scanner;

public class Main {
    public Game game;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Game game = new Game();

        game.initBoard();
        game.add();

        game.printM();


        do {
            String s = in.nextLine();


            switch (s) {
                case "w":
                    game.moveUp();
                    break;

                case "a":
                    game.moveLeft();
                    break;

                case "s":
                    game.moveDown();
                    game.add();
                    break;

                case "d":
                    game.moveRight();
                    game.add();
                    break;
            }


            game.printM();
            System.out.println(game.getState());



        }while(game.getState().equals("Lost") == false);

        if(game.getState().equals("Game over")){
            System.out.println("You won!");
        }
        else if(game.getState().equals("Lost")){
            System.out.println("You lost");
        }

    }
}
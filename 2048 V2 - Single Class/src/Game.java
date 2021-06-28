import java.lang.Math;

public class Game {
    int[][] board = new int[4][4];
    int score=0;

    //constructor
    public Game(){
        System.out.println("Made");

    }

    //run once make random
    public void initBoard(){
        for(int y =0; y<4; y++){
            for(int x=0; x<4; x++){
                board[y][x]=0;
            }
        }
    }

    public void printM(){
        for(int y =0; y<4; y++){
            StringBuilder line = new StringBuilder();
            for(int x =0; x<4; x++){
                line.append(" ").append(board[y][x]);
            }
            System.out.println(line);
        }
        System.out.println("");

    }

    public void add(){
        int count =0;
        int x = (int)(Math.random()*(4));
        int y = (int)(Math.random()*(4));


        while( board[y][x]!=0){
            x = (int)(Math.random()*(4));
            y = (int) (Math.random() * (4));
            if(count==16){
                return;
            }
        }
        board[y][x]=2;
    }

    public String getState(){

        for(int y =0; y<4; y++){
            for(int x=0; x<4; x++){
                if(board[y][x]==2048){
                    return "Game over";
                }
            }
        }

        for(int y =0; y<4; y++){
            for(int x=0; x<4; x++){
                if(board[y][x]==0){
                    return "Game not over";
                }
            }
        }

        for(int y =0; y<4; y++){
            for(int x=0; x<4; x++){
                if( (board[y][x] == board[y+1][x]) || (board[y][x] == board[y][x+1]) ){
                    return "Game not over";
                }
            }
        }

        for(int x =0; x<3; x++) {
            if(board[3][x]==board[3][x+1]){
                return "Game not over";
            }
        }

        for (int y = 0; y < 3; y++) {
            if (board[y][3] == board[y + 1][3]) {
                return "Game not over";
            }
        }

        return "Lost";
    }

    public void setBoard(int[][] givenBoard){ //DEBUG ONLY
        board = givenBoard;

    }



    public void moveLeft(){
        board = compress(board);
        board = merge(board);

        board = compress(board);

    }

    public void moveRight(){
        board = reverse(board);
        moveLeft();

        board = reverse(board);
    }

    public void moveUp(){
        board = transpose(board);
        moveLeft();

        board = transpose(board);
    }

    public void moveDown(){
        board = transpose(board);
        moveRight();

        board = transpose(board);
    }

    public int[][] reverse(int[][]givenBoard){
        int[][] newBoard = new int[4][4];
        for(int y =0; y<4; y++) {
            for (int x = 0; x < 4; x++) {
                newBoard[y][x] = givenBoard[y][3-x];
            }
        }
        return newBoard;

    }

    public int[][] transpose(int[][] givenBoard){
        int[][] newBoard = new int[4][4];
        for(int y =0; y<4; y++) {
            for (int x = 0; x < 4; x++) {
                newBoard[y][x] = givenBoard[x][y];
            }
        }
        return newBoard;
    }


    public int[][] compress( int[][]givenBoard ){
        int[][] newBoard = new int[4][4];

        for(int y =0; y<4; y++) {
            int pos =0;

            for (int x = 0; x < 4; x++) {

                if(givenBoard[y][x] != 0){
                    newBoard[y][pos] = givenBoard[y][x];

                    pos++;
                }
            }
        }

        return newBoard;
    }


    public int[][] merge(int[][]givenBoard){

        for(int y =0; y<4; y++) {
            for (int x= 0; x < 3; x++) {

                if ((givenBoard[y][x] == givenBoard[y][x + 1]) && (givenBoard[y][x] != 0)) {
                    givenBoard[y][x] = (givenBoard[y][x]) * 2;
                    score = score + (givenBoard[y][x]);
                    givenBoard[y][x + 1] = 0;

                }
            }
        }

        return givenBoard;

    }

    public int getValue(int y, int x){
        return board[y][x];
    }

    public int getScore(){
        return score;
    }


}


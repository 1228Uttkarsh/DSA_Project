package com.company;





public class Main {
static int N = 9;

    public static boolean isSafe(char[][]board,int row, int col,int number){
        //row and col
        for(int i =0; i< board.length; i++) {
            if (board[i][col] == (char) (number + '0')) {
                return false;
            }
            if (board[row][i] == (char) (number + '0')) {
                return false;
            }
        }

        //grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i =sr;i<sr+3;i++){
            for(int j =sc; j<sc+3; j++){
                if(board[i][j] == (char) (number+'0')){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean helper(char board[][], int row, int col){//This is recursive function.

        if(row==board.length){
            return true;
        }
///we are using recursion using row and column
        int nrow = 0;
        int ncol = 0;
        if(col!= board.length-1){
            nrow = row;
            ncol = col+1;
            /*
            In this if statement we are checking that when we are in anywhere in a row then is that is
            last col or not, if not then we move ahead in column and row will be same.
             */
        } else{
            /*
            in this statement it is the last column then we move to next row and col will start from zero
             */
            nrow = row+1;
            ncol = 0  ;
        }
        //Now we check is there any number is  present in that row then we move next or we choose number from 1-9
        if(board[row][col]!='.'){
            if(helper(board,nrow,ncol)){//if the helper willreturn true value then we also return true
                return true;
            }
        }
        else {
            for(int i=1; i<=9;i++){
                if(isSafe(board,row,col,i)){
                    board[row][col] = (char)(i+'0');
                    if(helper(board,nrow,ncol)) {
                        return true;
                    }

                    else {
                        board[row][col] = '.';
                    }


                }
            }
        }
        return false;

    }

    public static boolean solveSudoku(char [][]board,int N){
       // int N = board.length;

        return helper(board,0, 0);


    }
    static void print(char[][] board)
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                System.out.print(board[i][j] + " ");}
            System.out.println();
        }
    }


    public static void main(String[] args) {

/*
        char board[][] = {{'3', '.', '6', '5', '.', '8', '4', '.', '.'},
                          {'5', '2', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '8', '7', '.', '.', '.', '.', '3', '1'},
                          {'.', '.', '3', '.', '1', '.', '.', '8', '.'},
                          {'9', '.', '.', '8', '6', '3', '.', '.', '5'},
                          {'.', '5', '.', '.', '9', '.', '6', '.', '.'},
                          {'1', '3', '.', '.', '.', '.', '2', '5', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '7', '4'},
                          {'.', '.', '5', '2', '.', '6', '3', '.', '.'}};

 */
        char board[][] ={{'5','3','.','.','7','.','.','.','.'},
                         {'.','.','.','1','9','5','.','.','.',},
                         {'.','9','8','.','.','.','.','6','.',},
                         {'8','.','.','.','6','.','.','.','3',},
                         {'4','.','.','8','.','3','.','.','1',},
                         {'7','.','.','.','2','.','.','.','6',},
                         {'.','6','.','.','.','.','2','8','.',},
                         {'.','.','.','4','1','9','.','.','5',},
                         {'.','.','.','.','8','.','.','7','9',},};

        int N = board.length;

        if (solveSudoku(board,9))
            print(board);
        else
            System.out.println("No Solution exists");



    }
}
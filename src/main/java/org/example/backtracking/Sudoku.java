package org.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku {

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {

        helper(a, 0, 0);

    }

    public boolean helper(ArrayList<ArrayList<Character>> a, int row, int col){

        if(row == 9)
            return true;

        int nrow = 0;
        int ncol = 0;

        if(col != 8){
            nrow = row;
            ncol = col + 1;
        }else{
            nrow = row + 1;
            ncol = 0;
        }

        if(a.get(row).get(col) != '.'){
            if(helper(a, nrow, ncol))
                return true;
        }else{
            for(int i = 1; i <= 9; i++){
                if(isSafe(a, row, col, i)){
                    a.get(row).set(col, (char) (i + '0'));
                    if (helper(a, nrow, ncol))
                        return true;
                    else
                        a.get(row).set(col, '.');
                }
            }
        }
        return false;
    }

    public boolean isSafe(ArrayList<ArrayList<Character>> a, int row, int col, int number){
        for(int i = 0; i < 9; i++){
            if(a.get(i).get(col) == (char)number + '0')
                return false;
            if(a.get(row).get(i) == (char)number + '0')
                return false;
        }

        int sr = (row/3) * 3;
        int sc = (col/3) * 3;

        for(int i = sr; i < sr + 3; i++){
            for(int j = sc; j < sc + 3; j++){
                if(a.get(i).get(j) == (char)number + '0')
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        /*
        A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
         */
        ArrayList<ArrayList<Character>>  list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList('5', '3', '.', '.', '7', '.', '.', '.', '.')));
        list.add(new ArrayList<>(Arrays.asList('6', '.', '.', '1', '9', '5', '.', '.', '.')));
        list.add(new ArrayList<>(Arrays.asList('.', '9', '8', '.', '.', '.', '.', '6', '.')));
        list.add(new ArrayList<>(Arrays.asList('8', '.', '.', '.', '6', '.', '.', '.', '3')));
        list.add(new ArrayList<>(Arrays.asList('4', '.', '.', '8', '.', '3', '.', '.', '1')));
        list.add(new ArrayList<>(Arrays.asList('7', '.', '.', '.', '2', '.', '.', '.', '6')));
        list.add(new ArrayList<>(Arrays.asList('.', '6', '.', '.', '.', '.', '2', '8', '.')));
        list.add(new ArrayList<>(Arrays.asList('.', '.', '.', '4', '1', '9', '.', '.', '5')));
        list.add(new ArrayList<>(Arrays.asList('.', '.', '.', '.', '8', '.', '.', '7', '9')));

        new Sudoku().solveSudoku(list);
        System.out.println(list);
    }
}

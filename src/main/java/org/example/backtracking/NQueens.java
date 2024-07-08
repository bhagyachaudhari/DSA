package org.example.backtracking;

import java.util.ArrayList;

public class NQueens {

    ArrayList<ArrayList<String>> ans = new ArrayList<>();
    boolean[] isSafeDiagonal;
    boolean[] isSafeAntiDiagonal;
    boolean[] isSafeCol;

    public ArrayList<ArrayList<String>> solveNQueens(int A) {

        ArrayList<String> list = new ArrayList<>();

        if(A == 1){
            list.add("Q");
            ans.add(list);
            return ans;
        }


        isSafeCol = new boolean[A];
        for(int i = 0; i < A; i++){
            isSafeCol[i] = true;
        }

        isSafeDiagonal = new boolean[2*A-1];
        isSafeAntiDiagonal = new boolean[2*A-1];
        for(int i = 0; i < 2*A-1; i++){
            isSafeDiagonal[i] = true;
            isSafeAntiDiagonal[i] = true;
        }

        String str = "";
        for(int i = 0; i < A; i++){
            str = str + ".";
        }

        for(int i = 0; i < A; i++){
            list.add(str);
        }

        nQueens(0, list, A);

        return ans;
    }

    public void nQueens(int row, ArrayList<String> list, int A){

        if(row == A){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int col = 0; col < A; col++){
            if(isSafeCol[col] && isSafeAntiDiagonal[row+col] && isSafeDiagonal[A-1+row-col]){

                StringBuilder str = new StringBuilder(list.get(row));
                str.setCharAt(col, 'Q');
                list.set(row, str.toString());

                isSafeCol[col] = false;
                isSafeAntiDiagonal[row+col] = false;
                isSafeDiagonal[A-1+row-col] = false;

                nQueens(row+1, list, A);

                str = new StringBuilder(list.get(row));
                str.setCharAt(col, '.');
                list.set(row, str.toString());

                isSafeCol[col] = true;
                isSafeAntiDiagonal[row+col] = true;
                isSafeDiagonal[A-1+row-col] = true;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }
}

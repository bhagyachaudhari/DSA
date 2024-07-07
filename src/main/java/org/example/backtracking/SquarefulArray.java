package org.example.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SquarefulArray {

    int count = 0;
    Set<String> set = new HashSet<>();
    public int solve(int[] A) {
        if(A.length==1) return isSquare(A[0]) ? 1 : 0;
        countAllWays(0,A);
        return count;
    }

    private void countAllWays(int i, int[] A) {
        if(i==A.length) {
            if(set.add(Arrays.toString(A))) count++;
            return;
        }
        for(int j=i; j<A.length; j++) {
            swap(A,i,j);
            if(i==0 || isSquare(A[i-1]+A[i])) countAllWays(i+1,A);
            swap(A,i,j);
        }
    }
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    private boolean isSquare(int n) {
        int sqrt = (int)Math.sqrt(n);
        return (sqrt*sqrt)==n;
    }

    public static void main(String[] args) {
        System.out.println(new SquarefulArray().solve(new int[]{6, 8, 9}));
    }
}

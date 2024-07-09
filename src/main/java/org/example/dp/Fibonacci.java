package org.example.dp;

import java.util.Scanner;

public class Fibonacci {

    private static int[] dp;
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        dp = new int[A+1];
        for(int i = 0; i < A+1; i++){
            dp[i] = -1;
        }

        System.out.println(fib(A));
    }

    private static int fib(int N){

        if(N == 0)
            return 0;
        else if(N == 1)
            return 1;

        if(dp[N] != -1)
            return dp[N];

        dp[N] = fib(N-1) + fib(N-2);

        return dp[N];
    }
}

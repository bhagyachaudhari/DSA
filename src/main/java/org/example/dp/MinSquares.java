package org.example.dp;

public class MinSquares {

    int dp[];
    public int countMinSquares(int A) {

        dp = new int[A+1];
        for(int i = 0; i <= A; i++){
            dp[i] = -1;
        }
        return psquares(A);
    }

    public int psquares(int N){
        if(N == 0)
            return 0;
        if(N == 1)
            return 1;

        int ans = Integer.MAX_VALUE;
        if(dp[N] != -1)
            return dp[N];

        for(int x = 1; x*x <= N; x++){
            ans = min(ans, psquares(N-(x*x)));
        }

        dp[N] = ans + 1;

        return dp[N];
    }

    public int min(int n1, int n2){
        return n1 < n2 ? n1 : n2;
    }

    public static void main(String[] args) {
        System.out.println(new MinSquares().countMinSquares(6));
    }
}

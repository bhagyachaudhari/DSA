package org.example.dp;

public class Stairs {

    public int climbStairs(int A) {

        return ways(A);
    }

    public int ways(int N){
        int mod = 1000000007;
        if(N == 1)
            return 1;
        else if(N == 2)
            return 2;

        long[] dp = new long[N+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= N; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }
        return (int)dp[N];
    }

    public static void main(String[] args) {
        System.out.println(new Stairs().climbStairs(4));
    }
}

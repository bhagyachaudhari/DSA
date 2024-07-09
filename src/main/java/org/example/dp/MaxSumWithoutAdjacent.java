package org.example.dp;

public class MaxSumWithoutAdjacent {

    public int adjacent(int[][] A) {

        int N = A.length;
        int M = A[0].length;
        int[] arr = new int[M];

        for(int j = 0; j < M; j++){
            arr[j] = Math.max(A[0][j], A[1][j]);
        }

        return maxSum(arr, M);
    }

    public int maxSum(int[] A, int N){
        if(N == 1)
            return A[0];

        int[] dp = new int[N+1];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);

        for(int i = 2; i < N; i++){
            dp[i] = Math.max(A[i] + dp[i-2], dp[i-1]);
        }
        return dp[N-1];
    }

    public static void main(String[] args) {
        System.out.println(new MaxSumWithoutAdjacent().adjacent(new int[][]{{4,7,9}, {3,5,2}}));
    }
}

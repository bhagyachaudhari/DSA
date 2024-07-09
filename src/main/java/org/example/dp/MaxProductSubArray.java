package org.example.dp;

public class MaxProductSubArray {

    public int maxProduct(final int[] A) {

        int N = A.length;
        if(N == 1)
            return A[0];

        int[] dpMax = new int[N];
        int[] dpMin = new int[N];

        dpMax[0] = A[0];
        dpMin[0] = A[0];

        for(int i = 1; i < N; i++){
            dpMax[i] = max(A[i], max(A[i]*dpMax[i-1], A[i]*dpMin[i-1]));
            dpMin[i] = min(A[i], min(A[i]*dpMin[i-1], A[i]*dpMax[i-1]));
        }

        return max(dpMax);
    }

    private int min(int a, int b){
        if(a < b)
            return a;
        else
            return b;
    }

    private int max(int a, int b){
        if(a > b)
            return a;
        else
            return b;
    }

    private int max(int[] dp){
        int max = dp[0];
        for(int i = 1; i < dp.length; i++){
            if(dp[i] > max)
                max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProductSubArray().maxProduct(new int[]{5, 8, 4}));
    }
}

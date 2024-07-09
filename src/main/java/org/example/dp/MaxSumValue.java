package org.example.dp;

public class MaxSumValue {

    public int solve(int[] A, int B, int C, int D) {

        int N = A.length;
        int[] preMax_1 = new int[N];
        int[] preMax_2 = new int[N];
        int[] preMax_3 = new int[N];

        preMax_1[0] = B * A[0];
        for(int i = 1; i < N; i++){
            preMax_1[i] = Math.max(preMax_1[i - 1], A[i] * B);
        }

        preMax_2[0] = preMax_1[0] + C * A[0];
        for(int j = 1; j < N; j++){
            preMax_2[j] = Math.max(preMax_2[j - 1], preMax_1[j] + C * A[j]);
        }

        preMax_3[0] = preMax_2[0] + D * A[0];
        for(int k = 1; k < N; k++){
            preMax_3[k] = Math.max(preMax_3[k - 1], preMax_2[k] + D * A[k]);
        }

        int ans = preMax_3[0];
        for(int i = 1; i < N; i++){
            ans = Math.max(ans, preMax_3[i]);
        }

        return ans;

    }

    public static void main(String[] args) {
        new MaxSumValue().solve(new int[]{6, 8, 9}, 6, 9, 5);
    }
}

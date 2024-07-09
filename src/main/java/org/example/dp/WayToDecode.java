package org.example.dp;

public class WayToDecode {

    public int numDecodings(String A) {
        int mod = 1000000007;
        int N = A.length();
        char[] arr = A.toCharArray();
        if(N == 0)
            return 0;
        if(arr[0] == '0')
            return 0;

        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            if(arr[i-1] >= '1' && arr[i-1] <= '9')
                dp[i] = dp[i-1];

            if(arr[i-2] == '1')
                dp[i] = (dp[i] + dp[i-2]) % mod;
            else if(arr[i-2] == '2' && arr[i-1] >= '0' && arr[i-1] <= '6')
                dp[i] = (dp[i] + dp[i-2]) % mod;
        }
        return dp[N] % mod;
    }

    public static void main(String[] args) {
        System.out.println(new WayToDecode().numDecodings("12"));
    }
}

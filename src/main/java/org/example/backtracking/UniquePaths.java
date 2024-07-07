package org.example.backtracking;

public class UniquePaths {

    public int solve(int[][] A) {

        int N = A.length;
        int M = A[0].length;
        int si = 0;
        int sj = 0;
        int zeroCnt = 0;
        // to find starting square
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(A[i][j] == 1){
                    si = i;
                    sj = j;
                }else if(A[i][j] == 0){
                    zeroCnt++;
                }
            }
        }

        return findPath(A, si, sj, zeroCnt);
    }

    public int findPath(int[][] A, int x, int y, int zeroCnt){

        if(x < 0 || y < 0 || x >= A.length || y>= A[0].length || A[x][y] == -1)
            return 0;
        if(A[x][y] == 2)
            return zeroCnt == -1 ? 1 : 0;
        A[x][y] = -1;
        zeroCnt--;

        int totalPath = findPath(A,x+1,y,zeroCnt) + findPath(A,x,y+1,zeroCnt) +
                findPath(A,x-1,y,zeroCnt) + findPath(A,x,y-1,zeroCnt) ;
        zeroCnt++;
        A[x][y] = 0;
        return totalPath;
    }

    public static void main(String[] args) {
        int[][] arr = {   {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}   };

        System.out.println(new UniquePaths().solve(arr));
    }
}

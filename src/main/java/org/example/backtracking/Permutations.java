package org.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new ArrayList<>(Arrays.asList(5, 8, 3))));
    }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        int N = A.size();
        boolean[] used = new boolean[N];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        permutations(ans, list, used, 0, A);

        return ans;

    }

    public void permutations(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list, boolean[] used, int idx, ArrayList<Integer> A){
        int N = A.size();
        if(idx == N){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < N; i++){
            if(!used[i]){
                used[i] = true;
                list.add(A.get(i));
                permutations(ans, list, used, idx + 1, A);
                list.remove(idx);
                used[i] = false;
            }
        }
    }
}

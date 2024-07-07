package org.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePermutations {

    int max = Integer.MIN_VALUE;
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        int N = A.size();

        for(int i = 0; i < N; i++){
            if(A.get(i) > max)
                max = A.get(i);
        }

        int[] freq = new int[max+1];
        for(int i = 0; i < N; i++){
            freq[A.get(i)]++;
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        generate(ans, list, 0, freq, A);

        return ans;
    }

    public void generate(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list, int idx, int[] freq, ArrayList<Integer> A){
        int N = A.size();
        if(idx == N){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i <= max; i++){
            if(freq[i] > 0){
                freq[i]--;
                list.add(i);
                generate(ans, list, idx+1, freq, A);
                freq[i]++;
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new UniquePermutations().permute(new ArrayList<>(Arrays.asList(5, 9, 8, 5))));
    }
}

package org.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum {

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {

        ArrayList<Integer> temp = new ArrayList<>();
        Collections.sort(A);
        findCombinations(A , B , 0 , temp);
        return ans;
    }

    public void findCombinations(ArrayList<Integer> A , int sum , int index , ArrayList<Integer> temp) {
        if(sum == 0){
            if(!ans.contains(temp)){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i = index ; i < A.size() ; i++){
            if(sum - A.get(i) >= 0){
                temp.add(A.get(i));
                findCombinations(A , sum-A.get(i) , i+1 , temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new ArrayList<>(Arrays.asList(10, 1, 2, 7, 6, 1, 5)), 8));
    }
}

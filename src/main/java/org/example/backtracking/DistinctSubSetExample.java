package org.example.backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class DistinctSubSetExample {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(2);
        arr.add(6);
        System.out.println(new DistinctSubSetExample().subsets(arr));
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(A);
        generateSubsets(A, 0, list, ans);
        return ans;
    }

    public void generateSubsets(ArrayList<Integer> A, int index, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){

        ans.add(new ArrayList(list));

        for(int i = index; i < A.size(); i++){
            int ele = A.get(i);
            list.add(ele);
            generateSubsets(A, i+1, list, ans);
            list.remove(list.size()-1);
        }
    }
}


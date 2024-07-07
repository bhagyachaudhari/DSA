package org.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DupSubsets {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A); // Sort the input list to ensure lexicographical order
        generate_Subsets(A , 0 , new ArrayList<>() , result );
        return result;
    }

    public void generate_Subsets(ArrayList<Integer> A, int index, List<Integer> subset, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<>(subset)); // Add the current subset to the result in each recursive call
        for (int i = index; i < A.size(); i++) {
            if (i > index && A.get(i).equals(A.get(i - 1))) {
                continue; // Skip duplicates to avoid generating duplicate subsets
            }
            subset.add(A.get(i)); // Add the current element in the subset
            generate_Subsets(A, i + 1, subset, result); // Recursively generate subsets starting from the next index
            subset.remove(subset.size() - 1); // Remove the last element to backtrack and explore other possibilities
        }
    }

    public static void main(String[] args) {
        System.out.println(new DupSubsets().subsetsWithDup(new ArrayList<>(Arrays.asList(7, 9, 4, 9))));
    }
}

package org.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LetterPhone {

    final String[] letters = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        generateAllCombs(0,A,temp,ans);
        return ans;
    }
    private void generateAllCombs(int i, String A, StringBuilder temp, ArrayList<String> ans) {
        if(i==A.length()) {
            ans.add(temp.toString());
            temp = new StringBuilder();
            return;
        }
        int num = (int)(A.charAt(i)-'0');
        for(int j=0; j<letters[num].length(); j++) {
            temp.append(letters[num].charAt(j));
            generateAllCombs(i+1,A,temp,ans);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(new LetterPhone().letterCombinations("23"));
    }
}

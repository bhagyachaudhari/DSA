package org.example.backtracking;

import java.util.ArrayList;

public class PalindromPartition {

    ArrayList <ArrayList<String>> answer;
    public ArrayList<ArrayList<String>> partition(String a) {
        answer = new ArrayList<>();
        partitioning(a, 0, new ArrayList < String > ());
        return answer;
    }


    private void partitioning(String a, int index, ArrayList < String > arrangement) {
        if (index == a.length()) {
            answer.add(new ArrayList < > (arrangement));
            return;
        }
        for (int i = index; i < a.length(); i++) {
            String sub = a.substring(index, i + 1);
            if (checkPalindrome(sub)) {
                arrangement.add(sub);
                partitioning(a, i + 1, arrangement);
                arrangement.remove(arrangement.size() - 1);
            }
        }
    }

    private boolean checkPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new PalindromPartition().partition("aab"));
    }
}

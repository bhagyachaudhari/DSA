package org.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak {

    public int wordBreak(String A, ArrayList<String> B) {

        return breakSentence(A, B) ? 1 : 0;
    }

    public boolean breakSentence(String A, ArrayList<String> B){

        if(A.length() == 0)
            return true;

        for(int i = 0 ; i < A.length(); i++){
            String substr = A.substring(0, i+1);

            if(substr.length() > 20)
                break;

            if(B.contains(substr)){
                if(breakSentence(A.substring(i+1), B))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("MyInterviewTrainer", new ArrayList<>(Arrays.asList("My", "Interview", "Trainer"))));
    }
}

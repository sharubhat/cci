package Evernote.problem2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private String[] words;


    public Solution(int size) {
        this.words = new String[size];
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int count = Integer.parseInt(line);
        Solution sol = new Solution(count);

        for (int i = 0; i < count; i++) {
            sol.store(br.readLine());
        }

        int top = Integer.parseInt(line);
        sol.print(top);
    }

    private void store(String s) {

    }

    private void print(int top) {
        for(int i = 0; i < top; i++) {
            System.out.println(words[i]);
        }
    }
}
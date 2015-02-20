package Evernote.problem1;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Solution {
    private String[] buff;
    private int first;
    private int next;
    private int maxSize;

    public Solution(int size) {
        this.maxSize = size;
        this.buff = new String[size];
        this.first = -1;     // where the entries start
        this.next = 0;      // where next entry can be placed
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        Solution sol = new Solution(N);
        boolean quit = false;
        while (!quit) {
            line = br.readLine();
            if (line.matches("[A](\\s)[0-9]+")) {
                String[] input = new String[Integer.parseInt(line.substring(2))];
                for (int i = 0; i < input.length; i++) {
                    sol.append(br.readLine());
                }
            } else if (line.matches("[R](\\s)[0-9]+")) {
                sol.remove(Integer.parseInt(line.substring(2)));
            } else if (line.equals("L")) {
                sol.list();
            } else if (line.equals("Q")) {
                System.exit(0);
            }
        }
    }

    private void list() {
        if(first == -1)
            return;
        int size = next - first;
        if (size <= 0)
            size = maxSize + size;
        for (int i = 0; i < size; i++) {
            System.out.println(buff[(first + i) % maxSize]);
        }
    }

    private void remove(int n) {
        if (first == -1)
            return;     // Nothing to remove
        // n is always <= num of entries
        // if n is <, then first should be < next after the remove
        // else first would be equal to next. Fix this by moving next
        first = (first + n) % maxSize;
        if (next == first) {         // if next is first, then first should be moved ahead
            first = -1;
            next = 0;
        }
    }

    private void append(String s) {
        if (next == first) {         // if next is first, then first should be moved ahead
            first = ++first % maxSize;
        }
        if (first == -1)
            first++;        // first entry
        buff[next] = s;     // next points to next open slot
        next = ++next % maxSize;    // open slot if filled, move next pointer
    }
}
package Evernote.p01;

import java.io.*;

public class Solution {
    static class Buffer{
        String[] cb;
        int si;
        int ei;
        Buffer(int N) {
            cb = new String[N];
            si = 0;
            ei = 0;
        }
    }
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        Buffer cb = new Buffer(N);
        boolean quit = false;
        while(!quit) {
            line = br.readLine();
            if(line.matches("[A](\\s)[0-9]+")) {
                String[] input = new String[Integer.parseInt(line.substring(2))];
                for(int i = 0; i < input.length; i++) {
                    input[i] = br.readLine();
                }
                append(cb, input, N);
            }
            else if(line.matches("[R](\\s)[0-9]+")) {
                remove(cb, Integer.parseInt(line.substring(2)));
            }
            else if(line.equals("L")) {
                list(cb, N);
            }
            else if(line.equals("Q")) {
                System.exit(0);
            }
        }
    }
    private static void append(Buffer cb, String[] in, int N) {
        int inLen = in.length;
        int i = 0;
        while(i < inLen) {
            // while buffer is not full
            while (cb.si <= cb.ei && cb.ei < N && i < inLen) {
                cb.cb[cb.ei++] = in[i++];
            }
            // while buffer gets full or is already rotated
            while (cb.ei == N || cb.ei < cb.si && cb.si < N && i < inLen) {
                cb.ei = cb.si++;
                cb.cb[cb.ei] = in[i++];
            }
            // when start index reaches end and needs a full rotation
            if (cb.si == N) {
                cb.si = 0;
                cb.ei++;
            }
        }
    }
    /*
    cases:
    1. si < ei && (si + n) < ei -> si = si + n
    2. si < ei && (si + n) > ei -> si = ei = 0
    3. si = ei -> return
    4. si > ei && (si + n) > N -> si = (si + n) - N
    5. si > ei && (si + n) < N -> si = si + n
     */
    private static void remove(Buffer cb, int n){
        if(cb.si < cb.ei) {
            if((cb.si + n) < cb.ei) {
                cb.si = cb.si + n;
            } else {
                cb.si = cb.ei = 0;
            }
        } else if(cb.si > cb.ei) {
            if((cb.si + n) <= cb.cb.length) {
                cb.si = cb.si + n;
            } else {
                cb.si = (cb.si + n) - cb.cb.length;
                if (cb.si >= cb.ei) {
                    cb.si = cb.ei = 0;
                }
            }
        } else {
            return;
        }
    }
    private static void list(Buffer cb, int N){
        if(cb.si < cb.ei) {
            for(int i = cb.si; i < cb.ei; i++) {
                System.out.println(cb.cb[i]);
            }
        } else {
            for (int i = cb.si; i < N; i++) {
                System.out.println(cb.cb[i]);
            }
            for (int i = 0; i <= cb.ei; i++) {
                System.out.println(cb.cb[i]);
            }
        }
    }
}
package hackerrank.list_stack_queues.epi;

import java.util.*;

/**
 * Created by sharath on 8/23/15.
 */
public class NormalizePathNames {
    public static String shortestEquivalentPath(String path) {
        Deque<String> pathNames = new LinkedList<>();
        if (path.startsWith("/")) {
            pathNames.add("/");
        }

        for (String token : path.split("/")) {
            if (token.equals("..")) {
                if (pathNames.isEmpty() || pathNames.peekFirst().equals("..")) {
                    pathNames.add(token);
                } else {
                    if (pathNames.peekFirst().equals("/")) {
                        throw new IllegalArgumentException("Path error, trying to go up the root");
                    }
                    pathNames.removeFirst();
                }
            } else if (!token.equals(".") && !token.isEmpty()) {
                pathNames.addFirst(token);
            }
        }

        StringBuilder result = new StringBuilder();
        if (!pathNames.isEmpty()) {
            Iterator<String> it = pathNames.descendingIterator();
            String prev = it.next();
            result.append(prev);
            while (it.hasNext()) {
                if (!prev.equals("/")) {
                    result.append("/");
                }
                prev = it.next();
                result.append(prev);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(shortestEquivalentPath("123/456").equals("123/456"));
        System.out.println(shortestEquivalentPath("/123/456").equals("/123/456"));
        System.out.println(shortestEquivalentPath("usr/lib/../bin/gcc").equals("usr/bin/gcc"));
        System.out.println(shortestEquivalentPath("./../").equals(".."));
        System.out.println(shortestEquivalentPath("../../local").equals("../../local"));
        System.out.println(shortestEquivalentPath("./.././../local").equals("../../local"));
        System.out.println(shortestEquivalentPath("/foo/../foo/./../").equals("/"));
        try {
            shortestEquivalentPath("/..");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            shortestEquivalentPath("/cpp_name/bin/");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(false);
        }
        System.out.println(shortestEquivalentPath("scripts//./../scripts/awkscripts/././")
                .equals("scripts/awkscripts"));
        if (args.length == 1) {
            System.out.println(shortestEquivalentPath(args[0]));
        }
    }
}

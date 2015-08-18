package topcoder_graph.dfs;

import java.util.StringTokenizer;

/**
 *
 * Problem Statement
 *
 * http://community.topcoder.com/tc?module=ProblemDetail&rd=4472&pm=1524
 *
 You work for a very large company that markets many different products.
 In some cases, one product you market competes with another.
 To help deal with this situation you have split the intended consumers into two groups, namely Adults and Teenagers.
 If your company markets 2 products that compete with each other,
 selling one to Adults and the other to Teenagers will help maximize profits.
 Given a list of the products that compete with each other,
 you are going to determine whether all can be marketed such that
 no pair of competing products are both sold to Teenagers or both sold to Adults.
 If such an arrangement is not feasible your method will return -1.
 Otherwise, it should return the number of possible ways of marketing all of the products.

 The products will be given in a String[] compete whose kth element describes product k.
 The kth element will be a single-space delimited list of integers.
 These integers will refer to the products that the kth product competes with.

 For example: compete = {"1 4", "2", "3", "0", ""}

 The example above shows
 product 0 competes with 1 and 4,
 product 1 competes with 2,
 product 2 competes with 3, and
 product 3 competes with 0.

 Note, competition is symmetric so product 1 competing with product 2 means product 2 competes with product 1 as well.

 Ways to market:

 1) 0 to Teenagers, 1 to Adults, 2 to Teenagers, 3 to Adults, and 4 to Adults

 2) 0 to Adults, 1 to Teenagers, 2 to Adults, 3 to Teenagers, and 4 to Teenagers

 Your method would return 2.

 Definition

 Class:	Marketing
 Method:	howMany
 Parameters:	String[]
 Returns:	long
 Method signature:	long howMany(String[] compete)
 (be sure your method is public)

 Constraints
 -	compete will contain between 1 and 30 elements, inclusive.
 -	Each element of compete will have between 0 and 50 characters, inclusive.
 -	Each element of compete will be a single space delimited sequence of integers such that:
 All of the integers are unique.
 Each integer contains no extra leading zeros.
 Each integer is between 0 and k-1 inclusive where k is the number of elements in compete.
 -	No element of compete contains leading or trailing whitespace.
 -	Element i of compete will not contain the value i.
 -	If i occurs in the jth element of compete, j will not occur in the ith element of compete.

 Examples
 0)

 {"1 4","2","3","0",""}
 Returns: 2
 The example from above.
 1)

 {"1","2","0"}
 Returns: -1
 Product 0 cannot be marketed with product 1 or 2. Product 1 cannot be marketed with product 2.
 There is no way to achieve a viable marketing scheme.
 2)

 {"1","2","3","0","0 5","1"}
 Returns: 2
 3)

 {"","","","","","","","","","",
 "","","","","","","","","","",
 "","","","","","","","","",""}
 Returns: 1073741824
 4)

 {"1","2","3","0","5","6","4"}
 Returns: -1
 This problem statement is the exclusive and proprietary property of TopCoder, Inc.
 Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc.
 is strictly prohibited. (c)2010, TopCoder, Inc. All rights reserved.


 * Created by sharath on 6/4/15.
 */
public class Marketing {

    public long howMany(String[] compete) {
        int len = compete.length;
        boolean[][] table = new boolean[len][len];
        int[] color = new int[len];
        boolean oddCycle = false;

        for(int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(compete[i], " ");
            while(st.hasMoreTokens()) {
                int j = Integer.parseInt(st.nextToken());
                table[i][j] = table[j][i] = true;
            }
        }

        int ncomp = 0;

        for(int i = 0; i < len; i++) {
            if(color[i] == 0) {
                ncomp++;
                dfs(table, color, oddCycle, i, 1);
            }
        }
        if(oddCycle)
            return -1;

        long res = 1;
        while(ncomp-- > 0){
            res *= 2;
        }
        return res;
    }

    private void dfs(boolean[][] table, int[] color, boolean oddCycle, int u, int c) {
        if(color[u] != 0) {
            if(color[u] != c)
                oddCycle = true;
            return;
        }
        color[u] = c;
        for(int i = 0; i < color.length; i++) {
            if(table[u][i])
                dfs(table, color, oddCycle, i, 3 - c);
        }
    }
    public static void main(String[] args) {
        Marketing m = new Marketing();
        System.out.println(m.howMany(new String[]{"1 4", "2", "3", "0", ""}));
    }
}

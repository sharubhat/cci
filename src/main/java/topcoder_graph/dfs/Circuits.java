package topcoder_graph.dfs;

/**
 *
 * http://community.topcoder.com/stat?c=problem_statement&pm=1593&rd=4494
 *
 *
 * Problem Statement
 An essential part of circuit design and general system optimization is critical path analysis. On a chip, the critical path represents the longest path any signal would have to travel during execution. In this problem we will be analyzing chip designs to determine their critical path length. The chips in this problem will not contain any cycles, i.e. there exists no path from one component of a chip back to itself.


 Given a String[] connects representing the wiring scheme, and a String[] costs representing the cost of each connection, your method will return the size of the most costly path between any 2 components on the chip. In other words, you are to find the longest path in a directed, acyclic graph. Element j of connects will list the components of the chip that can be reached directly from the jth component (0-based). Element j of costs will list the costs of each connection mentioned in the jth element of connects. As mentioned above, the chip will not contain any cyclic paths. For example:
 connects = {"1 2",
 "2",
 ""}
 costs    = {"5 3",
 "7",
 ""}
 In this example, component 0 connects to components 1 and 2 with costs 5 and 3 respectively. Component 1 connects to component 2 with a cost of 7. All connections mentioned are directed. This means a connection from component i to component j does not imply a connection from component j to component i. Since we are looking for the longest path between any 2 components, your method would return 12.

 Definition

 Class:	Circuits
 Method:	howLong
 Parameters:	String[], String[]
 Returns:	int
 Method signature:	int howLong(String[] connects, String[] costs)
 (be sure your method is public)


 Constraints
 -	connects must contain between 2 and 50 elements inclusive
 -	connects must contain the same number of elements as costs
 -	Each element of connects must contain between 0 and 50 characters inclusive
 -	Each element of costs must contain between 0 and 50 characters inclusive
 -	Element i of connects must contain the same number of integers as element i of costs
 -	Each integer in each element of connects must be between 0 and the size of connects-1 inclusive
 -	Each integer in each element of costs must be between 1 and 1000 inclusive
 -	Each element of connects may not contain repeated integers
 -	Each element of connects must be a single space delimited list of integers, each of which has no extra leading zeros. There will be no leading or trailing whitespace.
 -	Each element of costs must be a single space delimited list of integers, each of which has no extra leading zeros. There will be no leading or trailing whitespace.
 -	The circuit may not contain any cycles

 Examples
 0)

 {"1 2",
 "2",
 ""}
 {"5 3",
 "7",
 ""}
 Returns: 12
 From above
 1)

 {"1 2 3 4 5","2 3 4 5","3 4 5","4 5","5",""}
 {"2 2 2 2 2","2 2 2 2","2 2 2","2 2","2",""}
 Returns: 10
 The longest path goes from 0-1-2-3-4-5 for a cost of 10.
 2)

 {"1","2","3","","5","6","7",""}
 {"2","2","2","","3","3","3",""}
 Returns: 9
 The 0-1-2-3 path costs 6 whereas the 4-5-6-7 path costs 9
 3)

 {"","2 3 5","4 5","5 6","7","7 8","8 9","10",
 "10 11 12","11","12","12",""}
 {"","3 2 9","2 4","6 9","3","1 2","1 2","5",
 "5 6 9","2","5","3",""}
 Returns: 22
 4)

 {"","2 3","3 4 5","4 6","5 6","7","5 7",""}
 {"","30 50","19 6 40","12 10","35 23","8","11 20",""}
 Returns: 105
 This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2010, TopCoder, Inc. All rights reserved.


 * Created by sharath on 7/15/15.
 */
public class Circuits {
}

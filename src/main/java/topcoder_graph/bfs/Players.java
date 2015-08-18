package topcoder_graph.bfs;

/**
 * BFS problem in https://www.topcoder.com/community/data-science/data-science-tutorials/introduction-to-graphs-and-their-data-structures-section-2/

 A quick summary of the problem is that we want to exchange the positions of two players on a grid.
 There are impassable spaces represented by ‘X’ and spaces that we can walk in represented by ‘ ‘.
 Since we have two players our node structure becomes a bit more complicated,
 we have to represent the positions of person A and person B.
 Also, we won’t be able to simply use our array to represent visited positions any more,
 we will have an auxiliary data structure to do that. Also, we are allowed to make diagonal movements in this problem,
 so we now have 9 choices, we can move in one of 8 directions or simply stay in the same position.
 Another little trick that we have to watch for is that the players can not just swap positions in a single turn,
 so we have to do a little bit of validity checking on the resulting state.

 * Created by sharath on 7/15/15.
 */
public class Players {
    static class Node {
        int player1x, player1y, player2x, player2y;
        int steps;
    }

    boolean[][][][] visited = new boolean[20][20][20][20];

//    public int minturns(String[] board) {
//        int width = board[0].length();
//        int height = board.length;
//
//    }
}

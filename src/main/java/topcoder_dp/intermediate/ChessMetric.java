package topcoder_dp.intermediate;

/**
 * Created by sharath on 2/15/15.
 *
 * Problem Statement
 Suppose you had an n by n chess board and a super piece called a kingknight.
 Using only one move the kingknight denoted 'K' below can reach any of the spaces denoted 'X' or 'L' below:

 . . . . . . .
 . . L . L . .
 . L X X X L .
 . . X K X . .
 . L X X X L .
 . . L . L . .
 . . . . . . .

 In other words, the kingknight can move either one space in any direction (vertical, horizontal or diagonally)
 or can make an 'L' shaped move. An 'L' shaped move involves moving 2 spaces horizontally then 1 space vertically
 or 2 spaces vertically then 1 space horizontally.
 In the drawing above, the 'L' shaped moves are marked with 'L's whereas the one space moves are marked with 'X's.
 In addition, a kingknight may never jump off the board.


 Given the size of the board, the start position of the kingknight and the end position of the kingknight,
 your method will return how many possible ways there are of getting from start to end in exactly numMoves moves.
 start and finish are int[]s each containing 2 elements. The first element will be the (0-based) row position
 and the second will be the (0-based) column position. Rows and columns will increment down and to the right respectively.
 The board itself will have rows and columns ranging from 0 to size-1 inclusive.


 Note, two ways of getting from start to end are distinct if their respective move sequences differ in any way.
 In addition, you are allowed to use spaces on the board (including start and finish) repeatedly during a particular path
 from start to finish.
 We will ensure that the total number of paths is less than or equal to 2^63-1 (the upper bound for a long).

 Definition

 Class:	ChessMetric
 Method:	howMany
 Parameters:	int, int[], int[], int
 Returns:	long
 Method signature:	long howMany(int size, int[] start, int[] end, int numMoves)
 (be sure your method is public)


 Constraints
 -	size will be between 3 and 100 inclusive
 -	start will contain exactly 2 elements
 -	finish will contain exactly 2 elements
 -	Each element of start and finish will be between 1 and size-1 inclusive
 -	numMoves will be between 1 and 50 inclusive
 -	The total number of paths will be at most 2^63-1.

 Examples
 0)

 3
 {0,0}
 {1,0}
 1
 Returns: 1
 Only 1 way to get to an adjacent square in 1 move
 1)

 3
 {0,0}
 {1,2}
 1
 Returns: 1
 A single L-shaped move is the only way
 2)

 3
 {0,0}
 {2,2}
 1
 Returns: 0
 Too far for a single move
 3)

 3
 {0,0}
 {0,0}
 2
 Returns: 5
 Must count all the ways of leaving and then returning to the corner
 4)

 100
 {0,0}
 {0,99}
 50
 Returns: 243097320072600

 */
public class ChessMetric {
}

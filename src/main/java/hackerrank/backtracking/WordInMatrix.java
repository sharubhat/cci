package hackerrank.backtracking;

/**
 * Given a 2D matrix of characters. Check whether the given word exist in the matrix or not.
 * If it exists then print its path. All movements are allowed (right, left, up, down and diagonally).
 *
 * Approach :
 *
 * Create a solution matrix of the same structure as Matrix.
 * Try each cell a starting point.
 * Check current cell is not already used and character in it matches with the character in the word at index (starts with 0).
 * Check if index = length of the word, means we have found the word. return true and print the solution matrix.
 * If above criteria matches, mark that cell with a number Whenever any cell matches with the criteria, put a number corresponding to it in solution matrix. (start with 0 and keep incrementing it, it will show us the path for the word).
 * Now try to solve rest of the problem recursively by making index +1. Check all 8 directions ( up, down, left right, diagonally up-left, diagonally up-right, diagonally down-left, diagonally down-right). Check the boundary conditions as well
 * If none of the 8 recursive calls return true, BACKTRACK and undo the changes ( put 0 to corresponding cell in solution matrix) and return false.
 * Choose different starting point.
 * If all the starting points tried and solution not found, return false
 * See the code for better understanding.
 *
 * Created by sharath on 9/30/15.
 */
public class WordInMatrix {
}

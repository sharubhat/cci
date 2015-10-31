package hackerrank.graphs_and_other_ds.homework;

import java.util.*;

/**
 * Given a snake and ladder rectangle MxN board-game, find the min number of dice throws required to reach the final
 * cell from 1st cell.
 *
 * Rules are as usual: If after a dice-throw, the player reaches a cell where the ladder starts, the player has to climb
 * up that ladder and if the player reaches a cell that has the mouth of the snake, s/he has to go down to the tail of snake.
 *
 * Please hard code the input game boards as your test-cases. There are different ways of doing so. e.g. one simple way
 * is to represent it using a one-dimension array of length MxN, with each element representing a cell. Values in the array,
 * are the destination cell id for snakes(lower numbers) and ladders(higher numbers).
 *
 * Created by sharath on 10/12/15.
 */
public class SnakeNLadder {
    /**
     * Snakes and Ladders basically do the same thing. They move the player from one place to another if they move in
     * positive direction we call them ladders otherwise snakes.
     */
    public static class Movers {
        int start;
        int end;

        public Movers(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + " -> " + end;
        }
    }

    public static void minMovesRequired(List<Movers> snakesAndLadders) {
        int[] moveMap = new int[101];

        for(Movers m : snakesAndLadders) {
            moveMap[m.start] = m.end;
        }

        System.out.println(Arrays.toString(moveMap));

        int[] minMove = new int[101];
        int[] dice = new int[101];
        int[] fromCell = new int[101];

        LinkedList<Integer> q = new LinkedList<>();
        q.add(1);
        boolean finished = false;
        while(!q.isEmpty() && ! finished) {
            int cell = q.poll();
            for(int i = 1; i <= 6; i++) {
                int newCell = moveMap[cell + i] == 0? cell + i : moveMap[cell + i];
                if(minMove[newCell] == 0) {
                    minMove[newCell] = minMove[cell] + 1;
                    dice[newCell] = i;
                    fromCell[newCell] = cell;
                    q.add(newCell);
                }
                if(newCell==100)
                {
                    finished=true;
                    break;
                }
            }
        }
        int cell = 100;
        Stack<String> stack=new Stack<>();
        while(cell!=1)
        {
            stack.push("new cell "+cell);
            stack.push("dice throw "+dice[cell]);

            cell=fromCell[cell];
        }
        while(!stack.isEmpty())
            System.out.println(stack.pop());
    }

    public static void main(String[] args) {
        List<Movers> snakesAndLadders = new ArrayList<>();
        snakesAndLadders.add(new Movers(9, 31));
        snakesAndLadders.add(new Movers(17, 7));
        snakesAndLadders.add(new Movers(28, 84));
        snakesAndLadders.add(new Movers(85, 41));
        snakesAndLadders.add(new Movers(51, 67));
        snakesAndLadders.add(new Movers(54, 34));
        snakesAndLadders.add(new Movers(62, 19));
        snakesAndLadders.add(new Movers(64, 60));
        snakesAndLadders.add(new Movers(71, 91));
        snakesAndLadders.add(new Movers(80, 99));
        snakesAndLadders.add(new Movers(87, 24));
        snakesAndLadders.add(new Movers(93, 73));

        minMovesRequired(snakesAndLadders);

    }
}

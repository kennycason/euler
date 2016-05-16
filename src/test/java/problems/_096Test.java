package problems;
import org.junit.Test;
import working._096._096;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class _096Test {

    @Test
    public void test() {
        _096.State state = new _096.State();
        state.state = new int[][] {
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9},
            {1,2,3,4,5,6,7,8,9}
        };
        System.out.println(state);
        assertFalse(state.isSolved());
        assertTrue(state.isFull());

        state.state = new int[][] {
                {4,8,3,9,2,1,6,5,7},
                {9,6,7,3,4,5,8,2,1},
                {2,5,1,8,7,6,4,9,3},
                {5,4,8,1,3,2,9,7,6},
                {7,2,9,5,6,4,1,3,8},
                {1,3,6,7,9,8,2,4,5},
                {3,7,2,6,8,9,5,1,4},
                {8,1,4,2,5,3,7,6,9},
                {6,9,5,4,1,7,3,8,2}
        };
        System.out.println(state);
        assertTrue(state.isSolved());
        assertTrue(state.isFull());


    }

}

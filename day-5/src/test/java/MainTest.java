import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {


    @Test
    public void getRow() {
        assertEquals(44, Main.getRow("FBFBBFF"));
        assertEquals(70, Main.getRow("BFFFBBF"));
        assertEquals(14, Main.getRow("FFFBBBF"));
        assertEquals(102, Main.getRow("BBFFBBF"));
    }

    @Test
    public void getColumn() {
        assertEquals(7, Main.getColumn("RRR"));
        assertEquals(4, Main.getColumn("RLL"));
    }

    @Test
    public void getSeatID() {
        assertEquals(567, Main.getSeatID("BFFFBBFRRR"));
        assertEquals(119, Main.getSeatID("FFFBBBFRRR"));
        assertEquals(820, Main.getSeatID("BBFFBBFRLL"));
    }
}
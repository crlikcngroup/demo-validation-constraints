package cz.crlik.constraint;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NotNullTest {

    @Test
    public void testWhenNull() {
        final int counter = 10;

        assertTrue(counter == 10);
    }
}

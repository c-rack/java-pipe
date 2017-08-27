package co.nstant.in.pipe;

import static co.nstant.in.pipe.Pipe.apply;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PipeTest {

    @Test
    public void testPipe() {
        assertEquals("11", apply("ab")
                .pipe((a) -> a.toUpperCase())
                .pipe((a, b) -> a.replace('A', b), '1')
                .pipe((a, b, c) -> a.replace(b, c), 'B', '2')
                .pipe((a) -> Integer.valueOf(a))
                .pipe((a, b, c, d) -> a + b * c - d, 1, 2, 3)
                .pipe((a) -> a.toString())
                .result());
    }

}

package second.streams.operations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SkipLimitDemoTest {

    SkipLimitDemo skipLimitDemo;

    @BeforeEach
    void setUp() {
        skipLimitDemo = new SkipLimitDemo();
    }

    @Test
    void getArray() {
        Assertions.assertArrayEquals(new Object[]{3,4,5}, skipLimitDemo.getArray());
    }
}
package io.serialize.buffer;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BufferTest {

    Buffer buffer;

    @BeforeEach
    void init() {
        buffer = new Buffer();
    }

    @Test
    void regex() {
        Assert.assertEquals("package\\io\\first\\class",
                buffer.regex("\\.", "package.io.first.class", "\\\\"));
    }
}
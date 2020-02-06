package io.serialize.quize.player;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void split() {
        ClassLoader classLoader = Utils.class.getClassLoader();
        File file = new File(classLoader.getResource("answers.txt").getFile());
        Assert.assertEquals("Около", Utils.split(file, ",")[0]);
    }
}
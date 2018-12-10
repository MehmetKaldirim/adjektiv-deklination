package Adjektiv.Deklination;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Homeworktest {

    @Test
    public void testSplit() throws IOException {
        Homework hw = new Homework();
        String first = hw.splitLineOfAnswers("Aaa-Bbb", 1, "-");
        Assert.assertEquals("Bbb",first) ;

    }
}

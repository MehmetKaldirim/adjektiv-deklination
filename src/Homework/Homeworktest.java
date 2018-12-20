package Homework;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class Homeworktest {

    @Test
    public void testSplit() throws IOException {
        CheckAnswers ch = new CheckAnswers();
        String first = ch.splitLineOfAnswers("Aaa-Bbb", 1, "-");
        Assert.assertEquals("Bbb",first) ;

    }
}

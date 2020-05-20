 package com.salesforce.tests.fs;

import org.junit.Assert;

import java.io.IOException;
import java.util.Arrays;

/**
 * Base unit test runner
 */
class BaseTest {

    protected void runTest(String[] input, String[] expectedOutput, boolean showDiffs) throws IOException {
        Main main = new Main();
        String[] output = main.doIt(input);
        if (showDiffs) {
            Assert.assertEquals(expectedOutput.length, output.length);
            for (int i = 0; i < output.length; i++) {
                Assert.assertEquals(expectedOutput[i], output[i]);
            }
        } else {
            Assert.assertTrue(Arrays.toString(expectedOutput).equals(Arrays.toString(output)));
        }
        
    }
}

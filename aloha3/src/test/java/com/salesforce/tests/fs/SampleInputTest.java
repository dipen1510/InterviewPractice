package com.salesforce.tests.fs;

import org.junit.Test;

import java.io.IOException;

/**
 * Test for the sample input
 */
public class SampleInputTest extends BaseTest {

    @Test
    public void testSampleInput() throws IOException {
        String[] testInput = {
                "dir",
                "mkdir   sub6",
                "mkdir   sub3",
                "mkdir   sub4",
                "dir",
                "mkdir   sub4",
                "cd      sub3",
                "cd      sub3",
                "mkdir   sub3",
                "mkdir   sub6",
                "mkdir   sub4",
                "dir",
                "cd      sub6",
                "mkdir   sub666",
                "dir",
                "up",
                "up",
                "dir",
                "up"
        };

        String[] expectedOutput = {
                "Command: dir     \n",
                "Directory of root:\n",
                "No subdirectories\n",
                "Command: mkdir   sub6    \n",
                "Command: mkdir   sub3    \n",
                "Command: mkdir   sub4    \n",
                "Command: dir     \n",
                "Directory of root:\n",
                "sub3    sub4    sub6    \n",
                "Command: mkdir   sub4    \n",
                "Subdirectory already exists\n",
                "Command: cd      sub3    \n",
                "Command: cd      sub3    \n",
                "Subdirectory does not exist\n",
                "Command: mkdir   sub3    \n",
                "Command: mkdir   sub6    \n",
                "Command: mkdir   sub4    \n",
                "Command: dir     \n",
                "Directory of root\\sub3:\n",
                "sub3    sub4    sub6    \n",
                "Command: cd      sub6    \n",
                "Command: mkdir   sub666  \n",
                "Command: dir     \n",
                "Directory of root\\sub3\\sub6:\n",
                "sub666  \n",
                "Command: up      \n",
                "Command: up      \n",
                "Command: dir     \n",
                "Directory of root:\n",
                "sub3    sub4    sub6    \n",
                "Command: up      \n",
                "Cannot move up from root directory\n"
        };

        runTest(testInput, expectedOutput, true);
    }

}

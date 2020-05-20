package com.salesforce.tests.fs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * The entry point for the Test program
 */
public class Main {

    /**
     * do the work here
     *
     * @param input the input text
     * @return the result
     */
	
	static DoublyLinkedImpl fileSystem = new DoublyLinkedImpl();
	
    public String[] doIt(String[] input) throws IOException {

        //TODO: provide the real implementation here
    	
    	List<String> answer = new ArrayList<String>();
    	//String[] answer;
    	int commands = input.length, i=0;

        while(i<commands){
            String command = input[i];
            //System.out.println("Command: " + command + " ");
            answer.add("Command: " + command);

            if ( command.startsWith("dir") ){
                fileSystem.getDir(answer);
            }else if ( command.startsWith("mkdir") ){
                fileSystem.createDir(getParam(command),answer);
            }else if ( command.startsWith("cd") ){
                fileSystem.cd(getParam(command));
            }else if ( command.startsWith("up") ){
                fileSystem.goUp(answer);
            }
            i++;
        }
        //System.out.println(answer);
        return answer.toArray(new String[0]);
    }
    
    static String getParam(String str){
        StringTokenizer st = new StringTokenizer(str);
        st.nextToken();
        return st.nextToken();
    }

    //==================You don't need to change the following codes ==========================//
    public static void main(String[] args) throws IOException {
        Main theOne = new Main();

        FileReader reader = null;
        try {
            //read from the input file
            reader = new FileReader(args.length == 1 ? args[0] : "input.txt");

            //do the processing
            
            /* make changes */
            
            String[] output = theOne.doIt(readFromFile(reader));
            for(String s: output) {
            	System.out.println(s);
            }
            
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    /**
     * Read input from the file and convert into a String
     *
     * @param reader Input file
     * @return Input in a String
     * @throws IOException
     */
    private static String[] readFromFile(FileReader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        List<String> words = new ArrayList<String>();
        while (((line = bufferedReader.readLine()) != null) && line.trim().length() > 0) {
            words.add(line);
        }
        return words.toArray(new String[words.size()]);
    }
}

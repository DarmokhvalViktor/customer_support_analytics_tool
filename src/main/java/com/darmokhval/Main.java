package com.darmokhval;

import com.darmokhval.models.ParsedData;
import com.darmokhval.utility.DataProcessor;
import com.darmokhval.utility.InputParser;


public class Main {
    public static void main(String[] args) {
        String filePath = "test.txt";

        InputParser parser = new InputParser(filePath);
        ParsedData parsedData = parser.parse();
        DataProcessor.processQueries(parsedData);

        System.out.println("The program has finished execution");
    }
}
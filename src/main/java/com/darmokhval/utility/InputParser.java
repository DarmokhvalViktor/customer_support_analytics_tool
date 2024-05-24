package com.darmokhval.utility;

import com.darmokhval.models.ParsedData;
import com.darmokhval.models.Query;
import com.darmokhval.models.Timeline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Utility class responsible for reading file and extracting required data.
 */
public class InputParser {
    private final String pathToFile;
    private final ParsedData parsedData;

    public InputParser(String pathToFile) {
        this.pathToFile = pathToFile;
        this.parsedData = new ParsedData();
    }

    /**
     * Method reads file and form 'ParsedData' object, where queries and timelines stored as list of objects.
     * To keep track when query and when timeline added field "lineCount".
     */
    public ParsedData parse() {
        ClassLoader classLoader = InputParser.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(pathToFile)) {
            if (inputStream == null) {
                throw new IOException("File not found");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("C")) {
                    Timeline timeline = new Timeline();
                    AssignerUtility.assign(line, timeline);
                    parsedData.getTimelines().add(timeline);
                    lineCount++;

                } else if (line.startsWith("D")) {
                    Query query = new Query();
                    AssignerUtility.assign(line, query);
                    query.setLineCount(lineCount);
                    parsedData.getQueries().add(query);
                }
            }

        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }

        return parsedData;
    }
}

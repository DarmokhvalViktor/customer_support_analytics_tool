package com.darmokhval.utility;

import com.darmokhval.models.ParsedData;
import com.darmokhval.models.Query;
import com.darmokhval.models.Timeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class responsible for executing queries and printing result.
 */
public class DataProcessor {

    /**
     * method iterates over list of queries and executes them one by one.
     */
    public static void processQueries(ParsedData parsedData) {
        List<Timeline> timelines = parsedData.getTimelines();
        List<Query> queries = parsedData.getQueries();
        for(Query query: queries) {
            processQuery(timelines, query);
        }
    }

    /**
     * Method iterates over 'waiting timelines' and count average waiting time rounded to minutes.
     * Only matching lines defined before the query line is counted.
     */
    private static void processQuery(List<Timeline> timelines, Query query) {
        List<Integer> waitingTime = new ArrayList<>();

        for(int i = 0; i < query.getLineCount(); i++) {
            Timeline timeline = timelines.get(i);
            if(matches(timeline, query)) {
                waitingTime.add(timeline.getWaitingTime());
            }
        }
        if(waitingTime.isEmpty()) {
            System.out.println("-");
        } else {
            int average = (int) Math.round(waitingTime.stream().mapToInt(Integer::intValue).average().orElse(0));
            System.out.println(average);
        }
    }

    /**
     * Method checks if query params matches timeline data.
     * @return true if matches, false otherwise.
     */
    private static boolean matches(Timeline timeline, Query query) {
        boolean serviceIdMatches = query.getServiceId().equals("*") || timeline.getServiceId().equals(query.getServiceId());

        boolean variationIdMatches = query.getVariationId() == null || query.getVariationId().equals(timeline.getVariationId());

        boolean questionTypeIdMatches = query.getQuestionTypeId().equals("*") || timeline.getQuestionTypeId().equals(query.getQuestionTypeId());

        boolean categoryIdMatches = query.getCategoryId() == null || query.getCategoryId().equals(timeline.getCategoryId());

        boolean subCategoryIdMatches = query.getSubCategoryId() == null || query.getSubCategoryId().equals(timeline.getSubCategoryId());

        boolean responseTypeMatches = timeline.getResponseType().equals(query.getResponseType());

        boolean dateMatches = (timeline.getDate().isEqual(query.getDateFrom()) || timeline.getDate().isAfter(query.getDateFrom())) &&
                (timeline.getDate().isEqual(query.getDateTo()) || timeline.getDate().isBefore(query.getDateTo()));

        return serviceIdMatches &&
                variationIdMatches &&
                questionTypeIdMatches &&
                categoryIdMatches &&
                subCategoryIdMatches &&
                responseTypeMatches &&
                dateMatches;
    }
}

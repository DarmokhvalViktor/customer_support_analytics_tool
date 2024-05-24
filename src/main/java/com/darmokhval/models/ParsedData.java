package com.darmokhval.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility wrapper to transfer 'query' and 'timeline' to another class.
 */
public class ParsedData {
    private final List<Timeline> timelines = new ArrayList<>();
    private final List<Query> queries = new ArrayList<>();

    public List<Timeline> getTimelines() {
        return timelines;
    }

    public List<Query> getQueries() {
        return queries;
    }
}

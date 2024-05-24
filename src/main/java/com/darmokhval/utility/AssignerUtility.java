package com.darmokhval.utility;

import com.darmokhval.models.DefaultEntity;
import com.darmokhval.models.Query;
import com.darmokhval.models.Timeline;

import java.time.LocalDate;

/**
 * Utility class, responsible for mapping data from a file into Java objects.
 */
public class AssignerUtility {

    /**
     * assigning values into Java object, if object extends DefaultEntity class.
     */
    public static <T extends DefaultEntity> void assign(String line, T entity) {
        String[] chunks = line.split(" ");
        entity.setServiceId(getPartSafely(chunks[1], 0, 2));
        entity.setVariationId(getPartSafely(chunks[1], 1, 2));
        entity.setQuestionTypeId(getPartSafely(chunks[2], 0, 3));
        entity.setCategoryId(getPartSafely(chunks[2], 1, 3));
        entity.setSubCategoryId(getPartSafely(chunks[2], 2, 3));
        entity.setResponseType(chunks[3]);

        if(entity instanceof Timeline timeline) {
            timeline.setDate(parseDate(chunks[4]));
            timeline.setWaitingTime(Integer.parseInt(chunks[5]));
        } else if (entity instanceof Query query) {
            String[] dateParts = chunks[4].split("-");
            query.setDateFrom(parseDate(dateParts[0]));
            query.setDateTo(dateParts.length > 1
                    ? parseDate(dateParts[1])
                    : parseDate(dateParts[0]));
        }
    }

    /**
     * splitting data and returning required part of a line.
     */
    private static String getPartSafely(String value, int index, int expectedSize) {
        String[] parts = safeSplit(value, expectedSize);
        return index < parts.length ? parts[index] : null;
    }

    /**
     * splitting data if in valid format or throwing error.
     */
    private static String[] safeSplit(String part, int expectedSize) {
        String[] parts = part.split("\\.");
        if(parts.length > expectedSize || containsWildcard(part) && parts.length != 1) {
            throw new IllegalArgumentException("Invalid format: wildcard '*' must not be followed by additional parts");
        }
        return parts;
    }

    /**
     * checking if wildcard or specific service/question type.
     */
    private static boolean containsWildcard(String part) {
        return part.contains("*");
    }

    /**
     * Defining date format
     */
    private static LocalDate parseDate(String value) {
        return DefaultEntity.parseDate(value);
    }

}

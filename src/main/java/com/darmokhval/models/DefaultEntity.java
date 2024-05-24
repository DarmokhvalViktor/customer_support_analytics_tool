package com.darmokhval.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Abstract class to reduce boilerplate code.
 */
public abstract class DefaultEntity {
    private String serviceId;
    private String variationId;
    private String questionTypeId;
    private String categoryId;
    private String subCategoryId;
    private String responseType;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getVariationId() {
        return variationId;
    }

    public void setVariationId(String variationId) {
        this.variationId = variationId;
    }

    public String getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(String questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }
    public abstract void setDate(LocalDate date);

    public abstract void setWaitingTime(int waitingTime);
    public static LocalDate parseDate(String value) {
        return LocalDate.parse(value, DateTimeFormatter.ofPattern("d.M.yyyy"));
    }

    @Override
    public String toString() {
        return "DefaultEntity{" +
                "serviceId='" + serviceId + '\'' +
                ", variationId='" + variationId + '\'' +
                ", questionTypeId='" + questionTypeId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", subCategoryId='" + subCategoryId + '\'' +
                ", responseType='" + responseType + '\'' +
                '}';
    }
}

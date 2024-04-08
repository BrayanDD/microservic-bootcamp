package com.example.bootcamp.domain.util;

public class DomainConstants  {

    public static final String MAX_MIN_TECHNOLOGY = ": the number of technologies must be between 3 and 20.";
    public static final String REPETIED_ID_TECHNOLOGY = ": technology IDs are duplicated.";
    public static final String MAX_MIN_CAPACITY = ": the number of capacities must be between 1 and 4.";
    public static final String REPETIED_ID_CAPACITY = ": capacity IDs are duplicated.";
    public static final String END_DATE_BEFORE_START_DATE = "End date cannot be before start date.";


    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static class TechnologyException extends RuntimeException {
        
        public TechnologyException(String message) {
            super(message);
        }
    }

    public static class CapacityException extends RuntimeException {

        public CapacityException(String message) {
            super(message);
        }
    }

    public static class VersionException extends RuntimeException {

        public VersionException(String message) {
            super(message);
        }
    }
}

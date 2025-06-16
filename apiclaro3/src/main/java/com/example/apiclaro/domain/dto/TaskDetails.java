package com.example.apiclaro.domain.dto;

public record TaskDetails(String title, String description, boolean completed) {


    public TaskDetails(String title, String description) {
        this(title, description, false);
    }


    @Override
    public String toString() {
        return "TaskDetails {\n" +
                "  title: " +
                "'" + title + "'" +
                ",\n" +
                "  description: " +
                "'" + description + "'" +
                ",\n" +
                "  completed: " +
                completed +
                "\n}";
    }

}

package com.example.apiclaro.domain;

import java.time.LocalDateTime;

public record TaskDetails(String title, String description, boolean completed, LocalDateTime createdAt, LocalDateTime updatedAt) {


    public TaskDetails(String title, String description) {
        this(title, description, false, LocalDateTime.now(), LocalDateTime.now());
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
                ",\n" +
                "  createdAt: " +
                createdAt +
                ",\n" +
                "  updatedAt: " +
                updatedAt +
                "\n}";
    }
}

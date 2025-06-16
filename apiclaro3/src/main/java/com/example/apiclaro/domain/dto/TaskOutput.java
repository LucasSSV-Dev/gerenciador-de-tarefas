package com.example.apiclaro.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskOutput(UUID id, String title, String description, boolean completed, LocalDateTime createdAt, LocalDateTime updatedAt) {

    @Override
    public String toString() {
        return "TaskOutput {\n" +
                "  id: " +
                id +
                ",\n" +
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

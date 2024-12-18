package com.repojava.spring_example2.model.records;

import java.time.LocalDateTime;

import com.repojava.spring_example2.model.enums.Location;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime stardtedOn,
        LocalDateTime completedOn,
        @Positive
        Integer km,
        Location localtion
) 
{
        public Run {
                if (!completedOn.isAfter(stardtedOn)) {
                        throw new IllegalArgumentException("The end date must be greater than the start date!");
                }
        }
}

package com.repojava.spring_example2.model.records;

import java.time.LocalDateTime;

import com.repojava.spring_example2.model.enums.Location;

public record Run(
        Integer id,
        String title,
        LocalDateTime stardtedOn,
        LocalDateTime completedOn,
        Integer km,
        Location localtion
) {}

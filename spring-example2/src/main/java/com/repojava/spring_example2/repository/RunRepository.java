package com.repojava.spring_example2.repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.repojava.spring_example2.model.enums.Location;
import com.repojava.spring_example2.model.records.Run;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
    
    private List<Run> runs = new ArrayList<>();

    public List<Run> findAll() {
        return runs;
    }

    public Optional<Run> findById(Integer id) {
        return runs.stream().filter(
            run -> run.id() == id)
            .findFirst();
    }

    public void create(Run run) {
        runs.add(run);
    } 

    public void update(Integer id, Run run) {
        Optional<Run> runExisting = findById(id);
        
        if (runExisting.isPresent()) {
            runs.set(runs.indexOf(runExisting.get()), run);
        }
    }

    public void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init() {
        runs.add(
            new Run(1, "Night run", LocalDateTime.now(), LocalDateTime.now().plus(120, ChronoUnit.MINUTES), 5, Location.OUTDOOR)
        );
        runs.add(
            new Run(2, "Afternoon run", LocalDateTime.now().plus(1, ChronoUnit.DAYS), LocalDateTime.now().plus(120, ChronoUnit.MINUTES), 5, Location.INDOOR)
        );
    }
}

package com.repojava.spring_example2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repojava.spring_example2.model.records.Run;
import com.repojava.spring_example2.repository.RunRepository;

@RestController
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("/api/runs")
    List<Run> findAll() {
        return runRepository.findAll();
    }

}

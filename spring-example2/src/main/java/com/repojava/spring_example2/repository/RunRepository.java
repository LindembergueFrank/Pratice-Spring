package com.repojava.spring_example2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.repojava.spring_example2.model.records.Run;

@Repository
public class RunRepository {
    private final JdbcClient jdbcClient;

    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("select * from run")
            .query(Run.class)
            .list();
    }   
    
    public Optional<Run> findById(Integer id) {
        return jdbcClient.sql("SELECT id, title, started_on, completed_on, km, location FROM Run WHERE id = :id")
            .param("id", id)
            .query(Run.class)
            .optional();
    }

    public void create(Run run) {
        var update = jdbcClient.sql("INSERT INTO Run(id, title, started_on, completed_on, km, location) VALUES(?,?,?,?,?,?)")
            .params(List.of(run.id(), run.title(), run.stardtedOn(), run.completedOn(), run.km(), run.localtion().toString()))
            .update();

        Assert.state(update == 1, "Failed to create run: " + run.title());
    }

    public void update(Integer id, Run run) {
        var update = jdbcClient.sql("UPDATE Run SET title = ?, started_on = ?, completed_on = ?, km = ?, location = ? WHERE id = ?")
            .params(List.of(run.id(), run.title(), run.stardtedOn(), run.completedOn(), run.km(), run.localtion().toString(), id))
            .update();

        Assert.state(update == 1, "Failed to update run: " + run.title());
    }

    public void delete(Integer id) {
        var update = jdbcClient.sql("DELETE FROM Run WHERE id = :id")
            .param("id", id)
            .update();

            Assert.state(update == 1, "Failed to delete run: " + id);
    }

    public int count() {
        return jdbcClient.sql("SELECT * FROM Run").query().listOfRows().size();
    }

    public void saveAll(List<Run> runs) {
        runs.stream().forEach(this::create);
    }

    public List<Run> findByLocation(String location) {
        return jdbcClient.sql("SELECT * FROM Run WHERE location = :location")
            .param("location", location)
            .query(Run.class)
            .list();
    }

}

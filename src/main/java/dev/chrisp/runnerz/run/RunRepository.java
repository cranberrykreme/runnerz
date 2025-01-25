package dev.chrisp.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    void createRun(Run run) {
        runs.add(run);
    }

    void delete(Integer id){
        runs.removeIf(run -> run.id().equals(id));
    }

    void updateRun(Run run, Integer id) {
        Optional<Run> runToUpdate = findById(id);
        if(runToUpdate.isPresent()) {
            runs.set(runs.indexOf(runToUpdate.get()), run);
        }
    }

    @PostConstruct
    private void init(){
        runs.add(new Run(
                1,
                "Monday Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(1),
                3,
                Location.INDOOR));

        runs.add(new Run(
                2,
                "Monday Afternoon Run",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2),
                20,
                Location.OUTDOOR));
    }
}

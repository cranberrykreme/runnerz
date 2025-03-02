package dev.chrisp.runnerz.run;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class RunControllerTest {
    RunController runController;

    @BeforeEach
    void setUp() {
        RunRepository repository = Mockito.mock(RunRepository.class);
        when(repository.findAll()).thenReturn(generateListRuns());

        runController = new RunController(repository);
    }

    @Test
    void shouldFindAllRuns() {
        List<Run> runs = runController.findAll();
        assertEquals(1, runs.size(), "Should have returned one run.");
    }

    private List<Run> generateListRuns() {
        Run run = new Run(1, "hello", LocalDateTime.now().minusHours(1), LocalDateTime.now(), 15, Location.OUTDOOR);
        List<Run> runs = new ArrayList<Run>();
        runs.add(run);
        return runs;
    }
}
package test;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import unsw.loopmania.model.LoopManiaWorld;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


public class LoopManiaWorldTest {

    int width = 10;
    int height = 10;
    String gameMode = "Survival";
    List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
    // orderedPath.add(new Pair<>(1,1));
    LoopManiaWorld world = new LoopManiaWorld(gameMode, width, height, orderedPath);

    @Test
    public void possiblySpawnEnemiesTest() {

    }
}

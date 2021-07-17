package test;

import org.junit.jupiter.api.Test;

import unsw.loopmania.model.LoopManiaWorld;
import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.Enemies.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;


public class LoopManiaWorldTest {

    private static int width = 5;
    private static int height = 5;

    private List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
    private LoopManiaWorld world = new LoopManiaWorld("Standard", width, height, orderedPath);

    @Test
    public void receiveInventoryFullRewardsTest() {
    }

    @Test
    public void possiblySpawnEnemiesTest() {
    };

    @Test
    public void spawnVampiresFromVampireCastlesTest() {
    }

    @Test
    public void spawnZombiesFromZombiePits() {
    }

    @Test
    public void produceAlliesFromBarracksTest() {
    }

    @Test
    public void runBattlesTest() {
    }

    @Test
    public void loadVampireCardTest(){
    }

    @Test
    public void trapTest() {
    }

    @Test
    public void addUnequippedItemTest() {
    }

    @Test
    public void removeUnequippedInventoryItemByCoordinatesTest() {
    }

    @Test
    public void runTickMovesTest() {
    }

    @Test
    public void equipItemTest() {
    }

    @Test
    public void removeUnequippedInventoryItemTest() {
    }

    @Test
    public void convertCardToBuildingByCoordinatesTest() {
    }

    @Test
    public void gainDiscardCardRewardsTest() {
    }

    @Test
    public void isGoalCompletedTest() {
    }

    @Test
    public void reviveCharacterTest() {
    }
}

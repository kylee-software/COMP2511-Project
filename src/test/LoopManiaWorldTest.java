package test;

import org.junit.jupiter.api.Test;

import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.Enemies.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;


public class LoopManiaWorldTest {
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
    public void killEnemyTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        PathPosition position = new PathPosition(0, orderedPath);
        BasicEnemy enemy = new Slug(position);
    }

    @Test
    public void runBattlesTest() {
    }

    @Test
    public void getSupportEnemiesTest() {
    }

    @Test
    public void getSupportBuildingsTest() {
    }

    @Test
    public void loadVampireCardTest(){
    }

    @Test
    public void removeCardTest() {
    }

    @Test
    public void trapTest() {
    }

    @Test
    public void addUnequippedItemTest() {
    }

    @Test
    public void createItemTest() {
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
    public void getUnequippedInventoryItemEntityByCoordinatesTest() {
    }

    @Test
    public void removeItemByPositionInUnequippedInventoryItemsTest() {
    }

    @Test
    public void addDiscardRewardsTest() {
    }

    @Test
    public void getFirstAvailableSlotForItemTest() {
    }

    @Test
    public void shiftCardsDownFromXCoordinateTest() {
    }

    @Test
    public void moveBasicEnemiesTest() {
    }

    @Test
    public void possiblyGetBasicEnemySpawnPositionTest() {
    }

    @Test
    public void convertCardToBuildingByCoordinatesTest() {
    }

    @Test
    public void gainBattleRewardsTest() {
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

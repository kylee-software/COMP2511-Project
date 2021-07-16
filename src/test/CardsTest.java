package test.ItemsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import unsw.loopmania.model.*;

public class CardsTest {
    
    /**
     * Test: Character obtains rewards after discarding cards
     */
    @Test
    public void getDiscardRewardsTest() {
        LoopManiaWorld world = new LoopManiaWorld("Standard", width, height, orderedPath);
        getDiscardRewards(10,10,"HealthPotion");
        ArrayList<Item> unequipped = d.getUnequippedItems();
        assertEquals("HealthPotion");
}

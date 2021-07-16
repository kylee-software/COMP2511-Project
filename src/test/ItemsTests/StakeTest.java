package test.ItemsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import unsw.loopmania.LoopManiaWorld;

public class StakeTest {
    /**
     * Test: Creating Stake and adding to equipped items
     */
    @Test
    public void equipStakeTest() {
        LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
        Item i = d.addUnequippedItem("Stake");
        d.equipItem(i);
        ArrayList<Item> equipped = d.getEquippedItems();
        assertThat(equipped).hasOnlyElementsOfType(Stake.class).hasSize(1);
        ArrayList<Item> unequipped = d.getUnequippedItems();
        assertEquals(unequipped.size(), 0);
    }

    /**
     * Test: Creating Stake and adding to equipped items with Stake already equipped
     */
    @Test
    public void equipStakeOccupiedTest() {
        LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
        Item i1 = d.addUnequippedItem("Stake");
        d.equipItem(i1);
        Item i2 = d.addUnequippedItem("Stake");
        d.equipItem(i2);
        ArrayList<Item> equipped = d.getEquippedItems();
        assertThat(equipped).hasOnlyElementsOfType(Stake.class).hasSize(1);
        ArrayList<Item> unequipped = d.getUnequippedItems();
        assertEquals(unequipped.size(), 1);
    }
}


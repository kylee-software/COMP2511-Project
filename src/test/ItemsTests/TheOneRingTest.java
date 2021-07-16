package test.ItemsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import unsw.loopmania.LoopManiaWorld;

public class TheOneRingTest {
    /**
     * Test: Creating TheOneRing and adding to equipped items
     */
    @Test
    public void equipTheOneRingTest() {
        LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
        Item i = d.addUnequippedItem("TheOneRing");
        d.equipItem(i);
        ArrayList<Item> equipped = d.getEquippedItems();
        assertThat(equipped).hasOnlyElementsOfType(TheOneRing.class).hasSize(1);
        ArrayList<Item> unequipped = d.getUnequippedItems();
        assertEquals(unequipped.size(), 0);
    }

    /**
     * Test: Creating TheOneRing and adding to equipped items with TheOneRing already equipped
     */
    @Test
    public void equipTheOneRingOccupiedTest() {
        LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
        Item i1 = d.addUnequippedItem("TheOneRing");
        d.equipItem(i1);
        Item i2 = d.addUnequippedItem("TheOneRing");
        d.equipItem(i2);
        ArrayList<Item> equipped = d.getEquippedItems();
        assertThat(equipped).hasOnlyElementsOfType(TheOneRing.class).hasSize(1);
        ArrayList<Item> unequipped = d.getUnequippedItems();
        assertEquals(unequipped.size(), 1);
    }
}


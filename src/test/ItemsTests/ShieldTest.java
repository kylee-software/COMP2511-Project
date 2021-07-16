package test.ItemsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import unsw.loopmania.LoopManiaWorld;

public class ShieldTest {
    /**
     * Test: Creating Shield and adding to equipped items
     */
    @Test
    public void equipShieldTest() {
        LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
        Item i = d.addUnequippedItem("Shield");
        d.equipItem(i);
        ArrayList<Item> equipped = d.getEquippedItems();
        assertThat(equipped).hasOnlyElementsOfType(Shield.class).hasSize(1);
        ArrayList<Item> unequipped = d.getUnequippedItems();
        assertEquals(unequipped.size(), 0);
    }

    /**
     * Test: Creating Shield and adding to equipped items with Shield already equipped
     */
    @Test
    public void equipShieldOccupiedTest() {
        LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
        Item i1 = d.addUnequippedItem("Shield");
        d.equipItem(i1);
        Item i2 = d.addUnequippedItem("Shield");
        d.equipItem(i2);
        ArrayList<Item> equipped = d.getEquippedItems();
        assertThat(equipped).hasOnlyElementsOfType(Shield.class).hasSize(1);
        ArrayList<Item> unequipped = d.getUnequippedItems();
        assertEquals(unequipped.size(), 1);
    }
}

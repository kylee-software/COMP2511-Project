package test.ItemsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import unsw.loopmania.LoopManiaWorld;

public class HelmetTest {
    /**
     * Test: Creating Helmet and adding to equipped items
     */
    @Test
    public void equipHelmetTest() {
        LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
        Item i = d.addUnequippedItem("Helmet");
        d.equipItem(i);
        ArrayList<Item> equipped = d.getEquippedItems();
        assertThat(equipped).hasOnlyElementsOfType(Helmet.class).hasSize(1);
        ArrayList<Item> unequipped = d.getUnequippedItems();
        assertEquals(unequipped.size(), 0);
    }

    /**
     * Test: Creating Helmet and adding to equipped items with Helmet already equipped
     */
    @Test
    public void equipHelmetOccupiedTest() {
        LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
        Item i1 = d.addUnequippedItem("Helmet");
        d.equipItem(i1);
        Item i2 = d.addUnequippedItem("Helmet");
        d.equipItem(i2);
        ArrayList<Item> equipped = d.getEquippedItems();
        assertThat(equipped).hasOnlyElementsOfType(Helmet.class).hasSize(1);
        ArrayList<Item> unequipped = d.getUnequippedItems();
        assertEquals(unequipped.size(), 1);
    }
}


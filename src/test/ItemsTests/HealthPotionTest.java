package test.ItemsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;

public class HealthPotionTest {
    /**
     * Test: Creating HealthPotion and adding to equipped items
     */
    @Test
    public void equipHealthPotionTest() {
        LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
        Item i = d.addUnequippedItem("HealthPotion");
        d.equipItem(i);
        ArrayList<Item> equipped = d.getEquippedItems();
        assertThat(equipped).hasOnlyElementsOfType(HealthPotion.class).hasSize(1);
        ArrayList<Item> unequipped = d.getUnequippedItems();
        assertEquals(unequipped.size(), 0);
    }

    /**
     * Test: Creating HealthPotion and adding to equipped items with HealthPotion already equipped
     */
    @Test
    public void equipHealthPotionOccupiedTest() {
        LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
        Item i1 = d.addUnequippedItem("HealthPotion");
        d.equipItem(i1);
        Item i2 = d.addUnequippedItem("HealthPotion");
        equipItem(i2);
        ArrayList<Item> equipped = d.getEquippedItems();
        assertThat(equipped).hasOnlyElementsOfType(HealthPotion.class).hasSize(1);
        ArrayList<Item> unequipped = d.getUnequippedItems();
        assertEquals(unequipped.size(), 1);
    }

    /**
     * Test: usePotion on character with missing health
     */
    @Test
    public void usePotionTest() {
        LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
        PathPostion position = new PathPosition(5, new List<Pair<0, 0>>);
        Character c = new Character(position);
        Item i = d.addUnequippedItem("HealthPotion");
        c.setHealth(36);
        i.usePotion(c);
        assertEquals(c.getHealth, 100);
        ArrayList<Item> unequipped = d.getUnequippedItems();
        assertEquals(unequipped.size(), 0);
    }
}


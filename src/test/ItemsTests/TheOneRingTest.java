package test.ItemsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;
// import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.model.Character;
import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.Items.RareItems.TheOneRing;

public class TheOneRingTest {
    // /**
    //  * Test: Creating TheOneRing and adding to equipped items
    //  */
    // @Test
    // public void equipTheOneRingTest() {
    //     LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
    //     Item i = d.addUnequippedItem("TheOneRing");
    //     d.equipItem(i);
    //     ArrayList<Item> equipped = d.getEquippedItems();
    //     assertThat(equipped).hasOnlyElementsOfType(TheOneRing.class).hasSize(1);
    //     ArrayList<Item> unequipped = d.getUnequippedItems();
    //     assertEquals(unequipped.size(), 0);
    // }

    // /**
    //  * Test: Creating TheOneRing and adding to equipped items with TheOneRing already equipped
    //  */
    // @Test
    // public void equipTheOneRingOccupiedTest() {
    //     LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
    //     Item i1 = d.addUnequippedItem("TheOneRing");
    //     d.equipItem(i1);
    //     Item i2 = d.addUnequippedItem("TheOneRing");
    //     d.equipItem(i2);
    //     ArrayList<Item> equipped = d.getEquippedItems();
    //     assertThat(equipped).hasOnlyElementsOfType(TheOneRing.class).hasSize(1);
    //     ArrayList<Item> unequipped = d.getUnequippedItems();
    //     assertEquals(unequipped.size(), 1);
    // }

    /**
     * Test: using TheOneRing only revives if dead
     */
    @Test
    public void usePotionTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        PathPosition position = new PathPosition(0, orderedPath);
        Character c = new Character(position);
        c.setHealth(30);
        TheOneRing ring = new TheOneRing(new SimpleIntegerProperty(0), new SimpleIntegerProperty(0));
        ring.usePotion(c);
        assertEquals(c.getHealth(), 30);
        c.setHealth(0);
        ring.usePotion(c);
        assertEquals(c.getHealth(), 100);
    }
}


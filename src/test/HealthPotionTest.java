package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.DisplayNameGenerator.Simple;

import javafx.beans.property.SimpleIntegerProperty;

import org.javatuples.Pair;
import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.Items.Item;
import unsw.loopmania.model.Items.BasicItems.HealthPotion;
import unsw.loopmania.model.Character;
// import unsw.loopmania.LoopManiaWorld;
// import unsw.loopmania.PathPosition;

public class HealthPotionTest {
    /**
     * Test: Potion revives character to full hp
     */
    @Test
    public void usePotionTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        PathPosition position = new PathPosition(0, orderedPath);
        Character c = new Character(position);
        Random r = new Random();
        c.setHealth(r.nextInt(99));
        SimpleIntegerProperty x = new SimpleIntegerProperty(1);
        SimpleIntegerProperty y = new SimpleIntegerProperty(1);
        Item potion = new HealthPotion(x, y);
        potion.usePotion(c);
        assertEquals(c.getHealth(), 100);
    }
    
    // /**
    //  * Test: Creating HealthPotion and adding to equipped items
    //  */
    // @Test
    // public void equipHealthPotionTest() {
    //     LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
    //     Item i = d.addUnequippedItem("HealthPotion");
    //     d.equipItem(i);
    //     ArrayList<Item> equipped = d.getEquippedItems();
    //     assertThat(equipped).hasOnlyElementsOfType(HealthPotion.class).hasSize(1);
    //     ArrayList<Item> unequipped = d.getUnequippedItems();
    //     assertEquals(unequipped.size(), 0);
    // }

    // /**
    //  * Test: Creating HealthPotion and adding to equipped items with HealthPotion already equipped
    //  */
    // @Test
    // public void equipHealthPotionOccupiedTest() {
    //     LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
    //     Item i1 = d.addUnequippedItem("HealthPotion");
    //     d.equipItem(i1);
    //     Item i2 = d.addUnequippedItem("HealthPotion");
    //     equipItem(i2);
    //     ArrayList<Item> equipped = d.getEquippedItems();
    //     assertThat(equipped).hasOnlyElementsOfType(HealthPotion.class).hasSize(1);
    //     ArrayList<Item> unequipped = d.getUnequippedItems();
    //     assertEquals(unequipped.size(), 1);
    // }

    // /**
    //  * Test: usePotion on character with missing health
    //  */
    // @Test
    // public void usePotionTest() {
    //     LoopManiaWorld d = new LoopManiaWorld(1, 2, new ArrayList<>());
    //     PathPostion position = new PathPosition(5, new List<Pair<0, 0>>);
    //     Character c = new Character(position);
    //     Item i = d.addUnequippedItem("HealthPotion");
    //     c.setHealth(36);
    //     i.usePotion(c);
    //     assertEquals(c.getHealth, 100);
    //     ArrayList<Item> unequipped = d.getUnequippedItems();
    //     assertEquals(unequipped.size(), 0);
    // }

    // /**
    //  * Test: Character obtains potion from picking up from the ground
    //  */
    // @Test
    // public void pickupPotionTest() {
    //     LoopManiaWorld d = new LoopManiaWorld(1,2, new ArrayList<>());
    //     PathPostion position = new PathPosition(5, new List<Pair<0, 0>>);
    //     Character c = new Character(position);
    //     // picks up pot need to add method for this
    //     pickUpPotion(c);
    //     ArrayList<Item> unequipped = d.getUnequippedItems();
    //     assertEquals('HealthPotion');
    // }

    // /**
    //  * Test: Character obtains potion from discarded card reward
    //  * ??? how to test this if reward is random
    //  */
    // @Test
    // public void discardRewardPotionTest() {
    //     LoopManiaWorld d = new LoopManiaWorld(1,2, new ArrayList<>());
    //     PathPostion position = new PathPosition(5, new List<Pair<0, 0>>);
    //     Character c = new Character(position);



    //  /**
    //   * Test: Character obtains potion from looting enemies after battle
    //   */
    // @Test
    // public void lootRewardPotionTest() {
    //     LoopManiaWorld d = new LoopManiaWorld(1,2, new ArrayList<>());
    //     PathPostion position = new PathPosition(5, new List<Pair<0, 0>>);
    //     Character c = new Character(position);
}

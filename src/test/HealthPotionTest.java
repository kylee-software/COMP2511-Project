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
}

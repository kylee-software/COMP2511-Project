package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.Character;
import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.Items.RareItems.TheOneRing;

public class TheOneRingTest {
    /**
     * Test: using TheOneRing only revives if dead
     */
    @Test
    public void usePotionTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
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


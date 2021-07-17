package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.Cards.*;
import unsw.loopmania.model.Cards.PositionStrategy.*;

public class CardsTest {
    
    /**
     * Test: Player can only drop barracks card on path tile
     */
    @Test
    public void validPositionOnPathTest() { 
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        Card barracks = new BarracksCard(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        assert(barracks.getPositionStrategy() instanceof OnPathBehaviour);
        assertEquals(barracks.validPosition(0, 0, orderedPath), false); 
        assertEquals(barracks.validPosition(1, 1, orderedPath), true); 
    }

    /**
     * Test: Player can only drop campfire card on non-path tile
     */
    @Test
    public void validPositionOffPathTest() { 
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        Card campfire = new CampfireCard(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        assert(campfire.getPositionStrategy() instanceof OffPathBehaviour);
        assertEquals(campfire.validPosition(1, 1, orderedPath), false); 
        assertEquals(campfire.validPosition(5, 5, orderedPath), true); 
    }

    /**
     * Test: Player can only drop campfire card on non-path tile
     */
    @Test
    public void validPositionAdjacentPathTest() { 
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        Card vampireCastle = new VampireCastleCard(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        assert(vampireCastle.getPositionStrategy() instanceof AdjacentPathBehaviour);
        assertEquals(vampireCastle.validPosition(1, 1, orderedPath), false);
        assertEquals(vampireCastle.validPosition(5, 5, orderedPath), false);
        assertEquals(vampireCastle.validPosition(0, 0, orderedPath), true); 
    }

    /**
     * Test: Character obtains rewards after discarding cards
     */
    @Test
    public void setItemRewardTest() {
        Card barracks = new BarracksCard(new SimpleIntegerProperty(), new SimpleIntegerProperty());
        barracks.setItemReward();
        assertNotNull(barracks.getItemReward());
        //System.out.println(barracks.getItemReward());
    }
}

package test;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.Buildings.Building;
import unsw.loopmania.model.Enemies.BasicEnemy;
import unsw.loopmania.model.AlliedSoldier;
import unsw.loopmania.model.Battle;
import unsw.loopmania.model.Character;

/**
 * Tests for battles in backend
 */
public class BattleTests {
    /**
     * Test isLost()
     */
    @Test
    public void isLostTest() {
        List<Pair<Integer, Integer>> dummyPath = new ArrayList<>();
        dummyPath.add(new Pair<>(0,0));
        PathPosition dummyPosition = new PathPosition(0, dummyPath);
        Character character = new Character(dummyPosition);
        List<Building> towers = new ArrayList<>();
        List<AlliedSoldier> allies = new ArrayList<>();
        List<BasicEnemy> enemies = new ArrayList<>();
        List<Building> campfires = new ArrayList<>();
        Battle battle = new Battle(character, towers, allies, enemies, campfires);
        assert(!battle.isLost());
        character.setHealth(0);
        assert(battle.isLost());
        character.setHealth(-12);
        assert(battle.isLost());
    }
}

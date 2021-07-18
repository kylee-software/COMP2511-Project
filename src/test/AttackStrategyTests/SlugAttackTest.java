package test.AttackStrategyTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.AttackStrategy.AttackStrategy;
import unsw.loopmania.model.AttackStrategy.BasicAttack;
import unsw.loopmania.model.AttackStrategy.SlugAttack;
import unsw.loopmania.model.Buildings.TowerBuilding;
import unsw.loopmania.model.Enemies.*;
import unsw.loopmania.model.AlliedSoldier;
import unsw.loopmania.model.Character;


public class SlugAttackTest {
    /**
     * Test BasicAttack strategy for an attack on a character
     */
    @Test
    public void attackCharacterExecuteTest() {
        List<Pair<Integer, Integer>> dummyPath = new ArrayList<>();
        dummyPath.add(new Pair<>(0,0));
        PathPosition dummyPosition = new PathPosition(0, dummyPath);
        Character character = new Character(dummyPosition);
        Slug attacker = new Slug(dummyPosition);
        AttackStrategy slugAttack = new SlugAttack();
        // Test attack with no defences
        slugAttack.execute(attacker, character, 0, 0, false);
        assertEquals(character.getHealth(), 93);
        // Check campfire does not affect damage
        character.setHealth(100);
        slugAttack.execute(attacker, character, 0, 0, true);
        assertEquals(character.getHealth(), 93);
        // Test attack with fixedDefences
        character.setHealth(100);
        slugAttack.execute(attacker, character, 0, 2, false);
        assertEquals(character.getHealth(), 95);
        // Test attack with scalarDefences
        character.setHealth(100);
        slugAttack.execute(attacker, character, 30, 0, false);
        assertEquals(character.getHealth(), 95);
    }

    /**
     * Test BasicAttack strategy for an allied soldier
     */
    @Test
    public void alliedSoldierExecuteTest() {
        List<Pair<Integer, Integer>> dummyPath = new ArrayList<>();
        dummyPath.add(new Pair<>(0,0));
        PathPosition dummyPosition = new PathPosition(0, dummyPath);
        AlliedSoldier attacker = new AlliedSoldier(dummyPosition);
        Slug enemy = new Slug(dummyPosition);
        AttackStrategy basicAttack = new BasicAttack();
        basicAttack.execute(attacker, enemy, 0, 0, false);
        assertEquals(enemy.getHealth(), 4);
        enemy.setHealth(10);
        // Check does not affect allied soldier damage
        basicAttack.execute(attacker, enemy, 0, 0, true);
        assertEquals(enemy.getHealth(), 4);
    }

    /**
     * Test BasicAttack strategy for a tower
     */
    @Test
    public void towerExecuteTest() {
        List<Pair<Integer, Integer>> dummyPath = new ArrayList<>();
        dummyPath.add(new Pair<>(0,0));
        PathPosition dummyPosition = new PathPosition(0, dummyPath);
        TowerBuilding attacker = new TowerBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(0));
        Slug enemy = new Slug(dummyPosition);
        AttackStrategy basicAttack = new BasicAttack();
        basicAttack.execute(attacker, enemy, 0, 0, false);
        assertEquals(enemy.getHealth(), 7);
        enemy.setHealth(10);
        // Check campfire does not affect tower damage
        basicAttack.execute(attacker, enemy, 0, 0, true);
        assertEquals(enemy.getHealth(), 7);
    }    
}

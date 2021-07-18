package test;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;
import unsw.loopmania.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import unsw.loopmania.model.*;
import unsw.loopmania.model.Character;
import unsw.loopmania.model.AttackStrategy.TowerAttack;
import unsw.loopmania.model.Buildings.*;
import unsw.loopmania.model.Enemies.*;

public class BuildingsTests {

    @Test
    void VampireCastleTest() {
        VampireCastleBuilding vampireCastleBuilding = new VampireCastleBuilding(new SimpleIntegerProperty(5), new SimpleIntegerProperty(5));
        
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));
        PathPosition position = new PathPosition(1, orderedPath);

        int cycle = 1;
        assertNull(vampireCastleBuilding.spawnVampire(cycle, position));

        cycle = 5;
        assertNotNull(vampireCastleBuilding.spawnVampire(cycle, position));
    }

    @Test
    void ZombiePitTest() {
        ZombiePitBuilding zombiePitBuilding = new ZombiePitBuilding(new SimpleIntegerProperty(5), new SimpleIntegerProperty(5));
       
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));
        PathPosition position = new PathPosition(1, orderedPath);

        int cycle = 0;
        assertNull(zombiePitBuilding.spawnZombie(cycle, position));

        cycle = 1;
        assertNotNull(zombiePitBuilding.spawnZombie(cycle, position));
    }

    // TODO = wait until Sam implements attack strategy
    @Test
    void TowerTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));
        PathPosition vampirePathPosition = new PathPosition(1, orderedPath);
        Vampire vampire = new Vampire(vampirePathPosition);
        int vampireX = vampirePathPosition.getX().intValue();
        int vampireY = vampirePathPosition.getY().intValue();
        TowerBuilding towerBuilding = new TowerBuilding(new SimpleIntegerProperty(vampireX + 1), new SimpleIntegerProperty(vampireY + 1));
        // towerBuilding.attackStrategy(new TowerAttack());
        // assert(vampire.getHealth < 100);
    }

    @Test
    void VillageTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));
        PathPosition position = new PathPosition(1, orderedPath);
        Character character = new Character(position);
        character.reduceHealth(50);

        VillageBuilding villageBuilding = new VillageBuilding(position);
        villageBuilding.gainHealth(character);

        assertEquals(character.getHealth(), 100);
    }

    @Test
    void BarrackTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));
        PathPosition position = new PathPosition(1, orderedPath);
        BarracksBuilding barracksBuilding = new BarracksBuilding(position);
       
        assertNotNull(barracksBuilding.spawnAlliedSoldier(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1)));
    }

    @Test
    void TrapTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));
        PathPosition position = new PathPosition(1, orderedPath);
        TrapBuilding trapBuilding = new TrapBuilding(position);
        
        BasicEnemy slug = new Slug(position);
        assertEquals(trapBuilding.damageEnemy(slug), 0);

        BasicEnemy vampire = new Vampire(position);
        assertEquals(trapBuilding.damageEnemy(vampire), 40);
        // TODO: need to check whether the trap is destroyed or not
    }

    @Test
    void CampfireTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));
        PathPosition vampirePathPosition = new PathPosition(1, orderedPath);

        Vampire vampire = new Vampire(vampirePathPosition);
        
        int vampireX = vampirePathPosition.getX().intValue();
        int vampireY = vampirePathPosition.getY().intValue();
        CampfireBuilding campfireBuilding = new CampfireBuilding(new SimpleIntegerProperty(vampireX + 1), new SimpleIntegerProperty(vampireY));
        // Test scaring vampire
        // vampire.runFromCampfire();

        // TODO: Test strategy of double damage in battle
        // Character character = new Character(new PathPosition(2, orderedPath));
        // campfireBuilding.performDamage(character, vampire);
        // assert(vampire.getHealth() == 100 - campfireBuilding.getDamageBonus());

    }
    // Not sure if need this anymore since it's tested in menu tests
    // @Test
    // void HerosCastleBuilding() {
    //     List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
    //     orderedPath.add(new Pair<>(1,1));
    //     orderedPath.add(new Pair<>(1,2));
    //     orderedPath.add(new Pair<>(1,3));
    //     HerosCastleBuilding herosCastleBuilding = new HerosCastleBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(0));

    //     Shield shield = new Shield(new SimpleIntegerProperty(), new SimpleIntegerProperty());

    //     // Buy item
    //     herosCastleBuilding.buyItem(shield, null);
    //     assert(herosCastleBuilding.getBoughtItems() != null);

    //     // sell item
    //     herosCastleBuilding.sellItem(shield, null);
    //     assert(herosCastleBuilding.getBoughtItems().isEmpty());
    // }
}

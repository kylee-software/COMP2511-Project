package test;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;
import unsw.loopmania.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.*;
import unsw.loopmania.controller.LoopManiaWorldLoader;
import unsw.loopmania.model.*;
import unsw.loopmania.model.Character;
import unsw.loopmania.model.AttackStrategy.TowerAttack;
import unsw.loopmania.model.Buildings.*;
import unsw.loopmania.model.Enemies.*;
import unsw.loopmania.model.Items.BasicItems.Shield;

public class BuildingsTests {

    // private JSONObject json = new JSONObject(new JSONTokener(new FileReader("worlds/world_with_twists_and_turns.json")));

    // int width = json.getInt("width");
    // int height = json.getInt("height");

    // // path variable is collection of coordinates with directions of path taken...
    // List<Pair<Integer, Integer>> orderedPath = LoopManiaWorldLoader.loadPathTiles(json.getJSONObject("path"), width, height);
    // LoopManiaWorld world = new LoopManiaWorld("Standard", width, height, orderedPath);
    
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

        assertNotNull(zombiePitBuilding.spawnZombie(position));
    }

    // TODO = fix this and figure out attack strategy
    @Test
    void TowerTest() {

        PathPosition vampirePathPosition = new PathPosition(5, orderedPath);

        SimpleIntegerProperty vampireX = vampirePathPosition.getX();
        SimpleIntegerProperty vampireY = vampirePathPosition.getY();

        Vampire vampire = new Vampire(vampirePathPosition, 100, "Vampire");
        TowerBuilding towerBuilding = new TowerBuilding(vampireX + new SimpleIntegerProperty(1), vampireY + new SimpleIntegerProperty(1), 100);

        towerBuilding.attackStrategy(new TowerAttack());

        assert(vampire.getHealth < 100);
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
        
        // TODO: fix up when enemies classes are pushed
        BasicEnemy slug = new Slug(position, "Slug");
        assertEquals(trapBuilding.damageEnemy(slug), 0);

        BasicEnemy vampire = new Vampire(position, "Vampire");
        assertEquals(trapBuilding.damageEnemy(vampire), 40);
        // TODO: need to check whether the trap is destroyed or not
    }

    @Test
    void CampfireTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));
        PathPosition position = new PathPosition(1, orderedPath);

        Character character = new Character(position);

        CampfireBuilding campfireBuilding = new CampfireBuilding(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));

        campfireBuilding.performDamage(character);

        assert(character.getHealth() == 100 - campfireBuilding.getDamageBonus());

    }

    @Test
    void HerosCastleBuilding() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));
        HerosCastleBuilding herosCastleBuilding = new HerosCastleBuilding(new SimpleIntegerProperty(0), new SimpleIntegerProperty(0), "Standard");

        Shield shield = new Shield(new SimpleIntegerProperty(), new SimpleIntegerProperty());

        // Buy item
        herosCastleBuilding.buyItem(shield, null);
        assert(herosCastleBuilding.getBoughtItems() != null);

        // sell item
        herosCastleBuilding.sellItem(shield, null);
        assert(herosCastleBuilding.getBoughtItems().isEmpty());
    }
}

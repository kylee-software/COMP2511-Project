package test;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;
import unsw.loopmania.*;

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

    private JSONObject json = new JSONObject(new JSONTokener(new FileReader("worlds/world_with_twists_and_turns.json")));

    int width = json.getInt("width");
    int height = json.getInt("height");

    // path variable is collection of coordinates with directions of path taken...
    List<Pair<Integer, Integer>> orderedPath = LoopManiaWorldLoader.loadPathTiles(json.getJSONObject("path"), width, height);

    @Test
    void VampireCastleTest() {
        LoopManiaWorld world = new LoopManiaWorld("Standard", width, height, orderedPath);
        VampireCastleBuilding vampireCastleBuilding = new VampireCastleBuilding(new SimpleIntegerProperty(),
                                                                                new SimpleIntegerProperty());

        world.addBuilding(vampireCastleBuilding);

        List<BasicEnemy> enemiesBefore = world.getEnemies();

        vampireCastleBuilding.produceEntity(5);
        world.spawnVampiresFromVampireCastles();

        List<BasicEnemy> enemiesAfter = world.getEnemies();

        assert(enemiesBefore != enemiesAfter);
    }

    @Test
    void ZombiePitTest() {
        LoopManiaWorld world = new LoopManiaWorld("Standard", width, height, orderedPath);
        ZombiePitBuilding zombiePitBuilding = new ZombiePitBuilding(new SimpleIntegerProperty(),
                                                                            new SimpleIntegerProperty());

        world.addBuilding(zombiePitBuilding);

        List<BasicEnemy> enemiesBefore = world.getEnemies();

        zombiePitBuilding.produceEntity(1);
        world.spawnZombiesFromZombiePits();

        List<BasicEnemy> enemiesAfter = world.getEnemies();

        assert(enemiesBefore != enemiesAfter);
    }

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

        PathPosition pathPosition = new PathPosition(5, orderedPath);

        VillageBuilding villageBuilding = new VillageBuilding(pathPosition);

        // set a low health point for the Charcater
        Character character = new Character(pathPosition, 10);

        villageBuilding.addHealth(character);

        assert(character.getHealth() == 100);
    }

    @Test
    void BarrackTest() {

        LoopManiaWorld world = new LoopManiaWorld("Standard", width, height, orderedPath);

        PathPosition pathPosition = new PathPosition(5, orderedPath);

        BarracksBuilding barracksBuilding = new BarracksBuilding(pathPosition);
        world.addBuilding(barracksBuilding);

        Character character = new Character(pathPosition, 100);
        world.setCharacter(character);

        List<AlliedSoldier> alliedSoldiersBefore = world.getAlliedSoldiers();

        world.produceAlliesFromBarracks();

        List<AlliedSoldier> alliedSoldiersAfter = world.getAlliedSoldiers();

        assert(alliedSoldiersBefore != alliedSoldiersAfter);
    }

    @Test
    void TrapTest() {

        LoopManiaWorld world = new LoopManiaWorld("Standard", width, height, orderedPath);
        PathPosition pathPosition = new PathPosition(5, orderedPath);

        TrapBuilding trapBuilding = new TrapBuilding(pathPosition);
        world.addBuilding(trapBuilding);

        Vampire vampire = new Vampire(pathPosition, 100, "Vampire");
        world.addEnemy(vampire);

        world.trap();

        assert(vampire.getHealth() < 100);

        // TODO: need to check whether the trap is destroyed or not
    }

    @Test
    void CampfireTest() {

        PathPosition vampirePathPosition = new PathPosition(5, orderedPath);

        SimpleIntegerProperty campfireX = vampirePathPosition.getX() + new SimpleIntegerProperty(1);
        SimpleIntegerProperty campfireY = vampirePathPosition.getY() + new SimpleIntegerProperty(1);

        Character character = new Character(characterPathPosition, 100);
        CampfireBuilding campfireBuilding = new CampfireBuilding(campfireX, campfireY);

       campfireBuilding.performDamage(character);

        assert(character.getHealth() == 100 - campfireBuilding.getDamageBonus());

    }

    @Test
    void HerosCastleBuilding() {

        HerosCastleBuilding herosCastleBuilding = new HerosCastleBuilding(new SimpleIntegerProperty(), new SimpleIntegerProperty());

        Shield shield = new Shield(new SimpleIntegerProperty(), new SimpleIntegerProperty());

        // Buy item
        herosCastleBuilding.buyItem(shield);
        assert(herosCastleBuilding.getBoughtItems() != null);

        // sell item
        herosCastleBuilding.sellItem(shield);
        assert(herosCastleBuilding.getBoughtItems().isEmpty());
    }
}

package test;

import org.javatuples.Pair;
import org.junit.Test;
import unsw.loopmania.model.Buildings.VampireCastleBuilding;
import unsw.loopmania.model.Buildings.ZombiePitBuilding;
import unsw.loopmania.model.Character;
import unsw.loopmania.model.Enemies.Vampire;
import unsw.loopmania.model.Enemies.Zombie;
import unsw.loopmania.model.LoopManiaWorld;
import unsw.loopmania.model.PathPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SpawningTest {

    @Test
    public void SpawnSlugsTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));
        PathPosition pathPosition = new PathPosition(1, orderedPath);
        Character character =  new Character(pathPosition);

        Random random = new Random(1);
        int chance = random.nextInt(99);

        LoopManiaWorld world = new LoopManiaWorld(10, 10, orderedPath, new ArrayList<>(), new Random(1));
        world.setCharacter(character);

        if (chance < 50) {
            assertNotNull(world.SpawnSlugs());
        }

    }

    @Test
    public void SpawnVampireTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));

        PathPosition position = new PathPosition(1, orderedPath);

        VampireCastleBuilding vampireCastleBuilding = new VampireCastleBuilding(position.getX(), position.getY());

        Vampire vampire = vampireCastleBuilding.spawnVampire(5, position);

        assertNotNull(vampire);
    }

    @Test
    public void SpawnZombieTest() {

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));

        PathPosition position = new PathPosition(1, orderedPath);

        ZombiePitBuilding zombiePitBuilding = new ZombiePitBuilding(position.getX(), position.getY());

        Zombie zombie = zombiePitBuilding.spawnZombie(1, position);

        assertNotNull(zombie);
    }

    @Test
    public void SpawnItemTest() {

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));
        PathPosition pathPosition = new PathPosition(1, orderedPath);
        Character character =  new Character(pathPosition);

        Random random = new Random(1);
        int chance = random.nextInt(99);

        LoopManiaWorld world = new LoopManiaWorld(10, 10, orderedPath, new ArrayList<>(), new Random(1));
        world.setCharacter(character);

        if (chance < 15) {
            assertNotNull(world.possiblySpawnItem());
        }
    }

}

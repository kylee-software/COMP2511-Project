package test;

import org.javatuples.Pair;
import org.junit.Test;
import unsw.loopmania.model.Buildings.VampireCastleBuilding;
import unsw.loopmania.model.Buildings.ZombiePitBuilding;
import unsw.loopmania.model.Enemies.BasicEnemy;
import unsw.loopmania.model.Enemies.Vampire;
import unsw.loopmania.model.Enemies.Zombie;
import unsw.loopmania.model.Items.Item;
import unsw.loopmania.model.LoopManiaWorld;
import unsw.loopmania.model.PathPosition;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SpawningTest {

    @Test
    public void SpawnSlugsTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));

        LoopManiaWorld world = new LoopManiaWorld(10, 10, orderedPath, new ArrayList<>());
        List<BasicEnemy> spanningEnemies = world.SpawnSlugs();

        assertNotNull(spanningEnemies);

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
    public void SpawnGoldTest() {

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));

        LoopManiaWorld world = new LoopManiaWorld(10, 10, orderedPath, new ArrayList<>());
        Item item = world.possiblySpawnGold();

        assertNotNull(item);
    }

    @Test
    public void SpawnHealthPotionTest() {

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));

        LoopManiaWorld world = new LoopManiaWorld(10, 10, orderedPath, new ArrayList<>());
        Item item = world.possiblySpawnHealthPotions();

        assertNotNull(item);
    }

}

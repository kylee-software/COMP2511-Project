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
import static org.junit.jupiter.api.Assertions.assertNull;

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

        Vampire vampire1 = vampireCastleBuilding.spawnVampire(true, 1, position);
        assertNull(vampire1);

        Vampire vampire2 = vampireCastleBuilding.spawnVampire(false, 1, position);
        assertNull(vampire2);

        Vampire vampire3 = vampireCastleBuilding.spawnVampire(true, 5, position);
        assertNotNull(vampire3);
    }

    @Test
    public void SpawnZombieTest() {

        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));

        PathPosition position = new PathPosition(1, orderedPath);

        ZombiePitBuilding zombiePitBuilding = new ZombiePitBuilding(position.getX(), position.getY());

        Zombie zombie1 = zombiePitBuilding.spawnZombie(true, 0, position);
        assertNull(zombie1);

        Zombie zombie2 = zombiePitBuilding.spawnZombie(false, 0, position);
        assertNull(zombie2);

        Zombie zombie3 = zombiePitBuilding.spawnZombie(true, 1, position);
        assertNotNull(zombie3);

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

//    @Test
//    public void SpawnBossesTest() {
//
//        List<Pair<Integer, Integer>> orderedPath = new ArrayList<Pair<Integer, Integer>>();
//        orderedPath.add(new Pair<>(1,1));
//        orderedPath.add(new Pair<>(1,2));
//        orderedPath.add(new Pair<>(1,3));
//        PathPosition pathPosition = new PathPosition(0, orderedPath);
//
//        LoopManiaWorld world = new LoopManiaWorld(10, 10, orderedPath, new ArrayList<String>(),new Random(1));
//        Character character = new Character(pathPosition);
//        world.setCharacter(character);
//
//        for (int cycle = 0; cycle < 40; cycle++) {
//            world.completedACycle();
//            if (cycle == 19) {
//                // Test spawn Doggie
//                assertNotNull(world.spawnBosses());
//            }
//
//            if (cycle == 39) {
//                world.setExperience(10000);
//                // Test spawn Elan Muske
//                assertNotNull(world.spawnBosses());
//            }
//        }
//
//    }

}

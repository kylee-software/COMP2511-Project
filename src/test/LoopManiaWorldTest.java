package test;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.LoopManiaWorld;
import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.Cards.*;
import unsw.loopmania.model.Enemies.*;
import unsw.loopmania.model.AlliedSoldier;
import unsw.loopmania.model.Character;
import unsw.loopmania.model.Items.Item;
import unsw.loopmania.model.Items.BasicItems.*;
import unsw.loopmania.model.Items.RareItems.TheOneRing;
import unsw.loopmania.model.Buildings.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

public class LoopManiaWorldTest {

    private static int width = 5;
    private static int height = 5;
    private static List<String> rareItems = new ArrayList<String>();

    @Test
    public void receiveInventoryFullRewardsTest() {
    }

    @Test
    public void possiblySpawnEnemiesTest() {
    };

    @Test
    public void spawnVampiresFromVampireCastlesTest() {
    }

    @Test
    public void spawnZombiesFromZombiePits() {
    }

    @Test
    public void spawnAlliesFromBarracksTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1, 1));
        orderedPath.add(new Pair<>(1, 2));
        orderedPath.add(new Pair<>(1, 3));
        LoopManiaWorld world = new LoopManiaWorld(width, height, orderedPath, rareItems);
        
        new BarracksBuilding(new PathPosition(2, orderedPath));
        
        Character character = new Character(new PathPosition(1, orderedPath));
        List<AlliedSoldier> alliedSoldiers = world.spawnAllyFromBarracks();
        assert(alliedSoldiers.isEmpty());

        character.moveDownPath();
        alliedSoldiers = world.spawnAllyFromBarracks();
        assertNotNull(alliedSoldiers);
    }

    @Test
    public void runBattlesIntegrationTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        // Create a square loop
        orderedPath.add(new Pair<>(0,0)); // 0
        orderedPath.add(new Pair<>(1,0)); // 1
        orderedPath.add(new Pair<>(2,0)); // 2
        orderedPath.add(new Pair<>(3,0)); // 3
        orderedPath.add(new Pair<>(4,0)); // 4
        orderedPath.add(new Pair<>(5,0)); // 5
        orderedPath.add(new Pair<>(6,0)); // 6
        orderedPath.add(new Pair<>(7,0)); // 7
        orderedPath.add(new Pair<>(8,0)); // 8
        orderedPath.add(new Pair<>(8,1)); // 9
        orderedPath.add(new Pair<>(8,2)); // 10
        orderedPath.add(new Pair<>(8,3)); // 11
        orderedPath.add(new Pair<>(8,4)); // 12
        orderedPath.add(new Pair<>(8,5)); // 13
        orderedPath.add(new Pair<>(7,5)); // 14
        orderedPath.add(new Pair<>(6,5)); // 15
        orderedPath.add(new Pair<>(5,5)); // 16
        orderedPath.add(new Pair<>(4,5)); // 17
        orderedPath.add(new Pair<>(3,5)); // 18
        orderedPath.add(new Pair<>(2,5)); // 19
        orderedPath.add(new Pair<>(1,5)); // 20
        orderedPath.add(new Pair<>(0,5)); // 21
        orderedPath.add(new Pair<>(0,4)); // 22
        orderedPath.add(new Pair<>(0,3)); // 23
        orderedPath.add(new Pair<>(0,2)); // 24
        orderedPath.add(new Pair<>(0,1)); // 25

        LoopManiaWorld world = new LoopManiaWorld(9, 6, orderedPath, rareItems);

        // Initialise character on 5,0
        PathPosition characterPosition = new PathPosition(5, orderedPath);
        Character character = new Character(characterPosition);
        world.setCharacter(character);

        // Initialise 3 towers: (In range: T1, T2)
        // Card towerCard1 = world.loadCard("TowerBuilding");
        // Card towerCard2 = world.loadCard("TowerBuilding");
        // Card towerCard3 = world.loadCard("TowerBuilding");
        // Building tower1 = world.convertCardToBuilding(towerCard1.getX(), towerCard1.getY(), 4, 1);
        // Building tower2 = world.convertCardToBuilding(towerCard2.getX(), towerCard2.getY(), 7, 1);
        // Building tower3 = world.convertCardToBuilding(towerCard3.getX(), towerCard3.getY(), 5, 4);
        TowerBuilding tower1 = new TowerBuilding(new SimpleIntegerProperty(4), new SimpleIntegerProperty(1));
        TowerBuilding tower2 = new TowerBuilding(new SimpleIntegerProperty(7), new SimpleIntegerProperty(1));
        TowerBuilding tower3 = new TowerBuilding(new SimpleIntegerProperty(5), new SimpleIntegerProperty(4));
        world.addBuilding(tower1);
        world.addBuilding(tower2);
        world.addBuilding(tower3);

        // Initialise allies

        // Initialise enemies (In range: S1, S2, Z1, V1)
        PathPosition slug1Position = new PathPosition(4, orderedPath);
        Slug slug1 = new Slug(slug1Position);
        PathPosition slug2Position = new PathPosition(6, orderedPath);
        Slug slug2 = new Slug(slug2Position);
        PathPosition slug3Position = new PathPosition(10, orderedPath);
        Slug slug3 = new Slug(slug3Position);
        PathPosition slug4Position = new PathPosition(17, orderedPath);
        Slug slug4 = new Slug(slug4Position);
        world.addEnemy(slug1);
        world.addEnemy(slug2);
        world.addEnemy(slug3);
        world.addEnemy(slug4);


        PathPosition zombie1Position = new PathPosition(7, orderedPath);
        Zombie zombie1 = new Zombie(zombie1Position);
        PathPosition zombie2Position = new PathPosition(24, orderedPath);
        Zombie zombie2 = new Zombie(zombie2Position);
        world.addEnemy(zombie1);
        world.addEnemy(zombie2);

        PathPosition vampire1Postion = new PathPosition(3, orderedPath);
        Vampire vampire1 = new Vampire(vampire1Postion);
        PathPosition vampire2Postion = new PathPosition(15, orderedPath);
        Vampire vampire2 = new Vampire(vampire2Postion);
        world.addEnemy(vampire1);
        world.addEnemy(vampire2);

        // Initialise campfire (In range)
        // Card campfireCard = world.loadCard("CampfireBuilding");
        // Building campfire = world.convertCardToBuilding(campfireCard.getX(), campfireCard.getY(), 6, 1);
        CampfireBuilding campfire1 = new CampfireBuilding(new SimpleIntegerProperty(7), new SimpleIntegerProperty(1));
        CampfireBuilding campfire2 = new CampfireBuilding(new SimpleIntegerProperty(5), new SimpleIntegerProperty(1));

        world.addBuilding(campfire1);
        world.addBuilding(campfire2);


        world.runBattles();
        assert(world.getIsLost());
        assert(slug1.getHealth() <= 0);
        assert(slug2.getHealth() <= 0);
        assert(slug3.getHealth() == 10);
        assert(slug4.getHealth() == 10);
        assert(zombie1.getHealth() <= 0);
        assert(zombie2.getHealth() == 20);
        assert(vampire1.getHealth() == 26);
        assert(vampire2.getHealth() == 50);
    }

    @Test
    public void loadVampireCardTest(){
    }

    @Test
    public void trapTest() {
    }

    /**
     * Test depends on getUnequippedInventoryItemEntityByCoordinates()
     */
    @Test
    public void addUnequippedItemTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        LoopManiaWorld world = new LoopManiaWorld(width, height, orderedPath, rareItems);
        // Test item creation
        world.addUnequippedItem("Stake");
        Item stake = world.getUnequippedInventoryItemEntityByCoordinates(0, 0);
        assertEquals(stake.getClass(), Stake.class);
        world.addUnequippedItem("Sword");
        Item sword = world.getUnequippedInventoryItemEntityByCoordinates(1, 0);
        assertEquals(sword.getClass(), Sword.class);
        world.addUnequippedItem("Shield");
        Item shield = world.getUnequippedInventoryItemEntityByCoordinates(2, 0);
        assertEquals(shield.getClass(), Shield.class);
        world.addUnequippedItem("Armour");
        Item armour = world.getUnequippedInventoryItemEntityByCoordinates(3, 0);
        assertEquals(armour.getClass(), Armour.class);
        assertEquals(world.getUnequippedItems().size(), 4);
        world.addUnequippedItem("Helmet");
        Item helmet = world.getUnequippedInventoryItemEntityByCoordinates(0, 1);
        assertEquals(helmet.getClass(), Helmet.class);
        world.addUnequippedItem("Staff");
        Item staff = world.getUnequippedInventoryItemEntityByCoordinates(1, 1);
        assertEquals(staff.getClass(), Staff.class);
        world.addUnequippedItem("TheOneRing");
        Item theOneRing = world.getUnequippedInventoryItemEntityByCoordinates(2, 1);
        assertEquals(theOneRing.getClass(), TheOneRing.class);
        world.addUnequippedItem("HealthPotion");
        Item healthPotion = world.getUnequippedInventoryItemEntityByCoordinates(3, 1);
        assertEquals(healthPotion.getClass(), HealthPotion.class);
        
        // Test oldest item deleted when full
        world.addUnequippedItem("Sword");
        world.addUnequippedItem("Shield");
        world.addUnequippedItem("Armour");
        world.addUnequippedItem("Armour");
        world.addUnequippedItem("Sword");
        world.addUnequippedItem("Sword");
        world.addUnequippedItem("Armour");
        world.addUnequippedItem("Armour");
        assertEquals(world.getUnequippedItems().size(), 16);
        // First item should now set to type Sword
        world.addUnequippedItem("Sword");
        assertEquals(world.getUnequippedItems().size(), 16);
        Item item1 = world.getUnequippedInventoryItemEntityByCoordinates(0, 0);
        assertEquals(item1.getClass(), Sword.class);
        // Second item should now set to type Health Potion
        world.addUnequippedItem("HealthPotion");
        assertEquals(world.getUnequippedItems().size(), 16);
        Item item2 = world.getUnequippedInventoryItemEntityByCoordinates(1, 0);
        assertEquals(item2.getClass(), HealthPotion.class);
    }

    @Test
    public void unequipEquippedItemTest() {
    }

    @Test
    public void removeUnequippedInventoryItemByCoordinatesTest() {
    }

    @Test
    public void runTickMovesTest() {
    }

    /**
     * Test depends on getUnequippedInventoryItemEntityByCoordinates()
     */
    @Test
    public void equipItemTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        LoopManiaWorld world = new LoopManiaWorld(width, height, orderedPath, rareItems);
        // Test weapon slot
        world.addUnequippedItem("Sword");
        Item sword = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        Boolean success = world.equipItem(sword);
        assertEquals(success, true);
        world.addUnequippedItem("Stake");
        Item stake = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        assertEquals(stake.getClass(), Stake.class);
        success = world.equipItem(stake);
        assertEquals(success, false);
        world.addUnequippedItem("Staff");
        Item staff = world.getUnequippedInventoryItemEntityByCoordinates(1,0);
        assertEquals(staff.getClass(), Staff.class);
        success = world.equipItem(staff);
        assertEquals(success, false);
        // Test armour slot
        world.addUnequippedItem("Armour");
        Item armour1 = world.getUnequippedInventoryItemEntityByCoordinates(2,0);
        success = world.equipItem(armour1);
        assertEquals(success, true);
        world.addUnequippedItem("Armour");
        Item armour2 = world.getUnequippedInventoryItemEntityByCoordinates(2,0);
        success = world.equipItem(armour2);
        assertEquals(success, false);
        // Test shield slot
        world.addUnequippedItem("Shield");
        Item shield1 = world.getUnequippedInventoryItemEntityByCoordinates(3,0);
        success = world.equipItem(shield1);
        assertEquals(success, true);
        world.addUnequippedItem("Shield");
        Item shield2 = world.getUnequippedInventoryItemEntityByCoordinates(3,0);
        success = world.equipItem(shield2);
        assertEquals(success, false);
        // Test helmet slot
        world.addUnequippedItem("Helmet");
        Item helmet1 = world.getUnequippedInventoryItemEntityByCoordinates(0,1);
        success = world.equipItem(helmet1);
        assertEquals(success, true);
        world.addUnequippedItem("Helmet");
        Item helmet2 = world.getUnequippedInventoryItemEntityByCoordinates(0,1);
        success = world.equipItem(helmet2);
        assertEquals(success, false);
        // Test rare item slot
        world.addUnequippedItem("TheOneRing");
        Item theOneRing1 = world.getUnequippedInventoryItemEntityByCoordinates(1,1);
        success = world.equipItem(theOneRing1);
        assertEquals(success, true);
        world.addUnequippedItem("TheOneRing");
        Item theOneRing2 = world.getUnequippedInventoryItemEntityByCoordinates(1,1);
        success = world.equipItem(theOneRing2);
        assertEquals(success, false);
    }

    /**
     * Test depends on addUnequippedItem()
     */
    @Test
    public void removeUnequippedInventoryItemTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        LoopManiaWorld world = new LoopManiaWorld(width, height, orderedPath, rareItems);
        assertEquals(world.getUnequippedItems().size(), 0);
        world.removeUnequippedInventoryItemByCoordinates(0, 0);
        assertEquals(world.getUnequippedItems().size(), 0);
        world.addUnequippedItem("Stake");
        assertEquals(world.getUnequippedItems().size(), 1);
        world.removeUnequippedInventoryItemByCoordinates(0, 0);
        assertEquals(world.getUnequippedItems().size(), 0);
    }

    /**
     * Test depends on addUnequippedItem()
     */
    @Test
    public void getUnequippedInventoryItemEntityByCoordinatesTest() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        LoopManiaWorld world = new LoopManiaWorld(width, height, orderedPath, rareItems);
        Item item = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        assertEquals(item, null);
        world.addUnequippedItem("Stake");
        item = world.getUnequippedInventoryItemEntityByCoordinates(0,0);
        assertEquals(item.getClass(), Stake.class);
        world.addUnequippedItem("Sword");
        item = world.getUnequippedInventoryItemEntityByCoordinates(1,0);
        assertEquals(item.getClass(), Sword.class);
    }

    @Test
    public void convertCardToBuildingTestSuccess() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));
        LoopManiaWorld world = new LoopManiaWorld(width, height, orderedPath, rareItems);
        new TrapCard(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        world.loadCard("TrapCard");
        // Trap card is in first slot of card entities
        assert(world.getCardEntities().get(0) instanceof TrapCard);
        assertEquals(world.getCardEntities().get(0).getX(), 0);
        assertEquals(world.getCardEntities().get(0).getY(), 0);
        int cardNodeX = world.getCardEntities().get(0).getX();
        int cardNodeY = world.getCardEntities().get(0).getY();
        int buildingNodeX = 1;
        int buildingNodeY = 2;
        world.convertCardToBuilding(cardNodeX, cardNodeY, buildingNodeX, buildingNodeY);
        assert(world.getBuildingEntities().get(0) instanceof TrapBuilding);
        assertEquals(world.getBuildingEntities().get(0).getX(), buildingNodeX);
        assertEquals(world.getBuildingEntities().get(0).getY(), buildingNodeY);
        assert(world.getCardEntities().isEmpty());
    }

    @Test
    public void convertCardToBuildingTestFail() {
        List<Pair<Integer, Integer>> orderedPath = new ArrayList<>();
        orderedPath.add(new Pair<>(1,1));
        orderedPath.add(new Pair<>(1,2));
        orderedPath.add(new Pair<>(1,3));
        LoopManiaWorld world = new LoopManiaWorld(width, height, orderedPath, rareItems);
        new TrapCard(new SimpleIntegerProperty(1), new SimpleIntegerProperty(1));
        world.loadCard("TrapCard");
        // Trap card is in first slot of card entities
        assert(world.getCardEntities().get(0) instanceof TrapCard);
        assertEquals(world.getCardEntities().get(0).getX(), 0);
        assertEquals(world.getCardEntities().get(0).getY(), 0);
        int cardNodeX = world.getCardEntities().get(0).getX();
        int cardNodeY = world.getCardEntities().get(0).getY();
        int buildingNodeX = 2;
        int buildingNodeY = 2;
        Building newBuilding = world.convertCardToBuilding(cardNodeX, cardNodeY, buildingNodeX, buildingNodeY);
        assertNull(newBuilding);
        assert(world.getBuildingEntities().isEmpty());
        assert(world.getCardEntities().get(0) instanceof TrapCard);
    }

    @Test
    public void healCharacterInVillage() {
        
    }

    @Test
    public void gainDiscardCardRewardsTest() {

    }

    @Test
    public void isGoalCompletedTest() {
    }
}

package unsw.loopmania.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import unsw.loopmania.model.Buildings.Building;
import unsw.loopmania.model.Buildings.CampfireBuilding;
import unsw.loopmania.model.Buildings.TowerBuilding;
import unsw.loopmania.model.Buildings.VampireCastleBuilding;
import unsw.loopmania.model.Cards.Card;
import unsw.loopmania.model.Cards.VampireCastleCard;
import unsw.loopmania.model.Enemies.*;
import unsw.loopmania.model.Items.Item;
import unsw.loopmania.model.Items.BasicItems.*;
import unsw.loopmania.model.Items.RareItems.TheOneRing;

/**
 * A backend world.
 *
 * A world can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 */
public class LoopManiaWorld {

    public static final int unequippedInventoryWidth = 4;
    public static final int unequippedInventoryHeight = 4;

    /**
     * width of the world in GridPane cells
     */
    private int width;

    /**
     * height of the world in GridPane cells
     */
    private int height;

    /**
     * generic entitites - i.e. those which don't have dedicated fields
     */
    private List<Entity> nonSpecifiedEntities;

    private Character character;

    // DONE = expand the range of enemies
    private List<BasicEnemy> enemies;

    // TODO = expand the range of cards
    private List<Card> cardEntities;

    private List<Item> unequippedInventoryItems;

    // TODO = expand the range of buildings
    private List<Building> buildingEntities;

    /**
     * list of x,y coordinate pairs in the order by which moving entities traverse them
     */
    private List<Pair<Integer, Integer>> orderedPath;

    private List<AlliedSoldier> alliedSoldiers;

    private String gameMode;

    private static Boolean isLost = false;

    @FXML
    private Label worldExperience;
    private int experience;

    @FXML
    private Label worldGold;
    private int gold;

    @FXML
    private Label worldHealth;
    private int health = 100;

    private int cycles;

    private Item equippedAttackItem = null;

    private Item equippedHelmet = null;

    private Item equippedShield = null;

    private Item equippedArmour = null;

    private Item equippedRareItem = null;

    /**
     * create the world (constructor)
     * 
     * @param width width of world in number of cells
     * @param height height of world in number of cells
     * @param orderedPath ordered list of x, y coordinate pairs representing position of path cells in world
     */
    public LoopManiaWorld(int width, int height, List<Pair<Integer, Integer>> orderedPath) {
        this.gameMode = gameMode;
        if (worldExperience != null) {
            updateExperience();
        }
        if (worldGold != null) {
            updateGold();
        }

        this.width = width;
        this.height = height;
        nonSpecifiedEntities = new ArrayList<>();
        character = null;
        enemies = new ArrayList<>();
        cardEntities = new ArrayList<>();
        unequippedInventoryItems = new ArrayList<>();
        this.orderedPath = orderedPath;
        buildingEntities = new ArrayList<>();
    }

    public void setExperienceLabel(Label worldExperience) {
        this.worldExperience = worldExperience;
    }

    public void updateExperience() {
        worldExperience.setText("Experience: " + this.experience);
    }
    
    public void setGoldLabel(Label worldGold) {
        this.worldGold = worldGold;
    }

    public void updateGold() {
        worldGold.setText("Gold: " + this.gold);
    }

    public void setHealthLabel(Label worldHealth) {
        this.worldHealth = worldHealth;
    }

    public void updateHealth() {
        worldHealth.setText("Health: " + this.health);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getExperience() {
        return experience;
    }

    public List<Item> getUnequippedItems() {
        return unequippedInventoryItems;
    }

    /**
     * set the health that the character currently has
     * @param health health
     */
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * set the experience point(s) that the character currently has
     * @param experience experience point(s)
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void addExperience(int experience) {
        this.experience = getExperience() + experience;
    }

    public int getGold() {
        return gold;
    }

    public String getGameMode() {
        return gameMode;
    }

    /**
     * set the gold value that the charcater currently has
     * @param gold gold value
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addGold(int gold) {
        this.gold = getGold() + gold;
    }

    public int getCycles() {
        return cycles;
    }

    public Item getEquippedAttackItem() {
        return equippedAttackItem;
    }

    public Item getEquippedArmour() {
        return equippedArmour;
    }

    public Item getEquippedShield() {
        return equippedShield;
    }

    public Item getEquippedHelmet() {
        return equippedHelmet;
    }

    public Item getEquippedRareItem() {
        return equippedRareItem;
    }

    public List<Card> getEquippedCards() {
        // DONE = need to implement this correctly and add javadoc
        return cardEntities;
    }

    public List<Pair<Integer, Integer>> getOrderedPath() {
		return this.orderedPath;
    }

    public List<AlliedSoldier> getAlliedSoldiers() {
        return alliedSoldiers;
    }

    public void addAlliedSoldier(AlliedSoldier alliedSoldier) {
        getAlliedSoldiers().add(alliedSoldier);
    }

    public void receiveInventoryFullRewards() {
        // TODO = need to implement this correctly and add javadoc
        return;
    }

    // TODO: this might be unnecessary?
    public void incrementCycles() {
        cycles += 1;
    }

    public void addCard(Card card) {
        // TODO = need to implement this correctly and add javadoc
        return;
    }

    public void addBuilding(Building building) {
        // TODO = need to implement this correctly and add javadoc
    }

    public void addEnemy(BasicEnemy enemy) {
        // TODO = need to implement this correctly and add javadoc
    }

    public List<BasicEnemy> getEnemies() {
        return enemies;
    }

    /**
     * set the character. This is necessary because it is loaded as a special entity out of the file
     * @param character the character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    /**
     * add a generic entity (without it's own dedicated method for adding to the world)
     * @param entity
     */
    public void addEntity(Entity entity) {
        // for adding non-specific entities (ones without another dedicated list)
        // TODO = if more specialised types being added from main menu, add more methods like this with specific input types...
        nonSpecifiedEntities.add(entity);
    }

    /**
     * spawns enemies if the conditions warrant it, adds to world
     * @return list of the enemies to be displayed on screen
     */
    public List<BasicEnemy> possiblySpawnEnemies(){
        // TODO = expand this very basic version
        Pair<Integer, Integer> pos = possiblyGetBasicEnemySpawnPosition();
        List<BasicEnemy> spawningEnemies = new ArrayList<>();
        if (pos != null){
            int indexInPath = orderedPath.indexOf(pos);
            Slug enemy = new Slug(new PathPosition(indexInPath, orderedPath));
            enemies.add(enemy);
            spawningEnemies.add(enemy);
        }
        return spawningEnemies;
    }
    
    /**
     * spawn new vampire(s) that vampire castles produced
     */
    public void spawnVampiresFromVampireCastles() {
        // TODO = need to implement this correctly and add javadoc
    }

    /**
     * spawn new zombies(s) that zombie pits produced
     */
    public void spawnZombiesFromZombiePits() {
        // TODO = need to implement this correctly and add javadoc
    }

    /**
     * produce new allied soldiers(s) when the Character passes through barracks
     */
    public void produceAlliesFromBarracks() {
        // TODO = need to implement this correctly and add javadoc
    }

    /**
     * kill an enemy
     * @param enemy enemy to be killed
     */
    private void killEnemy(BasicEnemy enemy){
        enemy.destroy();
        enemies.remove(enemy);
    }

    /**
     * Run the expected battles in the world, based on current world state.
     * Adds entities in range to battle if an enemy in battle range.
     * Signals game lost if battle lost without TheOneRing.
     * Adds rewards, kills dead entities.
     * @return list of enemies which have been killed
     */
    public List<BasicEnemy> runBattles() {
        // TODO = modify this - currently the character automatically wins all battles without any damage!
        List<BasicEnemy> defeatedEnemies = new ArrayList<BasicEnemy>();
        for (BasicEnemy e: enemies){
            // Pythagoras: a^2+b^2 < radius^2 to see if within radius
            // TODO = you should implement different RHS on this inequality, based on influence radii and battle radii
            if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < 4){
                // fight...
                defeatedEnemies.add(e);
            }
        }
        for (BasicEnemy e: defeatedEnemies){
            // IMPORTANT = we kill enemies here, because killEnemy removes the enemy from the enemies list
            // if we killEnemy in prior loop, we get java.util.ConcurrentModificationException
            // due to mutating list we're iterating over
            killEnemy(e);
            setExperience(getExperience()+10);
            updateExperience();
            setGold(getGold()+2);
            updateGold();
            setHealth(getHealth() - 5);
            updateHealth();
        }
        return defeatedEnemies;
    }


    // /**
    //  * Run the expected battles in the world, based on current world state.
    //  * @return list of enemies which have been killed
    //  */
    // public List<BasicEnemy> runBattles() {
    //     List<BasicEnemy> defeatedEnemies = new ArrayList<BasicEnemy>();
    //     List<BasicEnemy> battleEnemies = new ArrayList<BasicEnemy>();
    //     List<Building> battleTowers = new ArrayList<Building>();
    //     List<Building> battleCampfires = new ArrayList<Building>();
    //     Boolean enemyInBattleRange = false;

    //     // Check if enemies within battle range
    //     for (BasicEnemy e: enemies){
    //         // Pythagoras: a^2+b^2 < radius^2 to see if within radius
    //         double battleRadiusSquared = Math.pow(e.getBattleRadius(), 2);
    //         if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < battleRadiusSquared){
    //             battleEnemies.add(e);
    //             enemyInBattleRange = true;
    //             break;
    //         }
    //     }
    //     // No battle if no enemies in battle range
    //     if (!enemyInBattleRange) {
    //         return defeatedEnemies;
    //     }
    //     // Add all support enemies if an enemy in battle range
    //     battleEnemies.addAll(getSupportEnemies());
    //     // Add all towers
    //     battleTowers.addAll(getSupportBuildings("Tower"));
    //     // Add all campfires
    //     battleCampfires.addAll(getSupportBuildings("Campfire"));

    //     // Battle
    //     Battle battle = new Battle(character, battleTowers, alliedSoldiers, battleEnemies, battleCampfires);
    //     battle.fight();

    //     // Kill dead enemies
    //     for (BasicEnemy enemy : battle.getKilledEnemies()) {
    //         killEnemy(enemy);
    //     }
    //     // Kill dead allies
    //     for (AlliedSoldier ally : battle.getKilledAllies()) {
    //         alliedSoldiers.remove(ally);
    //     }
    //     if (battle.isLost()) {
    //         // Check has The One Ring
    //         if (equippedRareItem.getClass().equals(TheOneRing.class)) {
                // Item theOneRing = getEquippedRareItem();
                // theOneRing.usePotion(character);
    //             equippedRareItem = null;
    //         } else {
    //             // Game Lost
    //             isLost = true;
    //         }
    //     } else {
    //         gainBattleRewards(battle);
    //     }
    //     return defeatedEnemies;
    // }

    /**
     * Returns list of all enemies in support range
     * @return support enemies list
     */
    private List<BasicEnemy> getSupportEnemies() {
        List<BasicEnemy> supportEnemies = new ArrayList<BasicEnemy>();
        for (BasicEnemy e: enemies){
            double supportRadiusSquared = Math.pow(e.getSupportRadius(), 2);
            if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < supportRadiusSquared){
                supportEnemies.add(e);
            }
        }
        return supportEnemies;
    }

    /**
     * Returns list of all towers/campfires in support range
     * @param type - 'Campfire' or 'Tower'
     * @return buildings list
     */
    private List<Building> getSupportBuildings(String type) {
        List<Building> buildings = new ArrayList<Building>();
        for (Building b : buildingEntities){
            if (
                (type.equals("Tower") && b.getClass().equals(TowerBuilding.class)) ||
                (type.equals("Campfire") && b.getClass().equals(CampfireBuilding.class))
            ) {
                double battleRadiusSquared = Math.pow(b.getBattleRadius(), 2);
                if (Math.pow((character.getX()-b.getX()), 2) +  Math.pow((character.getY()-b.getY()), 2) < battleRadiusSquared){
                    buildings.add(b);
                }
            }
        }
        return buildings;
    }

    /**
     * spawn a card in the world and return the card entity
     * @return a card to be spawned in the controller as a JavaFX node
     */
    public VampireCastleCard loadVampireCard(){
        // if adding more cards than have, remove the first card...
        if (cardEntities.size() >= getWidth()){
            // TODO = give some cash/experience/item rewards for the discarding of the oldest card
            removeCard(0);
        }
        VampireCastleCard vampireCastleCard = new VampireCastleCard(new SimpleIntegerProperty(cardEntities.size()), new SimpleIntegerProperty(0));
        cardEntities.add(vampireCastleCard);
        return vampireCastleCard;
    }

    /**
     * remove card at a particular index of cards (position in gridpane of unplayed cards)
     * @param index the index of the card, from 0 to length-1
     */
    private void removeCard(int index){
        Card c = cardEntities.get(index);
        int x = c.getX();
        c.destroy();
        cardEntities.remove(index);
        shiftCardsDownFromXCoordinate(x);
    }

    public void trap() {
        // TODO = need to implement this correctly and add javadoc
    }

    /**
     * spawn a sword in the world and return the sword entity
     * @return a sword to be spawned in the controller as a JavaFX node
     */
    public Sword addUnequippedSword(){
        // TODO = expand this - we would like to be able to add multiple types of items, apart from swords
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // eject the oldest unequipped item and replace it... oldest item is that at beginning of items
            // TODO = give some cash/experience rewards for the discarding of the oldest sword
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
        }

        // now we insert the new sword, as we know we have at least made a slot available...
        Sword sword = new Sword(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        unequippedInventoryItems.add(sword);
        return sword;
    }

    /**
     * Adds a new item of given type to unequipped inventory
     * @param type - item type to create
     */
    public void addUnequippedItem(String type){
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // Eject the oldest unequipped item and replace it
            // Oldest item is that at beginning of items
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
            setExperience(getExperience() + 100);
        }
        Item item = createItem(type, firstAvailableSlot);
        unequippedInventoryItems.add(item);
    }


    /**
     * Spawns given item in the world
     * @param type - string with capital first letter (eg. Armour, Stake, HealthPotion, etc.)
     * @param firstAvailableSlot - unequipped inventory slot
     * @return item (returns null if invalid type provided)
     */
    private Item createItem(String type, Pair<Integer, Integer> firstAvailableSlot) {
        Item item = null;
        if (type.equals("Armour")) {
            item = new Armour(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        } else if (type.equals("HealthPotion")) {
            item = new HealthPotion(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        } else if (type.equals("Helmet")) {
            item = new Helmet(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        } else if (type.equals("Shield")) {
            item = new Shield(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        } else if (type.equals("Staff")) {
            item = new Staff(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        } else if (type.equals("Stake")) {
            item = new Stake(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        } else if (type.equals("Sword")) {
            item = new Sword(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        } else if (type.equals("TheOneRing")) {
            item = new TheOneRing(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
        }
        return item;
    }

    /**
     * remove an item by x,y coordinates
     * @param x x coordinate from 0 to width-1
     * @param y y coordinate from 0 to height-1
     */
    public void removeUnequippedInventoryItemByCoordinates(int x, int y) {
        Item item = getUnequippedInventoryItemEntityByCoordinates(x, y);
        if (item != null) {
            removeUnequippedInventoryItem(item);
        }
    }

    /**
     * run moves which occur with every tick without needing to spawn anything immediately
     */
    public void runTickMoves() {
        character.moveDownPath();
        moveBasicEnemies();
        runBattles();
    }

    /**
     * Given an unequippedItem equips it in equippedInventory into appropriate slot
     * @param item - item to equip
     * @return success status
     */
    public Boolean equipItem(Item item) {
        if (item.getType().equals("RareItem")) {
            if (equippedRareItem == null) {
                equippedRareItem = item;
            } else {
                return false;
            }
        } else if (item.getType().equals("Weapon")) {
            if (equippedAttackItem == null) {
                equippedAttackItem = item;
            } else {
                return false;
            }
        } else if (item.getType().equals("Helmet")) {
            if (equippedHelmet == null) {
                equippedHelmet = item;
            } else {
                return false;
            }
        } else if (item.getType().equals("Shield")) {
            if (equippedShield == null) {
                equippedShield = item;
            } else {
                return false;
            }
        } else if (item.getType().equals("Armour")) {
            if (equippedArmour == null) {
                equippedArmour = item;
            } else {
                return false;
            }
        } else if (item.getType().equals("HealthPotion")) {
            item.usePotion(this.character);
        }
        unequippedInventoryItems.remove(item);
        return true;
    }

    /**
     * remove an item from the unequipped inventory
     * @param item - item to be removed
     */
    private void removeUnequippedInventoryItem(Entity item) {
        item.destroy();
        unequippedInventoryItems.remove(item);
    }

    /**
     * return an unequipped inventory item by x and y coordinates
     * assumes that no 2 unequipped inventory items share x and y coordinates
     * @param x x index from 0 to width-1
     * @param y y index from 0 to height-1
     * @return unequipped inventory item at the input position
     */
    public Item getUnequippedInventoryItemEntityByCoordinates(int x, int y){
        for (Item e: unequippedInventoryItems){
            if ((e.getX() == x) && (e.getY() == y)){
                return e;
            }
        }
        return null;
    }

    /**
     * Remove item at a particular index in the unequipped inventory items list
     * (this is ordered based on age in the starter code)
     * Calls add discardRewards method
     * @param index index from 0 to length-1
     */
    private void removeItemByPositionInUnequippedInventoryItems(int index){
        Item item = unequippedInventoryItems.get(index);
        addDiscardRewards(item);
        item.destroy();
        unequippedInventoryItems.remove(index);
    }

    /**
     * Given an item being discarded adds rewards
     * @param item - item to be discarded
     */
    private void addDiscardRewards(Item item) {
        setExperience(getExperience() + item.getDiscardExp());
        setGold(getGold() + item.getDiscardGold());
    }

    /**
     * get the first pair of x,y coordinates which don't have any items in it in the unequipped inventory
     * @return x,y coordinate pair
     */
    private Pair<Integer, Integer> getFirstAvailableSlotForItem(){
        // first available slot for an item...
        // IMPORTANT - have to check by y then x, since trying to find first available slot defined by looking row by row
        for (int y=0; y<unequippedInventoryHeight; y++){
            for (int x=0; x<unequippedInventoryWidth; x++){
                if (getUnequippedInventoryItemEntityByCoordinates(x, y) == null){
                    return new Pair<Integer, Integer>(x, y);
                }
            }
        }
        return null;
    }

    /**
     * shift card coordinates down starting from x coordinate
     * @param x x coordinate which can range from 0 to width-1
     */
    private void shiftCardsDownFromXCoordinate(int x){
        for (Card c: cardEntities){
            if (c.getX() >= x){
                c.x().set(c.getX()-1);
            }
        }
    }

    /**
     * move all enemies
     */
    private void moveBasicEnemies() {
        // TODO = expand to more types of enemy
        for (BasicEnemy e: enemies){
            e.move();
        }
    }

    /**
     * get a randomly generated position which could be used to spawn an enemy
     * @return null if random choice is that wont be spawning an enemy or it isn't possible, or random coordinate pair if should go ahead
     */
    private Pair<Integer, Integer> possiblyGetBasicEnemySpawnPosition(){
        // TODO = modify this

        // has a chance spawning a basic enemy on a tile the character isn't on or immediately before or after (currently space required = 2)...
        Random rand = new Random();
        int choice = rand.nextInt(2); // TODO = change based on spec... currently low value for dev purposes...
        // TODO = change based on spec
        if ((choice == 0) && (enemies.size() < 2)){
            List<Pair<Integer, Integer>> orderedPathSpawnCandidates = new ArrayList<>();
            int indexPosition = orderedPath.indexOf(new Pair<Integer, Integer>(character.getX(), character.getY()));
            // inclusive start and exclusive end of range of positions not allowed
            int startNotAllowed = (indexPosition - 2 + orderedPath.size())%orderedPath.size();
            int endNotAllowed = (indexPosition + 3)%orderedPath.size();
            // note terminating condition has to be != rather than < since wrap around...
            for (int i=endNotAllowed; i!=startNotAllowed; i=(i+1)%orderedPath.size()){
                orderedPathSpawnCandidates.add(orderedPath.get(i));
            }

            // choose random choice
            Pair<Integer, Integer> spawnPosition = orderedPathSpawnCandidates.get(rand.nextInt(orderedPathSpawnCandidates.size()));

            return spawnPosition;
        }
        return null;
    }

    /**
     * remove a card by its x, y coordinates
     * @param cardNodeX x index from 0 to width-1 of card to be removed
     * @param cardNodeY y index from 0 to height-1 of card to be removed
     * @param buildingNodeX x index from 0 to width-1 of building to be added
     * @param buildingNodeY y index from 0 to height-1 of building to be added
     */
    public VampireCastleBuilding convertCardToBuildingByCoordinates(int cardNodeX, int cardNodeY, int buildingNodeX, int buildingNodeY) {
        // start by getting card
        Card card = null;
        for (Card c: cardEntities){
            if ((c.getX() == cardNodeX) && (c.getY() == cardNodeY)){
                card = c;
                break;
            }
        }

        // now spawn building
        VampireCastleBuilding newBuilding = new VampireCastleBuilding(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
        buildingEntities.add(newBuilding);

        // destroy the card
        card.destroy();
        cardEntities.remove(card);
        shiftCardsDownFromXCoordinate(cardNodeX);

        return newBuilding;
    }

    /**
     * Adds rewards from battle to character
     * @param battle
     */
    private void gainBattleRewards(Battle battle) {
        setGold(getGold() + battle.getBattleGold());
        setExperience(getExperience() + battle.getBattleExp());
        for (Card card : battle.getBattleCards()) {
            addCard(card);
        }
        for (Item item : battle.getBattleItems()) {
            //addUnequippedItem(item);
            addUnequippedSword();
        }
    }

    /**
     * Gives the player rewards when a card is discarded due to having too many
     * @param goldReward gold reward
     * @param expReward experience reward
     * @param itemReward item reward/s
     */
    public void gainDiscardCardRewards(int goldReward, int expReward, List<Item> itemReward) {
        addGold(goldReward);
        addExperience(expReward);
        // for (Item item : itemReward) addUnequippedItem(item);
    }

    /**
     * to check if the character completed all the goals or not to win
     * @return true if all goals are completed else false
     */
    public boolean isGoalCompleted() {
        // TODO:
        return false;
    }

    // private Item generateRandomBasicItem() {
    //     Random random = new Random();
    //     int randomInt = random.nextInt(6);
    //     if (randomInt == 0) {

    //     }
    // }

    // /**
    //  * Generates a list with every item subclass name
    //  * @return list of item names
    //  */
    // private List<String> allItemTypes() {
    //     List<String> items = new ArrayList<String>();
    //     items.add("Armour");
    //     items.add("HealthPotion");
    //     items.add("Helmet");
    //     items.add("Shield");
    //     items.add("Staff");
    //     items.add("Stake");
    //     items.add("Sword");
    //     return items;
    // }
}
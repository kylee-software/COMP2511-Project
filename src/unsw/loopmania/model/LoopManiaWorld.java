package unsw.loopmania.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javatuples.Pair;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import unsw.loopmania.model.Buildings.*;
import unsw.loopmania.model.Cards.*;

import unsw.loopmania.model.Enemies.BasicEnemy;
import unsw.loopmania.model.Enemies.Slug;
import unsw.loopmania.model.Enemies.Vampire;
import unsw.loopmania.model.Enemies.Zombie;
import unsw.loopmania.model.Goal.*;
import unsw.loopmania.model.Items.BasicItems.*;
import unsw.loopmania.model.Items.Item;
import unsw.loopmania.model.Items.RareItems.*;

/**
 * A backend world.
 *
 * A world can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 */
public class LoopManiaWorld {
    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                  Initializers for the Loop Mania World                                     │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    public static final int unequippedInventoryWidth = 4;
    public static final int unequippedInventoryHeight = 4;
    private int worldWidth;
    private int worldHeight;
    private List<String> rareItems;
    private Goal goal;
    private String gameMode;
    private Boolean isLost;

    // list of x,y coordinate pairs in the order by which moving entities traverse them
    private List<Pair<Integer, Integer>> orderedPath;

    private GoldGoal goldGoal;
    private CycleGoal cycleGoal;
    private ExperienceGoal experienceGoal;


    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                     Attributes Related to Character                                        │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    private Character character;
    
    @FXML
    private Label numAlliedSoldiers;    
    private List<AlliedSoldier> alliedSoldiers = new ArrayList<AlliedSoldier>();

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

    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                       Attributes Related to Enemies                                        │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    private List<BasicEnemy> enemies = new ArrayList<BasicEnemy>();

   /* ┌─────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
   /* │                                    Attributes Related to Buildings                                          │ */
   /* └─────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    // TODO = expand the range of buildings
    private  List<Building> buildingEntities = new ArrayList<Building>();
    private List<VampireCastleBuilding> vampireCastleBuildings = new ArrayList<VampireCastleBuilding>();
    private List<ZombiePitBuilding> zombiePitBuildings = new ArrayList<ZombiePitBuilding>();
    private List<BarracksBuilding> barracksBuildings = new ArrayList<BarracksBuilding>();
    private List<TrapBuilding> trapBuildings = new ArrayList<TrapBuilding>();
    private HerosCastleBuilding herosCastleBuilding;

    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                         Attributes Related to Items                                        │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    private List<Item> unequippedInventoryItems = new ArrayList<Item>();

    private Item equippedAttackItem = null;

    private List<Item> spawnedItems = new ArrayList<Item>();;

    private Item equippedHelmet = null;

    private Item equippedShield = null;

    private Item equippedArmour = null;

    private Item equippedRareItem = null;

    private List<Card> cardEntities = new ArrayList<Card>();;


    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                                  Unsure                                                    │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    // generic entitites - i.e. those which don't have dedicated fields
    private List<Entity> nonSpecifiedEntities = new ArrayList<Entity>();


    /*────────────────────────────────────────────────────────────────────────────────────────────────────────────────*/
    /*────────────────────────────────────────────────────────────────────────────────────────────────────────────────*/

    /**
     * create the world (constructor)
     * 
     * @param worldWidth worldWidth of world in number of cells
     * @param worldHeight worldHeight of world in number of cells
     * @param orderedPath ordered list of x, y coordinate pairs representing position of path cells in world
     */
    public LoopManiaWorld(int worldWidth, int worldHeight, List<Pair<Integer, Integer>> orderedPath, List<String> rareItems) {
        // TODO: this.gameMode = gameMode;
        if (worldExperience != null) {
            updateExperience();
        }
        if (worldGold != null) {
            updateGold();
        }

        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.orderedPath = orderedPath;
        this.rareItems = rareItems;
        this.isLost = false;
    }

    /**
     * run moves which occur with every tick without needing to spawn anything immediately
     */
    public void runTickMoves() {
        character.moveDownPath();
        pickupItems();
        moveBasicEnemies();
        updateGold();
    }


    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                Getters and Setters Related to the World                                    │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    public int getWidth() {
        return worldWidth;
    }

    public int getHeight() {
        return worldHeight;
    }

    public List<Pair<Integer, Integer>> getOrderedPath() {
        return this.orderedPath;
    }

    public String getGameMode() {
        return gameMode;
    }

    public int getCycles() {
        return cycles;
    }

    public boolean getIsLost() {
        return isLost;
    }

    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                               Getters and Setters Related to the Character                                 │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    public Character getCharacter() {
        return character;
    }

    /**
     * set the character. This is necessary because it is loaded as a special entity out of the file
     * @param character the character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setExperienceLabel(Label worldExperience) {
        this.worldExperience = worldExperience;
    }

    /**
     * set the experience point(s) that the character currently has
     * @param experience experience point(s)
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }
    
    public void setGoldLabel(Label worldGold) {
        this.worldGold = worldGold;
    }

    /**
     * set the gold value that the charcater currently has
     * @param gold gold value
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setHealthLabel(Label worldHealth) {
        this.worldHealth = worldHealth;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<AlliedSoldier> getAlliedSoldiers() {
        return alliedSoldiers;
    }

    public void setNumAlliedSoldiers(Label numAlliedSoldiers){
        this.numAlliedSoldiers = numAlliedSoldiers;
    }

    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                  Getters and Setters Related to Enemies                                    │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    public List<BasicEnemy> getEnemies() {
        return enemies;
    }

    /**
     * Returns list of all enemies in support range
     * @return support enemies list
     */
    private List<BasicEnemy> getSupportEnemies() {
        List<BasicEnemy> supportEnemies = new ArrayList<BasicEnemy>();
        for (BasicEnemy e: enemies){
            double supportRadiusSquared = Math.pow(e.getSupportRadius(), 2);
            if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) <= supportRadiusSquared){
                supportEnemies.add(e);
            }
        }
        return supportEnemies;
    }


    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                   Getters and Setters Related to Buildings                                 │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    public List<Building> getBuildingEntities() {
        return buildingEntities;
    }

    public void setHerosCastleBuilding(HerosCastleBuilding herosCastleBuilding) {
        this.herosCastleBuilding = herosCastleBuilding;
    }

    /**
     * Returns list of all towers/campfires in support range
     * @param type - 'Campfire' or 'Tower'
     * @return buildings list
     */
    private List<Building> getSupportBuildings(String type) {
        List<Building> buildings = new ArrayList<Building>();
        for (Building b : getBuildingEntities()){
            if (
                    (type.equals("Tower") && b.getClass().equals(TowerBuilding.class)) ||
                    (type.equals("Campfire") && b.getClass().equals(CampfireBuilding.class))
            ) {
                double battleRadiusSquared = Math.pow(b.getBattleRadius(), 2);
                if (Math.pow((character.getX()-b.getX()), 2) +  Math.pow((character.getY()-b.getY()), 2) <= battleRadiusSquared){
                    buildings.add(b);
                }
            }
        }
        return buildings;
    }

    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                    Getters and Setters Related to Items                                    │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    public List<Item> getUnequippedItems() {
        return unequippedInventoryItems;
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

    public List<Card> getCardEntities() {
        return cardEntities;
    }

    public List<Item> getUnequippedInventoryItems() {
        return unequippedInventoryItems;
    }

    public List<String> getRareItem() {
        return rareItems;
    }

    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                      Methods Related to the Character                                      │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    public void updateExperience() {
        worldExperience.setText("Experience: " + this.experience);
    }

    public void updateGold() {
        worldGold.setText("Gold: " + this.gold);
    }

    public void updateHealth() {
        worldHealth.setText("Health: " + this.health);
    }

    public void updateNumAlliedSoldiers(){
        numAlliedSoldiers.setText("Allied Soldiers: " + this.getAlliedSoldiers().size());
    }

    public void addGold(int gold) {
        this.gold = getGold() + gold;
    }


    public void addExperience(int experience) {
        this.experience = getExperience() + experience;
    }

    public void addAlliedSoldier(AlliedSoldier alliedSoldier) {
        getAlliedSoldiers().add(alliedSoldier);
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    /**
     * set the goals of the game
     * @param goals hash map of all goals
     */
    public void setGoals(List<Goal> goals) {

        this.experienceGoal = (ExperienceGoal) goals.get(0);
        this.goldGoal = (GoldGoal) goals.get(1);
        this.cycleGoal = (CycleGoal) goals.get(2);

    }
    /**
     * to check if the character completed all the goals or not to win
     * @return true if all goals are completed else false
     */
     // DONE
     public boolean isGoalCompleted() {
         cycleGoal.setWorldGoal(cycles);
         experienceGoal.setWorldGoal(experience);
         goldGoal.setWorldGold(gold);
         AndGoal goal = new AndGoal(cycleGoal, new OrGoal(experienceGoal, goldGoal));

         return goal.isGoalComplete();
     }

    /**
     * Check whether Character is alive
     * @param void 
     * @return true if Character is alive 
     */
    public boolean isAlive() {
        if (getHealth() > 0) return true;
        else return false;
    }


    /**
     * check is the character completed the current cycle or not
     * @return true if the character complected a cycle else false
     */
    public void completedACycle() {
        int charaX = character.getX();
        int charaY = character.getY();
        if (charaX == 0 && charaY == 0) {
            cycles += 1;
        }
    }
    
    public boolean canAccessHerosCastleMenu() {
        int charaX = character.getX();
        int charaY = character.getY();
        if (charaX == 0 && charaY == 0 && getCycles() > 0) 
            return true;
        else return false;
    }
    

    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                          Methods Related  to Enemies                                       │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    /**
     * kill an enemy
     * @param enemy enemy to be killed
     */
    private void killEnemy(BasicEnemy enemy){
        enemy.destroy();
        enemies.remove(enemy);
    }

    /**
     * move all enemies
     */
    private void moveBasicEnemies() {
        for (BasicEnemy e: enemies){
            e.move();
        }
    }

    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                               Spawn Entities                                               │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    /**
     * spawns slugs if the conditions warrant it, adds to world
     * @return list of the slugs to be displayed on screen
     */
    public List<BasicEnemy> SpawnSlugs() {
        Pair<Integer, Integer> pos = possiblyGetSpawnPosition(2);
        List<BasicEnemy> spawningEnemies = new ArrayList<BasicEnemy>();
        int slugSpawnChance = (new Random()).nextInt(4);
        if (pos != null && slugSpawnChance == 1){
            int indexInPath = orderedPath.indexOf(pos);
            BasicEnemy enemy = new Slug(new PathPosition(indexInPath, orderedPath));
            enemies.add(enemy);
            spawningEnemies.add(enemy);
        }

        return spawningEnemies;
    }

    /**
     * spawn new vampire(s) that vampire castles produced
     */
    public List<BasicEnemy> spawnVampiresFromVampireCastles() {

        List<BasicEnemy> spawningEnemies = new ArrayList<BasicEnemy>();

        for (VampireCastleBuilding vampireCastleBuilding : vampireCastleBuildings) {
            PathPosition pathPosition = spawnPositionFromBuilding(vampireCastleBuilding);
            Vampire vampire = vampireCastleBuilding.spawnVampire(cycles, pathPosition);
            if (vampire != null) {
                enemies.add(vampire);
                spawningEnemies.add(vampire);
            }
        }

        return spawningEnemies;
    }

    /**
     * spawn new zombies(s) that zombie pits produced
     */
    public List<BasicEnemy> spawnZombiesFromZombiePits() {
        // TODO: work with frontend
        List<BasicEnemy> spawningEnemies = new ArrayList<BasicEnemy>();

        for (ZombiePitBuilding zombiePitBuilding : zombiePitBuildings) {
            PathPosition pathPosition = spawnPositionFromBuilding(zombiePitBuilding);
            Zombie zombie = zombiePitBuilding.spawnZombie(cycles, pathPosition);
            if (zombie != null) {
                enemies.add(zombie);
                spawningEnemies.add(zombie);
            }
        }

        return spawningEnemies;

    }

    /**
     * spawns gold if the conditions warrant it, adds to world
     * @return list of the items to be displayed on screen
     */
    public Item possiblySpawnGold(){
        Pair<Integer, Integer> goldPos = possiblyGetSpawnPosition(5);
        Item item = createItem("Gold", goldPos);
        if (goldPos != null){
            int goldIndexInPath = orderedPath.indexOf(goldPos);
            PathPosition goldPosition = new PathPosition(goldIndexInPath, orderedPath);
            Gold gold = new Gold(goldPosition.getX(), goldPosition.getY());
            spawnedItems.add(gold);
        }
        return item;
    }

    /**
     * spawns health potions if the conditions warrant it, adds to world
     * @return list of the items to be displayed on screen
     */
    public Item possiblySpawnHealthPotions(){
        Pair<Integer, Integer> healthPotionPos = possiblyGetSpawnPosition(5);
        Item item = createItem("HealthPotion",healthPotionPos);
        if (healthPotionPos != null){
            int hpIndexInPath = orderedPath.indexOf(healthPotionPos);
            PathPosition hpPosition = new PathPosition(hpIndexInPath, orderedPath);
            HealthPotion healthPotion = new HealthPotion(hpPosition.getX(), hpPosition.getY());
            spawnedItems.add(healthPotion);
        }
        return item;
    }

    /**
     * produce new allied soldiers(s) when the Character passes through barracks
     */
    public List<AlliedSoldier> spawnAlliesFromBarracks() {
        // TODO = need to implement this correctly and add javadoc

        for (BarracksBuilding barracksBuilding : barracksBuildings) {
            if (isOnSameTile(character, barracksBuilding)) {
                AlliedSoldier alliedSoldier = barracksBuilding.spawnAlliedSoldier(new PathPosition(1, orderedPath));
                alliedSoldiers.add(alliedSoldier);
            }
        }

        return alliedSoldiers;
    }


    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                       Methods Related to the Battle                                        │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    // /**
    //  * Run the expected battles in the world, based on current world state.
    //  * Adds entities in range to battle if an enemy in battle range.
    //  * Signals game lost if battle lost without TheOneRing.
    //  * Adds rewards, kills dead entities.
    //  * @return list of enemies which have been killed
    //  */
    // public List<BasicEnemy> runBattles() {
    //     // TODO = modify this - currently the character automatically wins all battles without any damage!
    //     List<BasicEnemy> defeatedEnemies = new ArrayList<BasicEnemy>();
    //     for (BasicEnemy e: enemies){
    //         // Pythagoras: a^2+b^2 < radius^2 to see if within radius
    //         // TODO = you should implement different RHS on this inequality, based on influence radii and battle radii
    //         if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) < 4){
    //             // fight...
    //             defeatedEnemies.add(e);      
    //         }
    //     }
    //     for (BasicEnemy e: defeatedEnemies){
    //         // IMPORTANT = we kill enemies here, because killEnemy removes the enemy from the enemies list
    //         // if we killEnemy in prior loop, we get java.util.ConcurrentModificationException
    //         // due to mutating list we're iterating over
    //         killEnemy(e);
    //         setExperience(getExperience()+10);
    //         updateExperience();
    //         setGold(getGold()+2);
    //         updateGold();
    //         setHealth(getHealth() - 5);
    //         updateHealth();
    //     }
    //     System.out.println(defeatedEnemies);
    //     return defeatedEnemies;
    // }


    /**
     * Run the expected battles in the world, based on current world state.
     * Adds entities in range to battle if an enemy in battle range.
     * Signals game lost if battle lost without TheOneRing.
     * Adds rewards, kills dead entities.
     * @return list of enemies which have been killed
     */
    public List<BasicEnemy> runBattles() {
        List<BasicEnemy> defeatedEnemies = new ArrayList<BasicEnemy>();
        List<BasicEnemy> battleEnemies = new ArrayList<BasicEnemy>();
        List<Building> battleTowers = new ArrayList<Building>();
        List<Building> battleCampfires = new ArrayList<Building>();
        Boolean enemyInBattleRange = false;

        // Check if enemies within battle range
        for (BasicEnemy e: enemies){
            // Pythagoras: a^2+b^2 <= radius^2 to see if within radius
            double battleRadiusSquared = Math.pow(e.getBattleRadius(), 2);
            if (Math.pow((character.getX()-e.getX()), 2) +  Math.pow((character.getY()-e.getY()), 2) <= battleRadiusSquared){
                enemyInBattleRange = true;
                break;
            }
        }
        // No battle if no enemies in battle range
        if (!enemyInBattleRange) {
            return defeatedEnemies;
        }
        // Add all support enemies if an enemy in battle range
        battleEnemies.addAll(getSupportEnemies());
        // Add all towers
        battleTowers.addAll(getSupportBuildings("Tower"));
        // Add all campfires
        battleCampfires.addAll(getSupportBuildings("Campfire"));
        // Battle
        Battle battle = new Battle(character, battleTowers, alliedSoldiers, battleEnemies, battleCampfires);
        // Add items
        setBattleWeapons(battle);

        battle.fight();

        // Kill dead enemies
        for (BasicEnemy enemy : battle.getKilledEnemies()) {
            defeatedEnemies.add(enemy);
            killEnemy(enemy);
        }
        // Kill dead allies
        for (AlliedSoldier ally : battle.getKilledAllies()) {
            alliedSoldiers.remove(ally);
        }
        if (battle.isLost()) {
            // Check has The One Ring
            if (equippedRareItem != null && 
                equippedRareItem.getClass().equals(TheOneRing.class)
            ) {
                Item theOneRing = getEquippedRareItem();
                theOneRing.usePotion(character);
                equippedRareItem = null;
            } else {
                // Game Lost
                isLost = true;
            }
        } else {
            gainBattleRewards(battle);
        }
        return defeatedEnemies;
    }

    /**
     * Given a battle supplys equipped items
     * @param battle
     */
    private void setBattleWeapons(Battle battle) {
        if (equippedAttackItem != null) {
            battle.setWeapon(equippedAttackItem);
        }
        if (equippedArmour != null) {
            battle.setArmour(equippedArmour);
        }
        if (equippedShield != null) {
            battle.setShield(equippedShield);
        }
        if (equippedHelmet != null) {
            battle.setHelmet(equippedHelmet);
        }
    }


    /**
     * Adds rewards from battle to character
     * @param battle
     */
    private void gainBattleRewards(Battle battle) {
        setGold(getGold() + battle.getBattleGold());
        setExperience(getExperience() + battle.getBattleExp());
        for (String card : battle.getBattleCards()) {
            loadCard(card);
        }
        for (String item : battle.getBattleItems()) {
            addUnequippedItem(item);
        }
    }

    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                          Methods Related to Items                                          │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    /**
     * pickup spawn items on the path tile when the character passes by
     */
    public void pickupItems() {
        List<Item> collectedItems = new ArrayList<Item>();
        // pick up gold if any
        for (Item item : spawnedItems) {
            if (isOnSameTile(character, item)) {
                if (item instanceof Gold) {
                    gold += ((Gold) item).getGoldFromGround();
                }
            } else if (isOnSameTile(character, item)) {
                    if (item.getType() == "HealthPotion") {
                        addUnequippedItem("Health Potion");
                    }
            }
        }
        // Second loop to despawn items to avoid comodification exception
        for (Item item : collectedItems) {
            if (isOnSameTile(character, item)) {
                despawnItems(item);
            }
        }
    }

    public void despawnItems(Item items){
        items.destroy();
        spawnedItems.remove(items);
    }

    /**
     * Given an item being discarded adds rewards
     * @param item - item to be discarded
     */
    private void addDiscardItemRewards(Item item) {
        setExperience(getExperience() + item.getDiscardExp());
        setGold(getGold() + item.getDiscardGold());
    }

    /**
     * purchase an item from the Hero Castle Menu
     * @param item
     */
    public void purchaseItem(BasicItem item) {
        if (getFirstAvailableSlotForItem() != null) {
            if (herosCastleBuilding.isValidPurchase(gameMode, item, cycles)) {
                int price = herosCastleBuilding.buyItem(item, unequippedInventoryItems);
                gold -= price;
            }
        }
    }

    /**
     * sell an item from the Hero Castle Menu
     * @param item the item to be selled
     */
    public void sellItem(BasicItem item) {
        int sellPrice = herosCastleBuilding.sellItem(item, unequippedInventoryItems);
        gold += sellPrice;
    }


    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                  Methods Related to Equipped Inventory                                     │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    /**
     * Given an unequippedItem equips it in equippedInventory into appropriate slot
     * @param item - item to equip
     * @return success status
     */
    public Boolean equipItem(Item item) {
        if (item.getType().equals("RareItem")) {
            if (equippedRareItem == null) {
                equippedRareItem = item;
                item.setX(new SimpleIntegerProperty(0));
                item.setY(new SimpleIntegerProperty(2));
            } else {
                return false;
            }
        } else if (item.getType().equals("Weapon")) {
            if (equippedAttackItem == null) {
                equippedAttackItem = item;
                item.setX(new SimpleIntegerProperty(1));
                item.setY(new SimpleIntegerProperty(0));
            } else {
                return false;
            }
        } else if (item.getType().equals("Helmet")) {
            if (equippedHelmet == null) {
                equippedHelmet = item;
                item.setX(new SimpleIntegerProperty(0));
                item.setY(new SimpleIntegerProperty(1));
            } else {
                return false;
            }
        } else if (item.getType().equals("Shield")) {
            if (equippedShield == null) {
                equippedShield = item;
                item.setX(new SimpleIntegerProperty(1));
                item.setY(new SimpleIntegerProperty(2));
            } else {
                return false;
            }
        } else if (item.getType().equals("Armour")) {
            if (equippedArmour == null) {
                equippedArmour = item;
                item.setX(new SimpleIntegerProperty(1));
                item.setY(new SimpleIntegerProperty(1));
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
     * Adds a new item of given type to unequipped inventory
     * @param type - item type to create
     */
    public Item addUnequippedItem(String type) {
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null) {
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
        }
        Item item = createItem(type, firstAvailableSlot);
        unequippedInventoryItems.add(item);
        return item;
    }

    /**
     * Adds given existing item into unequipped inventory
     * @param item - item to unequip
     */
    public void unequipEquippedItem(Item item) {
        if (!unequippedInventoryItems.contains(item)) {
            Pair<Integer, Integer> itemSlot = getItemSlot();
            item.setX(new SimpleIntegerProperty(itemSlot.getValue0()));
            item.setY(new SimpleIntegerProperty(itemSlot.getValue1()));
            unequippedInventoryItems.add(item);
        }
    }

    /**
     * Gets first available item slot. If none available, removes oldest item.
     * @return available item slot
     */
    private Pair<Integer, Integer> getItemSlot() {
        Pair<Integer, Integer> firstAvailableSlot = getFirstAvailableSlotForItem();
        if (firstAvailableSlot == null){
            // Eject the oldest unequipped item and replace it
            // Oldest item is that at beginning of items
            removeItemByPositionInUnequippedInventoryItems(0);
            firstAvailableSlot = getFirstAvailableSlotForItem();
            setExperience(getExperience() + 100);
        }
        return firstAvailableSlot;
    }


    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                              Methods Related to Unequipped Inventory Items                                 │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    /**
     * remove an item by x,y coordinates
     * @param x x coordinate from 0 to worldWidth-1
     * @param y y coordinate from 0 to worldHeight-1
     */
    public void removeUnequippedInventoryItemByCoordinates(int x, int y) {
        Item item = getUnequippedInventoryItemEntityByCoordinates(x, y);
        if (item != null) {
            removeUnequippedInventoryItem(item);
        }
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
     * @param x x index from 0 to worldWidth-1
     * @param y y index from 0 to worldHeight-1
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
     * Calls add discardItemRewards method
     * @param index index from 0 to length-1
     */
    private void removeItemByPositionInUnequippedInventoryItems(int index){
        Item item = unequippedInventoryItems.get(index);
        addDiscardItemRewards(item);
        item.destroy();
        unequippedInventoryItems.remove(index);
    }


    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                        Methods Related to Buildings                                        │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    public void trap() {
        // TODO = need to implement this correctly and add javadoc
    }

    /**
     * remove a card by its x, y coordinates
     * @param cardNodeX x index from 0 to worldWidth-1 of card to be removed
     * @param cardNodeY y index from 0 to worldHeight-1 of card to be removed
     * @param buildingNodeX x index from 0 to worldWidth-1 of building to be added
     * @param buildingNodeY y index from 0 to worldHeight-1 of building to be added
     */
    public Building convertCardToBuilding(int cardNodeX, int cardNodeY, int buildingNodeX, int buildingNodeY) {
        // start by getting card
        Card card = null;
        String cardType = null;
        for (Card c: cardEntities){
            if ((c.getX() == cardNodeX) && (c.getY() == cardNodeY)) {
                card = c;
                cardType = card.getClass().toString().split("@")[0];
                cardType = cardType.substring(cardType.lastIndexOf(".") + 1);
                break;
            }
        }
        // now spawn building if the give location is valid
        if (card.getPositionStrategy().validPosition(buildingNodeX, buildingNodeY, orderedPath)) {
            String buildingType = cardType.substring(0, cardType.lastIndexOf("Card")) + "Building";
            Building newBuilding = createBuilding(buildingType, buildingNodeX, buildingNodeY);
            buildingEntities.add(newBuilding);
            System.out.println("New " + buildingType + " placed on map");
            // destroy the card
            card.destroy();
            cardEntities.remove(card);
            shiftCardsDownFromXCoordinate(cardNodeX);
            return newBuilding;
        }
        return null;
    }

    public void trapEnemy() {
        for (TrapBuilding trapBuilding : trapBuildings) {
            for(BasicEnemy enemy: getEnemies()) {
                if (isOnSameTile(enemy, trapBuilding)) {
                    trapBuilding.damageEnemy(enemy);
                    if(!enemy.isAlive()) {
                        killEnemy(enemy);
                        trapBuildings.remove(trapBuilding);
                        break;
                    }
                }
            }
            break;
        }
    }

    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                            Mehods Related to Cards                                         │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */

    /**
     * spawn a card in the world and return the card entity
     * @return a card to be spawned in the controller as a JavaFX node
     */
    public Card loadCard(String type){
        // if adding more cards than have, remove the first card...
        if (cardEntities.size() >= getWidth()) {
            gainDiscardCardRewards(cardEntities.get(0));
            removeCard(0); 
        }
        Card card = createCard(type, new SimpleIntegerProperty(cardEntities.size()));
        cardEntities.add(card);
        return card;
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

    /**
     * shift card coordinates down starting from x coordinate
     * @param x x coordinate which can range from 0 to worldWidth-1
     */
    private void shiftCardsDownFromXCoordinate(int x){
        for (Card c: cardEntities){
            if (c.getX() >= x){
                c.x().set(c.getX()-1);
            }
        }
    }

    /**
     * Gives the player rewards when a card is discarded due to having too many
     * @param goldReward gold reward
     * @param expReward experience reward
     * @param itemReward item reward/s
     */
    public void gainDiscardCardRewards(Card card) {
        addGold(card.getGoldReward());
        addExperience(card.getExpReward());
        card.setItemReward();
        for (String type : card.getItemRewardList())
            addUnequippedItem(type);
    }

    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                                Helper Methods                                              │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */


    /**
     * get a randomly generated position which could be used to spawn an entity
     * @return null if random choice is that wont be spawning an entity or it isn't possible, or random coordinate pair
     * if should go ahead
     */
    private Pair<Integer, Integer> possiblyGetSpawnPosition(int chance){

        // has a chance spawning a basic enemy on a tile the character isn't on or immediately before or after (currently space required = 2)...
        Random rand = new Random();
        int choice = rand.nextInt(chance);

        // TODO = change based on spec
        if ((choice == 0)){
            List<Pair<Integer, Integer>> orderedPathSpawnCandidates = new ArrayList<Pair<Integer, Integer>>();
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
     * check if two entities are on the same path tile
     * @param entityA the entity that is comparing to the second one
     * @param entityB the entity that is comparing to the first one
     * @return true if two entities are on the same path tile else false
     */
    public boolean isOnSameTile(Entity entityA, Entity entityB) {
        int entityAX = entityA.getX();
        int entityAY = entityA.getY();

        int entityBX = entityB.getX();
        int entityBY = entityB.getY();

        return entityAX == entityBX && entityAY == entityBY;
    }

    /**
     * Spawns given card in the world
     * @param type - string with capital first letter and suffix Card (eg. BarracksCard, CampfireCard etc.)
     * @param firstAvailableSlot - first empty card slot
     * @return card (returns null if invalid type provided)
     */
    public Card createCard(String type, SimpleIntegerProperty firstAvailableSlot) {
        Class<?> cardClass;
        Class<?>[] parameterType;
        Card card;       
        try {
            cardClass = Class.forName("unsw.loopmania.model.Cards." + type);
            parameterType = new Class[] { SimpleIntegerProperty.class, SimpleIntegerProperty.class };
            card = (Card) cardClass.getDeclaredConstructor(parameterType).newInstance(firstAvailableSlot, new SimpleIntegerProperty(0));
            return card;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            // DONE Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Spawns given item in the world
     * @param type - string with capital first letter (eg. Armour, Stake, HealthPotion, etc.)
     * @param firstAvailableSlot - unequipped inventory slot
     * @return item (returns null if invalid type provided)
     */
    public Building createBuilding(String type, int buildingNodeX, int buildingNodeY) {
        Class<?> buildingClass;
        Class<?>[] parameterType;
        Building building;       
        try {
            buildingClass = Class.forName("unsw.loopmania.model.Buildings." + type);
            parameterType = new Class[] { SimpleIntegerProperty.class, SimpleIntegerProperty.class };
            building = (Building) buildingClass.getDeclaredConstructor(parameterType).newInstance(new SimpleIntegerProperty(buildingNodeX), new SimpleIntegerProperty(buildingNodeY));
            return building;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            // DONE Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        
    }

    /**
     * Spawns given item in the world
     * @param type - string with capital first letter (eg. Armour, Stake, HealthPotion, etc.)
     * @param firstAvailableSlot - unequipped inventory slot
     * @return item (returns null if invalid type provided)
     */
    public Item createItem(String type, Pair<Integer, Integer> firstAvailableSlot) {
        Class<?> itemClass;
        Class<?>[] parameterType;
        Item item;       
        try {
            if (type == "TheOneRing") 
                itemClass = Class.forName("unsw.loopmania.model.Items.RareItems." + type);
            else itemClass = Class.forName("unsw.loopmania.model.Items.BasicItems." + type);
            parameterType = new Class[] { SimpleIntegerProperty.class, SimpleIntegerProperty.class };
            item = (Item) itemClass.getDeclaredConstructor(parameterType).newInstance(new SimpleIntegerProperty(firstAvailableSlot.getValue0()), new SimpleIntegerProperty(firstAvailableSlot.getValue1()));
            return item;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            // DONE Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /**
     * get the first pair of x,y coordinates which don't have any items in it in the unequipped inventory
     * @return x,y coordinate pair
     */
    public Pair<Integer, Integer> getFirstAvailableSlotForItem(){
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


    private PathPosition spawnPositionFromBuilding(Building building) {

        int x = building.getX();
        int y = building.getY();

        Pair<Integer, Integer> upPostion  = new Pair<Integer, Integer>(x - 1, y);
        Pair<Integer, Integer> downPostion  = new Pair<Integer, Integer>(x + 1, y);
        Pair<Integer, Integer> leftPostion  = new Pair<Integer, Integer>(x, y - 1);
        Pair<Integer, Integer> rightPostion  = new Pair<Integer, Integer>(x, y + 1);

        if (orderedPath.contains(upPostion)) {
            return new PathPosition(orderedPath.indexOf(upPostion), orderedPath);
        } else if (orderedPath.contains(downPostion)) {
            return new PathPosition(orderedPath.indexOf(downPostion), orderedPath);
        } else if (orderedPath.contains(leftPostion)) {
            return new PathPosition(orderedPath.indexOf(leftPostion), orderedPath);
        } else if (orderedPath.contains(rightPostion)) {
            return new PathPosition(orderedPath.indexOf(rightPostion), orderedPath);
        } else {
            return null;
        }
    }

    /* ┌────────────────────────────────────────────────────────────────────────────────────────────────────────────┐ */
    /* │                                                   Unsure                                                   │ */
    /* └────────────────────────────────────────────────────────────────────────────────────────────────────────────┘ */


    /**
     * add a generic entity (without it's own dedicated method for adding to the world)
     * @param entity
     */
    public void addEntity(Entity entity) {
        // for adding non-specific entities (ones without another dedicated list)
        // TODO = if more specialised types being added from main menu, add more methods like this with specific input types...
        nonSpecifiedEntities.add(entity);
    }

    public void addEnemy(BasicEnemy enemy) {
        enemies.add(enemy);
    }

    public void addBuilding(Building building) {
        buildingEntities.add(building);
    }
}

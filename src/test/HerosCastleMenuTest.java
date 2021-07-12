package test.ItemsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;

public class HerosCastleMenuTest {


    @Test
    public void BuySellSwordTest() {

        HerosCastleBuilding herosCastleBuilding = new HerosCastleBuilding(new SimpleIntegerProperty(),
                                                                            new SimpleIntegerProperty());

        Sword sword = new Sword(new SimpleIntegerProperty(),
                                    new SimpleIntegerProperty());

        // Buy item
        herosCastleBuilding.buyItem(sword);
        assert(herosCastleBuilding.getBoughtItems() != null);

        // Sell item
        herosCastleBuilding.sellItem(sword);
        assert(herosCastleBuilding.getBoughtItems().isEmpty());
    }

    @Test
    public void BuySellStakeTest() {

        HerosCastleBuilding herosCastleBuilding = new HerosCastleBuilding(new SimpleIntegerProperty(),
                                                                          new SimpleIntegerProperty());

        Stake stake = new Stake(new SimpleIntegerProperty(),
                                   new SimpleIntegerProperty());

        // Buy item
        herosCastleBuilding.buyItem(stake);
        assert(herosCastleBuilding.getBoughtItems() != null);

        // Sell item
        herosCastleBuilding.sellItem(stake);
        assert(herosCastleBuilding.getBoughtItems().isEmpty());
    }

    @Test
    public void BuySellStaffTest() {

        HerosCastleBuilding herosCastleBuilding = new HerosCastleBuilding(new SimpleIntegerProperty(),
                                                                          new SimpleIntegerProperty());

        Staff staff = new Staff(new SimpleIntegerProperty(),
                                   new SimpleIntegerProperty());

        // Buy item
        herosCastleBuilding.buyItem(staff);
        assert(herosCastleBuilding.getBoughtItems() != null);

        // Sell item
        herosCastleBuilding.sellItem(staff);
        assert(herosCastleBuilding.getBoughtItems().isEmpty());
    }

    @Test
    public void BuySellArmourTest() {

        HerosCastleBuilding herosCastleBuilding = new HerosCastleBuilding(new SimpleIntegerProperty(),
                                                                          new SimpleIntegerProperty());

        Armour armour = new Armour(new SimpleIntegerProperty(),
                                   new SimpleIntegerProperty());

        // Buy item
        herosCastleBuilding.buyItem(armour);
        assert(herosCastleBuilding.getBoughtItems() != null);

        // Sell item
        herosCastleBuilding.sellItem(armour);
        assert(herosCastleBuilding.getBoughtItems().isEmpty());
    }

    @Test
    public void BuySellHelmetTest() {

        HerosCastleBuilding herosCastleBuilding = new HerosCastleBuilding(new SimpleIntegerProperty(),
                                                                          new SimpleIntegerProperty());

        Helmet helmet = new Helmet(new SimpleIntegerProperty(),
                                   new SimpleIntegerProperty());

        // Buy item
        herosCastleBuilding.buyItem(helmet);
        assert(herosCastleBuilding.getBoughtItems() != null);

        // Sell item
        herosCastleBuilding.sellItem(helmet);
        assert(herosCastleBuilding.getBoughtItems().isEmpty());
    }

    @Test
    public void BuySellShieldTest() {

        HerosCastleBuilding herosCastleBuilding = new HerosCastleBuilding(new SimpleIntegerProperty(),
                                                                          new SimpleIntegerProperty());

        Shield shield = new Shield(new SimpleIntegerProperty(),
                                   new SimpleIntegerProperty());

        // Buy item
        herosCastleBuilding.buyItem(shield);
        assert(herosCastleBuilding.getBoughtItems() != null);

        // Sell item
        herosCastleBuilding.sellItem(shield);
        assert(herosCastleBuilding.getBoughtItems().isEmpty());
    }

    @Test
    public void BuySellHealthPotionTest() {

        HerosCastleBuilding herosCastleBuilding = new HerosCastleBuilding(new SimpleIntegerProperty(),
                                                                          new SimpleIntegerProperty());

        HealthPotion healthPotion = new HealthPotion(new SimpleIntegerProperty(),
                                   new SimpleIntegerProperty());

        // Buy item
        herosCastleBuilding.buyItem(healthPotion);
        assert(herosCastleBuilding.getBoughtItems() != null);

        // Sell item
        herosCastleBuilding.sellItem(healthPotion);
        assert(herosCastleBuilding.getBoughtItems().isEmpty());
    }

    
}


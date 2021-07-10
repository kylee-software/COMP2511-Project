package test;

import javafx.beans.property.SimpleIntegerProperty;
import org.junit.jupiter.api.*;
import unsw.loopmania.*;

import java.util.ArrayList;

import org.javatuples.Pair;
import java.util.List;


public class GameStateTest {

    @Test
    void GameModeTest() {

        LoopManiaWorld survivalWorld = new LoopManiaWorld("Survival", 10, 10, new ArrayList<Pair<Integer, Integer>>());

        assert(survivalWorld.getGameMode().equals("Survival"));
    }
    

    @Test
    void SurvivalModeTest() {
        // TODO: need to test the rule of this game mode
        HerosCastleBuilding herosCastle = new HerosCastleBuilding(new SimpleIntegerProperty(), new SimpleIntegerProperty(), "Survival");

        HealthPotion healthPotion = new HealthPotion(new SimpleIntegerProperty(), new SimpleIntegerProperty(), 40, 50);
        herosCastle.buyItem(healthPotion);
        List<Item> boughtItems = herosCastle.getBoughtItems();

        assert(herosCastle.getGameMode().equals("Survival"));
        assert(boughtItems.get(0) == healthPotion);

    }

    @Test
    void BerserkerModeTest() {
        // TODO: need to test the rule of this game mode
        HerosCastleBuilding herosCastle = new HerosCastleBuilding(new SimpleIntegerProperty(), new SimpleIntegerProperty(), "Berserker");

        Helmet helmet = new Helmet(new SimpleIntegerProperty(), new SimpleIntegerProperty(), 40, 50);
        herosCastle.buyItem(helmet);
        List<Item> boughtItems = herosCastle.getBoughtItems();

        assert(herosCastle.getGameMode().equals("Berserker"));
        assert(boughtItems.get(0) == helmet);

    }

    @Test
    void WinTest() {
        LoopManiaWorld world = new LoopManiaWorld("Survival", 10, 10, new ArrayList<Pair<Integer, Integer>>());

        // Goal1
        world.setGold(2000);
        
        for (int i = 0; i < 30; i++) {
            world.incrementCycles();
        }


        assert(world.completedGame());

        // Goal2
        world.setExperience(15000);
        assert(world.completedGame());
    }

}

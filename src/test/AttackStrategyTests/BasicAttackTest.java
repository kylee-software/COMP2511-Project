package test.AttackStrategyTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import unsw.loopmania.model.MovingEntity;
import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.AttackStrategy.AttackStrategy;
import unsw.loopmania.model.AttackStrategy.BasicAttack;
import unsw.loopmania.model.Enemies.*;
import unsw.loopmania.model.Character;


public class BasicAttackTest {
    @Test
    public void characterExecuteTest() {
        List<Pair<Integer, Integer>> dummyPath = new ArrayList<>();
        dummyPath.add(new Pair<>(0,0));
        PathPosition dummyPosition = new PathPosition(0, dummyPath);
        Character attacker = new Character(dummyPosition);
        Slug enemy = new Slug(dummyPosition);
        AttackStrategy basicAttack = new BasicAttack();
        basicAttack.execute(attacker, enemy, 0, 0, false);
        assertEquals(enemy.getHealth(), 4);
        enemy.setHealth(10);
        basicAttack.execute(attacker, enemy, 0, 0, true);
        assertEquals(enemy.getHealth(), -2);
    }
}

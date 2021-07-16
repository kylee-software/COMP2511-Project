package unsw.loopmania.model.Enemies;

import de.schlichtherle.truezip.socket.IOCache;
import unsw.loopmania.model.MovingEntity;
import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.AttackStrategy.AttackStrategy;
import unsw.loopmania.model.AttackStrategy.BasicAttack;

import java.util.Random;

/**
 * a basic form of enemy in the world
 */
public abstract class BasicEnemy extends MovingEntity {

    private String type;
    private AttackStrategy strategy = new BasicAttack();

    // TODO = modify this, and add additional forms of enemy
    public BasicEnemy(PathPosition position, int health, String type) {
        super(position, health);
        this.type = type;
    }

    /**
     * move the enemy
     */
    public void move(){
        // TODO = modify this, since this implementation doesn't provide the expected enemy behaviour
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        int directionChoice = (new Random()).nextInt(2);
        if (directionChoice == 0){
            moveUpPath();
        }
        else if (directionChoice == 1){
            moveDownPath();
        }
    }

    public String getType() {
        return type;
    }


    public int getEXPReward;
    public int getGoldReward;
    public int getBattleDamage;
    public int getSupportRadius;
    public int getBattleRadius;
    public int getHealth;
    public  double getSpeed;


}

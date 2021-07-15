package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;

public class BarracksBuilding extends Building implements CreateEntityBehaviour {

    private PathPosition pathPosition;

    public BarracksBuilding (PathPosition pathPosition) {
        super(pathPosition.getX(), pathPosition.getY());
        this.pathPosition = pathPosition;
    }

    public void setPathPosition(PathPosition pathPosition) {
        this.pathPosition = pathPosition;
    }

    public PathPosition getPathPosition() {
        return pathPosition;
    }

    /**
     * Produces allied soldier to join Character when passes through
     * @param cycle the cycle the LoopManiaWorld is in
     * @return a list of newly produced allied soldiers
     */
    public List<Entity> produceEntity(int cycle) {
        // TODO = need to implement this correctly and add javadoc
        return new ArrayList<>();
    }
}

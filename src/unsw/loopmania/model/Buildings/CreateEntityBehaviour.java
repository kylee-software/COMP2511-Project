package unsw.loopmania.model.Buildings;

import java.util.List;

import unsw.loopmania.model.Entity;

public interface CreateEntityBehaviour {

    List<Entity> produceEntity(int cycle);

}

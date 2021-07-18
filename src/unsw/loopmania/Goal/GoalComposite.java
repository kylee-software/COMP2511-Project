package unsw.loopmania.Goal;

import java.util.ArrayList;
import java.util.List;

public class GoalComposite implements GoalComponent {

    List<GoalComponent> goalComponents = new ArrayList<>();
    String type;
  
	public GoalComposite(String type) {
		this.type = type;
	}
    
    @Override
    public boolean isGoalComplete() {
        if(type.equals("and")) {
            for(GoalComponent goalComponent : goalComponents) {
                if(!goalComponent.isGoalComplete()) return false;
            }
            return true;
        } else if(type.equals("or")) {
            for(GoalComponent goalComponent : goalComponents) {
                if(goalComponent.isGoalComplete()) return true;
            }
            return false;
        }
        else return false;
    }

    public void add(GoalComponent goalComponent) {
		goalComponents.add(goalComponent);
	}
 
	// public void remove(GoalComponent goalComponent) {
	// 	goalComponents.remove(goalComponent);
	// }
 
	public GoalComponent getChild(int i) {
		return (GoalComponent) goalComponents.get(i);
	}

}
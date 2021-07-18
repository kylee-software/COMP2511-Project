package unsw.loopmania.Goal;

public class GoalNode implements GoalComponent {

    private String type;
	private boolean checkGoalComplete;
    
	public GoalNode(String type, boolean checkGoalComplete) { 
        this.type = type;
		this.checkGoalComplete = checkGoalComplete;
    }
    
    @Override
    public boolean isGoalComplete() {
        return checkGoalComplete;
    }

    public String getType() {
        return type;
    }


}
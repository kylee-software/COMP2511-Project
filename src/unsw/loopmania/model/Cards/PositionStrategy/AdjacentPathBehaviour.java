package unsw.loopmania.model.Cards.PositionStrategy;

import java.util.List;

import org.javatuples.Pair;

public class AdjacentPathBehaviour implements PositionStrategy {

    @Override
    public boolean validPosition(int buildingNodeX, int buildingNodeY, List<Pair<Integer, Integer>> orderedPath) {
        
        Integer x = Integer.valueOf(buildingNodeX);
        Integer y = Integer.valueOf(buildingNodeY);
        Pair<Integer, Integer> tile = new Pair<>(x, y);

        for (Pair<Integer, Integer> coordinate : orderedPath) {
            if (!tile.equals(coordinate)) {
                for ( Integer i = coordinate.getValue0() - 1; i <= coordinate.getValue0() + 1; i++) {
                    for ( Integer j = coordinate.getValue1() - 1; j <= coordinate.getValue1() + 1; j++) {
                        if (tile.getValue0().equals(i) && tile.getValue1().equals(j)) return true;
                    }
                }
            }
        }
        
        return false;
    }

}
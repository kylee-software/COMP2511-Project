package test;

import javafx.beans.property.SimpleIntegerProperty;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;
import unsw.loopmania.*;

import java.io.FileReader;
import java.util.List;
import org.json.*;

public class EnemiesTests {

    private JSONObject json = new JSONObject(new JSONTokener(new FileReader("worlds/" + filename)));

    int width = json.getInt("width");
    int height = json.getInt("height");

    // path variable is collection of coordinates with directions of path taken...
    List<Pair<Integer, Integer>> orderedPath = LoopManiaWorldLoader.loadPathTiles(json.getJSONObject("path"), width,
                                                                                  height);

    @Test
    void SlugTest() {

        PathPosition pathPosition = new PathPosition(5, orderedPath);
        SimpleIntegerProperty xBefore = pathPosition.getX();
        SimpleIntegerProperty yBefore = pathPosition.getY();
        Pair<SimpleIntegerProperty, SimpleIntegerProperty> positionBefore = new Pair<SimpleIntegerProperty,
                SimpleIntegerProperty>(xBefore, yBefore);

        Slug slug = new Slug(pathPosition, 100, "Slug");
        slug.move();

        SimpleIntegerProperty xAfter = pathPosition.getX();
        SimpleIntegerProperty yAfter = pathPosition.getY();
        Pair<SimpleIntegerProperty, SimpleIntegerProperty> positionAfter = new Pair<SimpleIntegerProperty,
                SimpleIntegerProperty>(xAfter, yAfter);

        assert(!positionBefore.equals(positionAfter));

    }

    @Test
    void ZombieTest() {

        PathPosition pathPosition = new PathPosition(5, orderedPath);
        SimpleIntegerProperty xBefore = pathPosition.getX();
        SimpleIntegerProperty yBefore = pathPosition.getY();
        Pair<SimpleIntegerProperty, SimpleIntegerProperty> positionBefore = new Pair<SimpleIntegerProperty,
                SimpleIntegerProperty>(xBefore, yBefore);

        Zombie zombie = new Zombie(pathPosition, 100, "Zombie");
        zombie.move();

        SimpleIntegerProperty xAfter = pathPosition.getX();
        SimpleIntegerProperty yAfter = pathPosition.getY();
        Pair<SimpleIntegerProperty, SimpleIntegerProperty> positionAfter = new Pair<SimpleIntegerProperty,
                SimpleIntegerProperty>(xAfter, yAfter);

        assert(!positionBefore.equals(positionAfter));

    }

    @Test
    void VampireTest() {

        PathPosition pathPosition = new PathPosition(5, orderedPath);
        SimpleIntegerProperty xBefore = pathPosition.getX();
        SimpleIntegerProperty yBefore = pathPosition.getY();
        Pair<SimpleIntegerProperty, SimpleIntegerProperty> positionBefore = new Pair<SimpleIntegerProperty,
                SimpleIntegerProperty>(xBefore, yBefore);

        Vampire vampire = new Vampire(pathPosition, 100, "Vampire");
        vampire.move();

        SimpleIntegerProperty xAfter = pathPosition.getX();
        SimpleIntegerProperty yAfter = pathPosition.getY();
        Pair<SimpleIntegerProperty, SimpleIntegerProperty> positionAfter = new Pair<SimpleIntegerProperty,
                SimpleIntegerProperty>(xAfter, yAfter);

        assert(!positionBefore.equals(positionAfter));

    }
}

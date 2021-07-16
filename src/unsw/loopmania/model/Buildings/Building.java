package unsw.loopmania.model.Buildings;

import android.os.Build;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.StaticEntity;

public abstract class Building extends StaticEntity {

    public Building(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    // Overridden getter for battle radius
    public int getBattleRadius() {
        return 0;
    };
}

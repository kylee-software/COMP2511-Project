package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;
import android.os.Build;

public abstract class Building extends StaticEntity {

    public Building(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }
}

package unsw.loopmania;

import android.os.Build;

import javafx.beans.property.SimpleIntegerProperty;

public abstract class Building extends StaticEntity {

    public Building(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }
}

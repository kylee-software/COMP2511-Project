package unsw.loopmania.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;

/**
 * controller for the main menu.
 */
public class MainMenuController {
    /**
     * facilitates switching to main game
     */
    private MenuSwitcher gameSwitcher;

    @FXML
    private MenuButton gameModeButton;

//    @FXML
//    private MenuItem standardMode;
//
//    @FXML
//    private MenuItem survivalMode;
//
//    @FXML
//    private MenuItem berserkerMode;

    @FXML
    private FileSelector worldSelector;

    public MainMenuController() {
    }

    public void setGameSwitcher(MenuSwitcher gameSwitcher){
        this.gameSwitcher = gameSwitcher;
    }

    /**
     * facilitates switching to main game upon button click
     * @throws IOException
     */
    @FXML
    private void switchToGame() throws IOException {
        gameSwitcher.switchMenu();
    }

    @FXML
    public void initialize() {
        worldSelector.setDirectory(new File("worlds"));
        selectWorld();
        selectGameMode();
    }

    public String getGameMode() {
        return gameModeButton.getText();
    }

    public String getWorld() {
        return worldSelector.getText();
    }

    public void selectWorld() {
        for (final MenuItem world: worldSelector.getItems()) {
            world.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
                @Override
                public void handle(javafx.event.ActionEvent actionEvent) {
                    worldSelector.setText(world.getText());
                }
            });
        }
    }

    public void selectGameMode() {
        for (final MenuItem gameMode: gameModeButton.getItems()) {
            gameMode.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
                @Override
                public void handle(javafx.event.ActionEvent actionEvent) {
                    gameModeButton.setText(gameMode.getText());
                }
            });
        }
    }
}

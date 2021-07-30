package unsw.loopmania.controller;

import javafx.scene.control.MenuItem;
import java.beans.EventHandler;
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

    @FXML
    private MenuItem standardMode;

    @FXML
    private MenuItem survivalMode;

    @FXML
    private MenuItem berserkerMode;

    @FXML
    private MenuItem confusingMode;

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
    private void setStandardMode() throws IOException {
        gameModeButton.setText("Standard");
    }

    @FXML
    private void setSurvivalMode() throws IOException {
        gameModeButton.setText("Survival");
    }

    @FXML
    private void setBerserkerMode() throws IOException {
        gameModeButton.setText("Berserker");
    }
    
    @FXML
    private void setConfusingMode() throws IOException {
        gameModeButton.setText("Confusing");
    }

    public String getGameMode() {
        return gameModeButton.getText();
    }
}

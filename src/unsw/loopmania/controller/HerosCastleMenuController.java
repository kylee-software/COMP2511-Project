package unsw.loopmania.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HerosCastleMenuController  {

    @FXML
    private Button buyHelmetButton;

    @FXML
    private Button buyArmourButton;

    @FXML
    private Button buyShieldButton;

    @FXML
    private Button buySwordButton;

    @FXML
    private Button buyStakeButton;

    @FXML
    private Button buyStaffButton;

    @FXML
    private Button buyHealthPotionButton;

    @FXML
    private Button closeButton;

    private MenuSwitcher gameSwitcher;

    public void setGameSwitcher(MenuSwitcher gameSwitcher){
        this.gameSwitcher = gameSwitcher;
    }

    @FXML
    void buyArmour(ActionEvent event) {

    }

    @FXML
    void buyHealthPotion(ActionEvent event) {

    }

    @FXML
    void buyHelmet(ActionEvent event) {

    }

    @FXML
    void buyShield(ActionEvent event) {

    }

    @FXML
    void buyStaff(ActionEvent event) {

    }

    @FXML
    void buyStake(ActionEvent event) {

    }

    @FXML
    void buySword(ActionEvent event) {

    }

    @FXML
    void switchToGame(ActionEvent event) {
        gameSwitcher.switchMenu();
    }

}

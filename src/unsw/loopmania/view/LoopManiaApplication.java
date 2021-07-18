package unsw.loopmania.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import unsw.loopmania.controller.*;

/**
 * the main application
 * run main method from this class
 */
public class LoopManiaApplication extends Application {
    // TODO = possibly add other menus?

    /**
     * the controller for the game. Stored as a field so can terminate it when click exit button
     */
    private LoopManiaWorldController mainController;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // set title on top of window bar
        primaryStage.setTitle("Loop Mania");

        // prevent human player resizing game window (since otherwise would see white space)
        // alternatively, you could allow rescaling of the game (you'd have to program resizing of the JavaFX nodes)
        primaryStage.setResizable(false);

        // load the main game
        LoopManiaWorldControllerLoader loopManiaLoader = new LoopManiaWorldControllerLoader("world_with_twists_and_turns.json");
        mainController = loopManiaLoader.loadController();
        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("LoopManiaView.fxml"));
        gameLoader.setController(mainController);
        Parent gameRoot = gameLoader.load();

        // load the main menu
        MainMenuController mainMenuController = new MainMenuController();
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("MainMenuView.fxml"));
        menuLoader.setController(mainMenuController);
        Parent mainMenuRoot = menuLoader.load();

        // GameOverScreenController gameOverScreenController = new GameOverScreenController();
        // FXMLLoader gameOverScreenLoader = new FXMLLoader(getClass().getResource("GameOverScreenView.fxml"));
        // gameOverScreenLoader.setController(gameOverScreenController);
        // Parent gameOverScreenRoot = gameOverScreenLoader.load();

        // WinScreenController winScreenController = new WinScreenController();
        // FXMLLoader winScreenLoader = new FXMLLoader(getClass().getResource("WinScreenView.fxml"));
        // winScreenLoader.setController(winScreenController);
        // Parent winScreenRoot = winScreenLoader.load();

        // create new scene with the main menu (so we start with the main menu)
        Scene scene = new Scene(mainMenuRoot);
        // Scene gameOverScreenScene = new Scene(gameOverScreenRoot);
        // Scene winScreenScene = new Scene(winScreenRoot);
        
        
        // set functions which are activated when button click to switch menu is pressed
        // e.g. from main menu to start the game, or from the game to return to main menu
        mainController.setMainMenuSwitcher(() -> {switchToRoot(scene, mainMenuRoot, primaryStage);});
        mainMenuController.setGameSwitcher(() -> {switchToRoot(scene, gameRoot, primaryStage);
            mainController.startTimer();
        });
        // switch from game to game over screen
        //  mainController.setGameOverScreenSwitcher(() -> {switchToRoot(gameOverScreenScene, gameOverScreenRoot, primaryStage);
        //     mainController.terminate();
        // });
        // // switch from game to game win screen
        // mainController.setWinScreenSwitcher(() -> {switchToRoot(winScreenScene, winScreenRoot, primaryStage);
        //     mainController.terminate();
        // });
        
        // deploy the main onto the stage
        gameRoot.requestFocus();
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop(){
        // wrap up activities when exit program
        mainController.terminate();
    }

    /**
     * switch to a different Root
     */
    private void switchToRoot(Scene scene, Parent root, Stage stage){
        scene.setRoot(root);
        root.requestFocus();
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

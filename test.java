package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class test extends Application {
    private static char currentLetter = 'a'; // Shared variable to store the current letter
    private Text letterTextScene1;
    private Text letterTextScene2;
    private Scene scene1, scene2;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Create the first scene
        scene1 = createScene("Scene 1");
        // Create the second scene
        scene2 = createScene("Scene 2");

        // Show the first scene on application startup
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Letter Toggle App");

        primaryStage.show();
    }

    private Scene createScene(String sceneName) {
        Text letterText = new Text(Character.toString(currentLetter));
        letterText.setFont(Font.font(48));

        if (sceneName.equals("Scene 1")) {
            letterTextScene1 = letterText;
        } else {
            letterTextScene2 = letterText;
        }

        Button toggleButton = new Button("Toggle Letter");
        toggleButton.setOnAction(e -> {
            // Toggle the letter between 'a' and 'b'
            currentLetter = (currentLetter == 'a') ? 'b' : 'a';
            // Update the letter text in all scenes
            updateLetterText();
        });

        Button switchButton = new Button("Switch Scene");
        switchButton.setOnAction(e -> switchScene());

        StackPane root = new StackPane();
        root.getChildren().addAll(letterText, toggleButton, switchButton);

        return new Scene(root, 300, 200);
    }

    private void switchScene() {
        if (primaryStage.getScene() == scene1) {
            primaryStage.setScene(scene2);
        } else {
            primaryStage.setScene(scene1);
        }
    }

    private void updateLetterText() {
        letterTextScene1.setText(Character.toString(currentLetter));
        letterTextScene2.setText(Character.toString(currentLetter));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

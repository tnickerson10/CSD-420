/*
Travis Nickerson
CSD 405
July 30th, 2021
Goal: Write a program that displays various figures such as a Circle, a Rectangle, or an Ellipse.
Include radio buttons selections for changing the display figure to the one selected.
Include a checkbox for filling and clearing the displayed figure with a random color.
 */

package sample;

// import statements
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

        // creating a protected method for returning out pane
        protected BorderPane getPane() {

            // creating our initial outlined circle
            Circle circle = new Circle(175,100,50);
            circle.setFill(Color.TRANSPARENT);
            circle.setStroke(Color.BLACK);

            // creating our initial outline rectangle
            Rectangle rect = new Rectangle(105,55,150, 75);
            rect.setFill(Color.TRANSPARENT);
            rect.setStroke(Color.BLACK);

            // creating our initial outline ellipse
            Ellipse elip = new Ellipse(175,100,50,75);
            elip.setFill(Color.TRANSPARENT);
            elip.setStroke(Color.BLACK);

            // creating our hbox to hol our radio buttons
            HBox radioPane = new HBox(50);

            // creating three radio buttons for our shapes
            RadioButton circleBtn = new RadioButton("Circle");
            RadioButton rectangleBtn = new RadioButton("Rectangle");
            RadioButton ellipseBtn = new RadioButton("Ellipse");

            // adding the radio buttons to our hbox
            radioPane.getChildren().addAll(circleBtn, rectangleBtn, ellipseBtn);

            // centering our radio buttons within the hbox
            radioPane.setAlignment(Pos.CENTER);

            // adding padding for proper spacing of buttons and a red border
            radioPane.setPadding(new Insets(10,10,10,10));
            radioPane.setStyle("-fx-border-color: red");

            // creating a toggle group and adding the radio buttons so only one can be selected
            ToggleGroup group = new ToggleGroup();
            circleBtn.setToggleGroup(group);
            rectangleBtn.setToggleGroup(group);
            ellipseBtn.setToggleGroup(group);

            // making our border pane and adding in our hbox of radio buttons
            BorderPane pane = new BorderPane();
            pane.setBottom(radioPane);

            // creating another hbox to hold our two checkboxes of fill and clear
            HBox checkPane = new HBox(50);
            CheckBox fill = new CheckBox("Fill");
            CheckBox clear = new CheckBox("Clear");

            // centering the checkboxes in our hbox and adding padding and a border
            checkPane.setAlignment(Pos.CENTER);
            checkPane.setPadding(new Insets(10,10,10,10));
            checkPane.setStyle("-fx-border-color: red");

            // adding the checkbox buttons to our second hbox
            checkPane.getChildren().addAll(fill, clear);
            pane.setTop(checkPane);

            // initializing a new pane for later use
            Pane paneForDisplay = new Pane();

            // on click events for circle radio button with lambda expressions
            circleBtn.setOnAction(e -> {
                if (circleBtn.isSelected()) {

                    // clears our pane and then creates a new instance and passes our circle in
                    paneForDisplay.getChildren().clear();
                    paneForDisplay.getChildren().add(circle);
                    pane.setCenter(paneForDisplay);
                }
            });

            // on click events for rectangle radio button with lambda expressions
            rectangleBtn.setOnAction(e -> {
                if (rectangleBtn.isSelected()) {

                    // clears our pane and then creates a new instance and passes our rectangle in
                    paneForDisplay.getChildren().clear();
                    paneForDisplay.getChildren().add(rect);
                    pane.setCenter(paneForDisplay);

                }
            });

            // on click events for ellipse radio button with lambda expressions
            ellipseBtn.setOnAction(e -> {
                if (ellipseBtn.isSelected()) {

                    // clears our pane and then creates a new instance and passes our ellpse in
                    paneForDisplay.getChildren().clear();
                    paneForDisplay.getChildren().add(elip);
                    pane.setCenter(paneForDisplay);

                }
            });

            // on click events for filling our shapes with lambda expressions
            fill.setOnAction(e -> {

                // if statement allows us to fill our shapes only if we are selecting fill and not unselecting
                if (circleBtn.isSelected() && fill.isSelected()) {
                    circle.setFill(Color.color(Math.random(),Math.random(),Math.random()));
                }
                else if (rectangleBtn.isSelected() && fill.isSelected()) {
                    rect.setFill(Color.color(Math.random(),Math.random(),Math.random()));
                }
                else if (ellipseBtn.isSelected() && fill.isSelected()) {
                    elip.setFill(Color.color(Math.random(),Math.random(),Math.random()));
                }
            });

            // on click event for clearing our panes. Also unchecks our buttons with lambda expression
            clear.setOnAction(e -> {
                paneForDisplay.getChildren().clear();
                fill.setSelected(false);
                clear.setSelected(false);
                circleBtn.setSelected(false);
                rectangleBtn.setSelected(false);
                ellipseBtn.setSelected(false);

            });

           // returning our pane to our getPane method
            return pane;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        // setting our scene title and passing in our getPane method for display
        primaryStage.setTitle("Shapes Display");
        primaryStage.setScene(new Scene(getPane(), 350, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

/*
Travis Nickerson
CSD 420
Sept 17th,2 2021
Assignment 7
Create a CSS style sheet that defines a class for white fill and black stroke color and an ID for red and green color.
Write a program that displays four circles and uses the style class and ID. The sample run of the program is shown in the following image. Use the mystyle.css found early in Chapter 31, something like the following code:
.plaincircle{
 -fx-fill: white;
 -fx-stroke: black;
}
.circleborder{
 -fx-stroke-width: 5;
 -fx-stroke-dash-array: 12 2 4 2;
}
.border{
 -fx-border-color: black;
 -fx-border-width: 5;
}
#redcircle{
 -fx-fill: red;
 -fx-stroke: red;
}
#greencircle{
 -fx-fill: green;
 -fx-stroke: green;
}
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // creating an Hbox that will hold our 2 panes and circles
        HBox h = new HBox(10);

        // creating a new scene that will hold our new Hbox
        Scene s = new Scene(h, 415, 250);
        // creating 2 new panes. 1 will hold one circle and the second will hold 3 circles
        Pane p1 = new Pane();
        Pane p2 = new Pane();

        // geting our styleshee that holds our css classes and id for our pane and circles
        s.getStylesheets().add("fx.css");

        // creating 4 new circles to display
        Circle c1 = new Circle(50,70,40);
        Circle c2 = new Circle(50,70,40);
        Circle c3 = new Circle(150,70,40);
        Circle c4 = new Circle(250,70,40);

        // centering the circles vertically
        c1.setCenterY(125);
        c2.setCenterY(125);
        c3.setCenterY(125);
        c4.setCenterY(125);
        
        // add the first circle to the first pane
        p1.getChildren().add(c1);
        // adding circles 2-4 to pane 2
        p2.getChildren().addAll(c2,c3,c4);

        // passing our two panes to our hbaox to hold them and to be added to our scene for display
        h.getChildren().addAll(p1, p2);

        // adding our css style classes and ids to our application
        p1.getStyleClass().add("border");
        c1.getStyleClass().add("plaincircle");
        c2.getStyleClass().add("plaincircle");
        c3.setId("redcircle");
        c4.getStyleClass().addAll("plaincircle", "circleborder");
        c4.setId("greencircle");

        primaryStage.setTitle("JavaFX CSS");
        primaryStage.setScene(s);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
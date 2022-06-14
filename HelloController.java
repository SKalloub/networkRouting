package com.example.algoproject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class HelloController {
    public TextField sizefd;
    public TextField seedfd;
    public Button gnrbtn;
    public TextField startfd;
    public TextField targetfd;
    public Button calbtn;
    public Pane graphPane;
    @FXML
    private Label welcomeText;

    boolean graphGenerated;

    ArrayList<vertex> vertices;
    ArrayList<Circle> circles;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @FXML
    protected void onGenBtnClick() {
        if (!seedfd.getText().isEmpty() && !sizefd.getText().isEmpty()){
            graphPane.getChildren().clear();
            vertices = Driver.initialize(vertices,Integer.parseInt(seedfd.getText()),Integer.parseInt(sizefd.getText()));
            circles = new ArrayList<>();
            for (vertex v: vertices) {
                Circle c = new Circle();
                c.setRadius(1);
                c.setCenterX(v.getX());
                c.setCenterY(v.getY());
                circles.add(c);
                graphPane.getChildren().add(c);
            }
            graphGenerated = true;
        }
        else {
            graphGenerated = false;
        }
    }
    @FXML protected void onCalClick() {
        if (!startfd.getText().isEmpty() && !targetfd.getText().isEmpty()) {

            if (graphGenerated) {

                int start = Integer.parseInt(startfd.getText());
                int target = Integer.parseInt(targetfd.getText());
                dijkstra.findShortestPath(vertices,start,target);
                if (vertices.get(target).getCost()==Double.MAX_VALUE) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("No path between vertices");
                    alert.showAndWait();
                }
                AddLines(vertices.get(target));
                Circle cs = new Circle();
                cs.setRadius(2);
                cs.setCenterX(vertices.get(start).getX());
                cs.setCenterY(vertices.get(start).getY());

                cs.setStyle("-fx-stroke: rgba(62,255,0,0.84)");

                Circle ct = new Circle();
                ct.setRadius(2);
                ct.setCenterX(vertices.get(target).getX());
                ct.setCenterY(vertices.get(target).getY());

                ct.setStyle("-fx-stroke: rgba(255,0,0,0.87)");
                graphPane.getChildren().add(cs);
                graphPane.getChildren().add(ct);
            }
        }
    }

    private void AddLines(vertex vertex) {
        if (vertex.getPath()==null)
            return;
        Line l = new Line(vertex.getPath().getX(),vertex.getPath().getY(),vertex.getX(),vertex.getY());
        l.setStyle(("-fx-stroke: #04043b"));
        graphPane.getChildren().add(l);
        Label la = new Label(round2digits(vertex.getCost())+"");
        la.setStyle("-fx-background-color: rgba(255,234,234,0.36)");
        la.setLayoutX(vertex.getX());
        la.setLayoutY(vertex.getY());
        graphPane.getChildren().add(la);
        AddLines(vertex.getPath());
    }

    private double round2digits(double cost) {
        int c = (int)(cost*100);
        double c2 = (double) c/100.0;
        return c2;
    }
}
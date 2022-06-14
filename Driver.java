package com.example.algoproject;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;

public class Driver extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }











    public static ArrayList<vertex> initialize(ArrayList<vertex> vertices, int seed, int size) {
        Random r = new Random(seed+1);
        vertices = new ArrayList<vertex>();
        for (int i = 0; i < size; i++) {
            vertices.add(new vertex(i, r.nextDouble(0.0,510), r.nextDouble(0.0,595.00)));
        }

        for (int i = 0; i < size; i++) {
            int firstadj = r.nextInt(0,size);
            int secondadj = r.nextInt(0,size);
            int thirdadj = r.nextInt(0,size);
            int fourth = r.nextInt(0,size);
            int fifith = r.nextInt(0,size);
            int sixth = r.nextInt(0,size);
            int seventh = r.nextInt(0,size);
            vertex v1 = vertices.get(firstadj);
            vertex v2 = vertices.get(secondadj);
            vertex v3 = vertices.get(thirdadj);
//            vertex v4 = vertices.get(fourth);
//            vertex v5 = vertices.get(fifith);
//            vertex v6 = vertices.get(sixth);
//            vertex v7 = vertices.get(seventh);

            vertices.get(i).getAdjacents().add(new adjacent(v1,calculateDistance(vertices.get(i),v1)));
            vertices.get(i).getAdjacents().add(new adjacent(v2,calculateDistance(vertices.get(i),v2)));
            vertices.get(i).getAdjacents().add(new adjacent(v3,calculateDistance(vertices.get(i),v3)));
           // vertices.get(i).getAdjacents().add(new adjacent(v4,calculateDistance(vertices.get(i),v4)));


        }
        return vertices;
    }

    private static double calculateDistance(vertex vertex1, vertex vertex2) {
        return Math.sqrt((vertex1.getX()-vertex2.getX())*(vertex1.getX()-vertex2.getX()) + (vertex1.getY()-vertex2.getY())*(vertex1.getY()-vertex2.getY()));
    }


}

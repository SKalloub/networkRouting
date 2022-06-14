package com.example.algoproject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstra {
    public static void findShortestPath(ArrayList<vertex> vertices, int start, int end){
        clear(vertices);
        PriorityQueue<vertex> priorityQueue = new PriorityQueue<>();
        vertices.get(start).setCost(0);
        priorityQueue.add(vertices.get(start));

        while (!priorityQueue.isEmpty()) {
            vertex polled = priorityQueue.poll();
            if (polled==vertices.get(end))
                return;
            else {
                if (!polled.isVisited()) {
                    for (int i = 0; i<polled.getAdjacents().size();i++) {
                        adjacent adj = polled.getAdjacents().get(i);
                        if (!adj.getV().isVisited()) {
                            double newDistance = polled.getCost()+ adj.getDistance();
                            if (newDistance<adj.getV().getCost()) {
                                adj.getV().setCost(newDistance);
                                adj.getV().setPath(polled);
                                if (priorityQueue.contains(adj.getV()))
                                    priorityQueue.remove(adj.getV());
                                priorityQueue.add(adj.getV());
                            }
                        }
                    }
                    polled.setVisited(true);
                }
            }
        }
    }

    private static void clear(ArrayList<vertex> vertices) {
        for (vertex v: vertices) {
            v.setCost(Double.MAX_VALUE);
            v.setVisited(false);
            v.setPath(null);
        }
    }
}

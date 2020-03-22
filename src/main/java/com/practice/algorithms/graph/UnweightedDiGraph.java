package com.practice.algorithms.graph;

import lombok.NonNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class UnweightedDiGraph<T> implements Graph<T> {
    /**
     * The adjacency List used to represent the graph
     */
    @NonNull
    private Map<Node<T>, List<EdgeNode<T>>> adjacencyList;

    /**
     * Constructor
     */
    public UnweightedDiGraph() {
        adjacencyList = new HashMap<>();
    }

    @Override
    public void addEdge(Edge<T> edge) {
        EdgeNode<T> edgeNode = EdgeNode.builder()
                .node(edge.getTo())
                .isWeighted(edge.isWeighted())
                .weight(edge.getWeight())
                .build();
        adjacencyList.putIfAbsent(edge.getFrom(), new ArrayList<>());
        adjacencyList.get(edge.getFrom()).add(edgeNode);
    }

    @Override
    public List<Node<T>> findShortestPath(Node<T> source, Node<T> target) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        Map<Node<T>, Boolean> isDiscovered = new HashMap<>();

        List<Node<T>> traversalPath = new ArrayList<>();
        Map<Node<T>, Node<T>> parent = new HashMap<>();
        // TODO: Complete this.

        adjacencyList.keySet().forEach(node -> {
            isDiscovered.put(node, Boolean.FALSE);
        });
        isDiscovered.replace(source, Boolean.TRUE);
        queue.add(source);
        while (!queue.isEmpty()) {
            Node<T> nextVertex = queue.poll(); // Poll returns and removes the head of the queue
            traversalPath.add(nextVertex);
            List<EdgeNode<T>> adjacentVertices = adjacencyList.get(nextVertex);
            adjacentVertices.forEach(edgeNode -> {
                Node<T> vertex = edgeNode.getNode();
                if(!isDiscovered.get(vertex)) {
                    isDiscovered.replace(vertex, Boolean.TRUE);
                    queue.add(vertex);
                }
            });
        }
        return traversalPath;
    }


}

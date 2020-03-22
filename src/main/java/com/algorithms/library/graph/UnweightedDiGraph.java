package com.algorithms.library.graph;

import lombok.NonNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
    public void addNode(Node<T> node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    @Override
    public void addEdge(Edge<T> edge) {
        // Auto addition of nodes is present
        adjacencyList.putIfAbsent(edge.getFrom(), new ArrayList<>());
        adjacencyList.putIfAbsent(edge.getTo(), new ArrayList<>());

        EdgeNode<T> edgeNode = new EdgeNode<T>();
        edgeNode.setNode(edge.getTo());
        edgeNode.setWeighted(edge.isWeighted());
        edgeNode.setWeight(edge.getWeight());
        adjacencyList.get(edge.getFrom()).add(edgeNode);
    }

    @Override
    public List<Node<T>> findShortestPath(Node<T> source, Node<T> target) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        Map<Node<T>, Boolean> isDiscovered = new HashMap<>();
        Map<Node<T>, Node<T>> parent = new HashMap<>();
        adjacencyList.keySet().forEach(node -> {
            isDiscovered.put(node, Boolean.FALSE);
            parent.put(node, null);
        });
        isDiscovered.replace(source, Boolean.TRUE);
        queue.add(source);
        while (!queue.isEmpty()) {
            Node<T> vertex = queue.poll(); // Poll returns and removes the head of the queue
            List<EdgeNode<T>> adjacentVertices = adjacencyList.get(vertex);
            for (EdgeNode<T> edgeNode : adjacentVertices) {
                Node<T> neighbourNode = edgeNode.getNode();
                if (!isDiscovered.get(neighbourNode)) {
                    isDiscovered.replace(neighbourNode, Boolean.TRUE);
                    queue.add(neighbourNode);
                    parent.replace(neighbourNode, vertex);
                }
                if (neighbourNode.equals(target)) {
                    break;
                }
            }
        }
        return constructPath(parent, target);
    }

    // Auxiliary function to construct the path out of the parent object
    private List<Node<T>> constructPath(Map<Node<T>, Node<T>> parent, Node<T> target) {
        List<Node<T>> traversalPath = new ArrayList<>();
        Node<T> iterator = target;
        while (Objects.nonNull(parent.get(iterator))) {
            traversalPath.add(iterator);
            iterator = parent.get(iterator);
        }
        traversalPath.add(iterator);
        Collections.reverse(traversalPath);
        return traversalPath;
    }


}

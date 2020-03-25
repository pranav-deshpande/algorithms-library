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

    // Note that this can also be implemented as:
    // return findShortestPath(source, target).size() - 1;
    @Override
    public Integer getShortestPathDistance(Node<T> start, Node<T> end) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        Map<Node<T>, Boolean> isDiscovered = new HashMap<>();
        Map<Node<T>, Integer> distance = new HashMap<>();
        adjacencyList.keySet().forEach(key -> {
            isDiscovered.put(key, Boolean.FALSE);
            distance.put(key, Integer.MAX_VALUE);
        });
        isDiscovered.replace(start, Boolean.FALSE);
        distance.replace(start, 0);
        queue.add(start);
        Integer dist = distance.get(start);
        while (!queue.isEmpty()) {
            Node<T> vertex = queue.poll();
            if (vertex.equals(end)) {
                dist = distance.get(vertex);
            }
            List<EdgeNode<T>> adjacentVertices = adjacencyList.get(vertex);
            for (EdgeNode<T> edgeNode : adjacentVertices) {
                Node<T> neighbourNode = edgeNode.getNode();
                if (!isDiscovered.get(neighbourNode)) {
                    isDiscovered.replace(neighbourNode, Boolean.TRUE);
                    queue.add(neighbourNode);
                    if (distance.get(neighbourNode) > distance.get(vertex) + 1) {
                        distance.replace(neighbourNode, distance.get(vertex) + 1);
                    }
                }
            }
        }
        return dist;
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
            if (vertex.equals(target)) {
                break;
            }
            List<EdgeNode<T>> adjacentVertices = adjacencyList.get(vertex);
            for (EdgeNode<T> edgeNode : adjacentVertices) {
                Node<T> neighbourNode = edgeNode.getNode();
                if (!isDiscovered.get(neighbourNode)) {
                    isDiscovered.replace(neighbourNode, Boolean.TRUE);
                    queue.add(neighbourNode);
                    parent.replace(neighbourNode, vertex);
                }
            }
        }
        return constructPath(parent, target);
    }

    @Override
    public List<List<Node<T>>> findAllShortestPaths() {
        return null;
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

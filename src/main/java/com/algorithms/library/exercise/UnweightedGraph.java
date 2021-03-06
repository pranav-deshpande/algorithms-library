package com.algorithms.library.exercise;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;

// TODO: Make this a part of the actual abstract implementation
/**
 * I took the top down approach of actually defining the functions of the graph and then using them instead of
 * just blindly practicing the algorithms. This will make me understand the stuff better as well.
 */

/**
 * Using Lombok for the getter and setter as well as a default constructor
 */
@Getter
@Builder
@RequiredArgsConstructor
// This is the implementation of an unweighted graph
public class UnweightedGraph {
    /**
     * The adjacency List used to represent the graph
     */
    @NonNull
    private List<List<Integer>> adjacencyList;
    /**
     * Directed/Undirected?
     */
    @NonNull
    private Boolean isDirected;

    /**
     * Default Constructor
     */
    public UnweightedGraph() {
        adjacencyList = new ArrayList<>();
        isDirected = true;
    }

    /**
     * Constructor that takes into account if it is a DiGraph
     *
     * @param isDirected isDirected
     */
    public UnweightedGraph(boolean isDirected) {
        adjacencyList = new ArrayList<>();
        this.isDirected = isDirected;
    }

    /**
     * Adds an edge from u to v
     * Automatic handling for both Directed and undirected graphs
     * Automatic creation of non-existing arrays
     *
     * @param u u
     * @param v v
     */
    public void addEdge(int u, int v) {
        IntStream.range(adjacencyList.size(), Math.max(u, v) + 1).forEach(var -> {
            adjacencyList.add(var, new ArrayList<>());
        });
        adjacencyList.get(u).add(v);
        if (!isDirected) {
            adjacencyList.get(v).add(u);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, adjacencyList.size()).forEach(vertex -> {
            stringBuilder.append(vertex).append(" -> ");
            List<Integer> connectedEdges = adjacencyList.get(vertex);
            for (Integer connectedVertex : connectedEdges) {
                stringBuilder.append(connectedVertex).append(" ");
            }
            stringBuilder.append("\n");
        });
        return stringBuilder.toString();
    }

    /**
     * Given a vertex, does BFS on the Graph and returns the order     *
     *
     * @return List<Integer> The node visiting order
     */
    public List<Integer> breadthFirstSearch(Integer startVertex) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Boolean> isDiscovered = new ArrayList<>();
        List<Integer> traversalPath = new ArrayList<>();
        IntStream.range(0, adjacencyList.size()).forEach(var -> {
            isDiscovered.add(var, Boolean.FALSE);
        });
        isDiscovered.set(startVertex, Boolean.TRUE);
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            int nextVertex = queue.poll(); // Poll returns and removes the head of the queue
            traversalPath.add(nextVertex); // Add the vertex to the traversal path
            List<Integer> adjacentVertices = adjacencyList.get(nextVertex);
            for (Integer vertex : adjacentVertices) {
                if (!isDiscovered.get(vertex)) {
                    isDiscovered.set(vertex, Boolean.TRUE);
                    queue.add(vertex);
                }
            }
        }
        return traversalPath;
    }

    /**
     * Given a vertex, does DFS on the Graph and returns the order
     * This is the iterative version of DFS - simple.
     * Just replace the queue in BFS with a stack.
     *
     * @return List<Integer> The node visiting order
     */
    public List<Integer> depthFirstSearchIterative(Integer startVertex) {
        Stack<Integer> stack = new Stack<>();
        List<Boolean> isDiscovered = new ArrayList<>();
        List<Integer> traversalPath = new ArrayList<>();
        IntStream.range(0, adjacencyList.size()).forEach(var -> {
            isDiscovered.add(var, Boolean.FALSE);
        });
        isDiscovered.set(startVertex, Boolean.TRUE);
        stack.add(startVertex);
        while (!stack.isEmpty()) {
            int nextVertex = stack.pop(); // pop returns and removes the head of the stack
            traversalPath.add(nextVertex); // Add the vertex to the traversal path
            List<Integer> adjacentVertices = adjacencyList.get(nextVertex);
            for (Integer vertex : adjacentVertices) {
                if (!isDiscovered.get(vertex)) {
                    isDiscovered.set(vertex, Boolean.TRUE);
                    stack.add(vertex);
                }
            }
        }
        return traversalPath;
    }
}

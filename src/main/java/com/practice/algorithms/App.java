package com.practice.algorithms;

import com.practice.algorithms.graph.Edge;
import com.practice.algorithms.graph.Graph;
import com.practice.algorithms.graph.Node;
import com.practice.algorithms.graph.UnweightedDiGraph;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        UnweightedGraph unweightedGraph = new UnweightedGraph(true);
//        unweightedGraph.addEdge(1, 2);
//        unweightedGraph.addEdge(2, 3);
//        unweightedGraph.addEdge(1, 3);
//        unweightedGraph.addEdge(2 ,4);
//        unweightedGraph.addEdge(4, 5);
//        unweightedGraph.addEdge(1 , 6);
//        System.out.println(unweightedGraph.toString());
//        System.out.println("Now we will conduct a BFS on the graph for index 1");
//        System.out.println(unweightedGraph.breadthFirstSearch(1));
//        System.out.println("Now we will conduct a DFS on the graph for index 1");
//        System.out.println(unweightedGraph.depthFirstSearchIterative(1));

        Graph<String> unweightedDiGraph = new UnweightedDiGraph<>();

        Node<String> nodeA = new Node<>("A", "A");
        Node<String> nodeB = new Node<>("B", "B");
        Node<String> nodeC = new Node<>("C", "C");
        Node<String> nodeD = new Node<>("D", "D");
        Node<String> nodeE = new Node<>("E", "E");
        Node<String> nodeF = new Node<>("F", "F");

        unweightedDiGraph.addEdge(new Edge<>(nodeA, nodeB));
        unweightedDiGraph.addEdge(new Edge<>(nodeB, nodeD));
        unweightedDiGraph.addEdge(new Edge<>(nodeB, nodeE));
        unweightedDiGraph.addEdge(new Edge<>(nodeA, nodeE));
        unweightedDiGraph.addEdge(new Edge<>(nodeA, nodeC));
        unweightedDiGraph.addEdge(new Edge<>(nodeC, nodeF));

        System.out.println(unweightedDiGraph.findShortestPath(nodeA, nodeE));
        System.out.println(unweightedDiGraph.findShortestPath(nodeA, nodeF));






    }
}

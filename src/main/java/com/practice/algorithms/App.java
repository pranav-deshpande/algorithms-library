package com.practice.algorithms;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        UnweightedGraph unweightedGraph = new UnweightedGraph(true);
        unweightedGraph.addEdge(1, 2);
        unweightedGraph.addEdge(2, 3);
        unweightedGraph.addEdge(1, 3);
        unweightedGraph.addEdge(2 ,4);
        unweightedGraph.addEdge(4, 5);
        unweightedGraph.addEdge(1 , 6);
        System.out.println(unweightedGraph.toString());
        System.out.println("Now we will conduct a BFS on the graph for index 1");
        System.out.println(unweightedGraph.breadthFirstSearch(1));
        System.out.println("Now we will conduct a DFS on the graph for index 1");
        System.out.println(unweightedGraph.depthFirstSearchIterative(1));
    }
}

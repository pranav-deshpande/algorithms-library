package com.practice.algorithms;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Graph graph = new Graph(true);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2 ,4);
        graph.addEdge(4, 5);
        graph.addEdge(1 , 6);
        System.out.println(graph.toString());
        System.out.println("Now we will conduct a BFS on the graph for index 1");
        System.out.println(graph.breadthFirstSearch(1));
        System.out.println("Now we will conduct a DFS on the graph for index 1");
    }
}

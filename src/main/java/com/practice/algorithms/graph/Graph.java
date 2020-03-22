package com.practice.algorithms.graph;

import java.util.List;

/**
 * The Graph Interface - essentials operations which can be carried out by this data structure
 */
public interface Graph {
    /**
     * Adds the given edge to the graph
     *
     * @param edge edge
     */
    public void addEdge(Edge edge);

    /**
     * Tells us whether the graph is a directed graph or an undirected graph
     *
     * @return true if the graph is a DiGraph(Directed Graph)
     */
    public boolean isDirected();

    /**
     * Returns the shortest path from the start node to the end node
     *
     * @param start start
     * @param end   end
     * @return List<Node> The shortest path from start to end
     */
    public List<Node> findShortestPath(Node start, Node end);

    /**
     * Returns all possible paths from the start node to the end node
     *
     * @param start start
     * @param end   end
     * @return List<List < Node>> All paths from start to end
     */
    public List<List<Node>> findAllPaths(Node start, Node end);

    /**
     * Returns shortest paths for all pairs of vertices in the graph.
     *
     * @return List<List < Node>> Shortest paths for all pairs of vertices in the graph.
     * The start and end nodes will tell for which pair it is
     */
    public List<List<Node>> findAllShortestPaths();

    /**
     * Finds out if the graph is a cyclic graph
     *
     * @return true if the graph is has cycles, false if not
     */
    public boolean isCyclic();

    /**
     * Returns true if the graph is Acyclic
     *
     * @return true if the graph does not have cycles, false if it has
     */
    default public boolean isAcyclic() {
        return !isCyclic();
    }

    /**
     * A mother vertex is a vertex from which all other nodes can be reached.
     *
     * @return the mother vertex of the graph(if exists)
     * else return null
     */
    public Node getMotherVertex();

    /**
     * A mother vertex is a vertex from which all other nodes can be reached.
     *
     * @return All mother vertices. Empty List if none are there.
     */
    public List<Node> getAllMotherVertices();

    /**
     * A hamiltonian path is a path which visits all the vertices of a graph exactly once
     *
     * @return the traversal path
     */
    public List<Node> getHamiltonianPath();

    /**
     * A hamiltonian path is a path which visits all the vertices of a graph exactly once.
     * A hamiltonian cycle/circuit means that there is an edge connecting the last vertex to the first vertex or
     * that the path is a cycle.
     * <p>
     * If such a circuit exists, then the graph is called Hamiltonian
     * If only a path exists, then the graph is called Semi Hamiltonian
     *
     * @return true if a hamiltonian cycle exists
     */
    public boolean isHamiltonian();


    /**
     * A hamiltonian path is a path which visits all the vertices of a graph exactly once.
     * A hamiltonian cycle/circuit means that there is an edge connecting the last vertex to the first vertex or
     * that the path is a cycle.
     * <p>
     * If such a circuit exists, then the graph is called Hamiltonian
     * If only a path exists, then the graph is called Semi Hamiltonian
     *
     * @return true if a hamiltonian cycle exists
     */
    public boolean isSemiHamiltonian();

    /**
     * Euler path => a path which visits all edges of a Graph. One is allowed to visit the same vertices again.
     * Euler circuit => The path ends up on the same vertex.
     *
     * @return The euler path
     */
    public List<Node> getEulerPath();
}

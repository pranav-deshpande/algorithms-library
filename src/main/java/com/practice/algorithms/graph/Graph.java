package com.practice.algorithms.graph;

import java.util.List;

/**
 * The Graph Interface - essentials operations which can be carried out by this data structure
 */
// TODO: Remove the temporary defaults on all the methods
// They have been defaulted since I cannot implement all of them at once
public interface Graph<T> {

    /**
     * Adds the given node to the graph. Useful for adding isolated nodes
     *
     * @param node node
     */
    public void addNode(Node<T> node);

    /**
     * Adds the given edge to the graph
     *
     * @param edge edge
     */
    public void addEdge(Edge<T> edge);

    /**
     * Tells us whether the graph is a directed graph or an undirected graph
     *
     * @return true if the graph is a DiGraph(Directed Graph)
     */
    default public boolean isDirected() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the shortest path from the start node to the end node
     *
     * @param start start
     * @param end   end
     * @return List<Node < T>> The shortest path from start to end
     */
    public List<Node<T>> findShortestPath(Node<T> start, Node<T> end);

    /**
     * Returns all possible paths from the start node to the end node
     *
     * @param start start
     * @param end   end
     * @return List<List < Node < T>>> All paths from start to end
     */
    default public List<List<Node<T>>> findAllPaths(Node<T> start, Node<T> end) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns shortest paths for all pairs of vertices in the graph.
     *
     * @return List<List < Node < T>>> Shortest paths for all pairs of vertices in the graph.
     * The start and end nodes will tell for which pair it is
     */
    default public List<List<Node<T>>> findAllShortestPaths() {
        throw new UnsupportedOperationException();
    }

    /**
     * Finds out if the graph is a cyclic graph
     *
     * @return true if the graph is has cycles, false if not
     */
    default public boolean isCyclic() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns true if the graph is Acyclic
     *
     * @return true if the graph does not have cycles, false if it has
     */
    default public boolean isAcyclic() {
        return !isCyclic();
    }

    /**
     * Tells if the graph is a Directed Acyclic Graph
     *
     * @return true if it is a DAG
     */
    default public boolean isDAG() {
        return isDirected() && isAcyclic();
    }

    /**
     * A mother vertex is a vertex from which all other nodes can be reached.
     *
     * @return the mother vertex of the graph(if exists)
     * else return null
     */
    default public Node<T> getMotherVertex() {
        throw new UnsupportedOperationException();
    }

    /**
     * A mother vertex is a vertex from which all other nodes can be reached.
     *
     * @return All mother vertices. Empty List if none are there.
     */
    default public List<Node<T>> getAllMotherVertices() {
        throw new UnsupportedOperationException();
    }

    /**
     * A hamiltonian path is a path which visits all the vertices of a graph exactly once
     *
     * @return the traversal path
     */
    default public List<Node<T>> getHamiltonianPath() {
        throw new UnsupportedOperationException();
    }

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
    default public boolean isHamiltonian() {
        throw new UnsupportedOperationException();
    }

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
    default public boolean isSemiHamiltonian() {
        throw new UnsupportedOperationException();
    }

    /**
     * Euler path => a path which visits all edges of a Graph. One is allowed to visit the same vertices again.
     * Euler circuit => The path ends up on the same vertex.
     *
     * @return The euler path
     */
    default public List<Node<T>> getEulerianPath() {
        throw new UnsupportedOperationException();
    }

    /**
     * Euler path => a path which visits all edges of a Graph. One is allowed to visit the same vertices again. => SemiEulerian
     * Euler circuit => The path ends up on the same vertex. =>  Eulerian
     *
     * @return true if the graph is Eulerian
     */
    default public boolean isEulerian() {
        throw new UnsupportedOperationException();
    }

    /**
     * Euler path => a path which visits all edges of a Graph. One is allowed to visit the same vertices again. => SemiEulerian
     * Euler circuit => The path ends up on the same vertex. =>  Eulerian
     *
     * @return true if the graph is SemiEulerian
     */
    default public boolean isSemiEulerian() {
        throw new UnsupportedOperationException();
    }
}

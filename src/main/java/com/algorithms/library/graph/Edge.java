package com.algorithms.library.graph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Edge<T> {
    @NonNull
    private Node<T> from;
    @NonNull
    private Node<T> to;
    @NonNull
    private boolean isWeighted;
    @NonNull
    private Number weight;

    /**
     * This constructor will be helpful for unweighted Graphs
     *
     * @param from from
     * @param to   to
     */
    public Edge(Node<T> from, Node<T> to) {
        this.from = from;
        this.to = to;
        isWeighted = false;
        weight = 1;
    }

}

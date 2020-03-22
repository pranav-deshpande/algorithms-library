package com.practice.algorithms.graph;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Edge {
    @NonNull
    private Node from;
    @NonNull
    private Node to;
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
    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
        weight = 1;
    }

}

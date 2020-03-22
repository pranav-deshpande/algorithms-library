package com.practice.algorithms.graph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class EdgeNode<T> {
    private Node<T> node;
    private boolean isWeighted;
    private Number weight;

    public EdgeNode(Node<T> node) {
        this.node = node;
        isWeighted = false;
        weight = 1;
    }
}
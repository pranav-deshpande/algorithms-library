package com.practice.algorithms.graph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Node<T> {
    String nodeLabel;
    private T data;
    private Object metaData;

    public Node(T data) {
        this.data = data;
    }

    public Node(String nodeLabel, T data) {
        this.nodeLabel = nodeLabel;
        this.data = data;
    }

    public String toString() {
        return nodeLabel;
    }
}

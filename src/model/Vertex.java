package model;

import java.util.Objects;

public class Vertex {

    protected String vertex;

    public Vertex(String vertex) {
        this.vertex = vertex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex1 = (Vertex) o;
        return Objects.equals(vertex, vertex1.vertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex);
    }

    @Override
    public String toString() {
        return vertex;
    }
}

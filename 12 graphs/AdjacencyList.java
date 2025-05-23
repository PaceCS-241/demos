/* Class for representing directed or undirected graphs or trees 
 * with an Adjacency List
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class AdjacencyList<E> {
    // map each vertex to a list of vertices it connects to
    HashMap<Vertex<E>, ArrayList<Edge>> arr;

    public AdjacencyList() {
        arr = new HashMap<>();
    }

    public void addEdge(E source, E destination) {
        // accept 2 data points, create the necessary vertices, add everything to the map
        Vertex<E> s = addVertex(source);
        Vertex<E> d = addVertex(destination);
        Edge edge = new Edge(s, d);
        insertEdge(edge);
    }

    private Vertex<E> addVertex(E data) {
        // add a new vertex with an empty list of edges
        if(containsVertex(data)) {
            return getVertex(data);
        } else {
            Vertex<E> newVertex = new Vertex<>(data);
            arr.putIfAbsent(newVertex, new ArrayList<>());
            return newVertex;
        }
    }

    private void insertEdge(Edge edge) {
        // retrieve values and the current list for the source vertex
        Vertex<E> source = edge.getSource();
        ArrayList<Edge> sourceList = arr.getOrDefault(source, new ArrayList<>());
        // add the new edge to the list and put it back into the map
        sourceList.add(edge);
        arr.put(source, sourceList);
    }

    public boolean containsVertex(E data) {
        for(Vertex<E> v : arr.keySet()) {
            if(v.getData() == data)
                return true;
        }
        return false;
    }

    public Vertex<E> getVertex(E data) {
        for(Vertex<E> v : arr.keySet()) {
            if(v.getData() == data)
                return v;
        }
        return null;
    }


    public ArrayList<Edge> getList(E sourceData) {
        // complete a method for returning all the edges for a given source
        
        return null;
        
    }

    public boolean containsEdge(E sourceData, E destData) {
        // complete a method for finding if an edge exists
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Vertex<E> v : arr.keySet()) {
            sb.append(String.format("%s: ( %s )\n", v, 
                arr.get(v).stream().map(Object::toString).collect(Collectors.joining(", "))));
        }
        return sb.toString();
    }



    /* Internal class for Vertex */
    class Vertex<E> {
        // the data value stored in this vertex
        E data;

        // constructor accepts data value for a node
        Vertex(E data) {
            this.data = data;
        }

        // getter method for data value
        E getData() {
            return this.data;
        }

        @Override
        public String toString() {
            return data.toString();
        }

        @Override
        public boolean equals(Object obj) {
            try {
                Vertex<E> vObj = (Vertex<E>) obj;
                return vObj.data == this.data;
            } catch (Exception e) {
                return false;
            }
        }
    }

    class Edge {
        // the 2 ends of this edge
        Vertex<E> source;
        Vertex<E> dest;

        // constructor
        Edge(Vertex<E> source, Vertex<E> destination) {
            this.source = source;
            this.dest = destination;
        }

        public Vertex<E> getSource() {
            return source;
        }

        public Vertex<E> getDest() {
            return dest;
        }

        public boolean matchDest(Vertex<E> otherDest) {
            return otherDest == this.dest;
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)", source.toString(), dest.toString());
        }

        @Override
        public boolean equals(Object obj) {
            try {
                Edge objEdge = (Edge) obj;
                return (source == objEdge.source && dest == objEdge.dest);
            } catch (Exception E) {
                return false;
            }
        }
    }
}
package c04_trees_and_graphs.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sharath on 8/31/14.
 */
public class Digraph implements DigraphInterface<Integer> {
    // max possible vertices in any graph
    protected int maxSize;
    protected int currSize;
    protected boolean[] vertices;
    protected boolean[] isVisited;
    protected LinkedList[] adjList;

    // Constructor. Constructs empty Digraph object represented by an empty adjacency list,
    // with current size zero, and with no vertices. Hence, each component of the vertices
    // and isVisited arrays is initialized as false.
    public Digraph(int size) {
        this.maxSize = size;
        this.vertices = new boolean[maxSize];
        this.isVisited = new boolean[maxSize];
        this.adjList = new LinkedList[maxSize];
        for(int i = 0; i < maxSize; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    @Override
    public boolean isEmpty() {
        return currSize == 0;
    }

    @Override
    public int size() {
        return currSize;
    }

    @Override
    public boolean isAdjacent(Integer v, Integer w) {
        return adjList[v].contains(w) || adjList[w].contains(v);
    }

    // Inserts edge from v to w.
    // Constructs from v to w, if no such egde already exists and throws exception otherwise.
    // Precondition: v, w are vertices in the current digraph.
    @SuppressWarnings("unchecked")
    @Override
    public void insertEdge(Integer v, Integer w) {
        // v and w are vertices of current digraph and w is not currently joined to v by an edge.
        if(vertices[v] && vertices[w]
                && !adjList[v].contains(w))
            adjList[v].add(w);
        else
            throw new GraphException("Illegal attempt to join edges");
    }

    // Inserts a new vertex if that vertex is not already present
    // and raises exception if no vertex is inserted, since it is already a vertex of current digraph.
    @Override
    public void insertVertex(Integer index) {
        if(!vertices[index]) {
            // vertex is not present in the graph, insert
            ++currSize;
            vertices[index] = true;
        } else if(currSize < maxSize && vertices[index]){
            // vertex already present, throw exception
            throw new GraphException("Vertex already in digraph");
        } else {
            throw new GraphException("Overflow - digraph is already full");
        }
    }

    // Removes vertex from current digraph if present, along with all incident edges.
    // Raises exception if that vertex is not present in digraph
    @Override
    public void eraseVertex(Integer v) {
        if(vertices[v]) { // if v is a vertex
            for(int w = 0; w < maxSize; w++) {
                // w is a vertex and v, w are connected by and incident edge
                if(vertices[w] && adjList[v].contains(w))
                    eraseEdge(v, w);
            }
            // Remove vertex from graph
            vertices[v] = false;
            currSize--;
        } else {
            // v is not a vertex in the graph
            throw new GraphException(v + " is not a vertex of current graph");
        }
    }

    // Removes edge from v to w if currently present in digraph
    // Precondition: v and w are vertices in current digraph
    @Override
    public void eraseEdge(Integer v, Integer w) {
        // There is an edge from v to w, and each of v, w is a vertex in the current digraph.
        if(isAdjacent(v, w) && vertices[v] && vertices[w])
            adjList[v].remove(w);
        else
            throw new GraphException("Edge removal aborted");
    }

    @Override
    public void output() {
        System.out.println("Vertices are: ");
        for(int i = 0; i < maxSize; i++) {
            if(vertices[i])
                System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Edges are: ");
        for(int i = 0; i < maxSize; i++) {
            if(vertices[i])
                System.out.println(i + " " + adjList[i]);
        }
        if(isEmpty()) {
            System.out.println("Current digraph is empty");
        } else {
            System.out.println("Current digraph is not empty");
            System.out.println("Current digraph has " + size() + " vertices.");
        }
    }

    // Some reference to http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/11-Graph/dfs.html
    @SuppressWarnings("unchecked")
    public Queue<Integer> dfs(int startVertex) {
        for (int i = 0; i < isVisited.length; i++)
            isVisited[i] = false;        // Clear visited[]

        // tq -> traversal queue for remembering the path
        Queue<Integer> tq = new LinkedList<>();

        // vertex stack needed for actual dfs
        Stack<Integer> vStack = new Stack<>();
        vStack.push(startVertex);

        while(!vStack.isEmpty()) {
            int topVertex = vStack.pop();
            if(!isVisited[topVertex]) {
                isVisited[topVertex] = true;
                tq.add(topVertex);
                LinkedList<Integer> adjTopVertex = adjList[topVertex];
                for(int nextVertex : adjTopVertex) {
                    if(!isVisited[nextVertex]) {
                        vStack.push(nextVertex);
                    }
                }
            }
        }
        return tq;
    }

    // Some reference to http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/11-Graph/bfs.html
    @SuppressWarnings("unchecked")
    public Queue<Integer> bfs(int startVertex) {
        for (int i = 0; i < isVisited.length; i++)
            isVisited[i] = false;        // Clear visited[]

        isVisited[startVertex] = true;
        // tq -> traversal queue for remembering the path
        Queue<Integer> tq = new LinkedList<>();
        tq.add(startVertex);

        // vertex stack needed for actual dfs
        Queue<Integer> vQueue = new LinkedList<>();
        vQueue.add(startVertex);

        while(!vQueue.isEmpty()) {
            int frontVertex = vQueue.remove();
            LinkedList<Integer> adjFrontVertex = adjList[frontVertex];
            for(int nextVertex : adjFrontVertex) {
                if(!isVisited[nextVertex]) {
                    isVisited[nextVertex] = true;
                    tq.add(nextVertex);
                    vQueue.add(nextVertex);
                }
            }
        }
        return tq;
    }
}

package hackerrank.graphs_and_other_ds.cci.Q4_7_Build_order;

import java.util.*;

/**
 * Created by sharath on 5/30/16.
 */
public class Solution {
    List<Project> findBuildOrder(List<String> projects, List<List<String>> dependencies) {
        Graph g = buildGraph(projects, dependencies);
        return orderOfProjects(g);
    }

    private Graph buildGraph(List<String> projects, List<List<String>> dependencies) {
        Graph g = new Graph();
        for(String p : projects) {
            g.getOrCreateNode(p);
        }
        for(List<String> d : dependencies) {
            String f = d.get(0);
            String s = d.get(1);
            g.addEdge(f, s);
        }
        return g;
    }

    private int addNonDependent(List<Project> order, List<Project> projects, int offset) {
        for(Project p : projects) {
            if(p.getNumberOfDependencies() == 0) {
                order.set(offset++, p);
            }
        }
        return offset;
    }

    private List<Project> orderOfProjects(Graph g) {
        List<Project> projects = g.getNodes();
        List<Project> order = new ArrayList<>();

        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while(toBeProcessed < order.size()) {
            Project curr = order.get(toBeProcessed);

            if(curr == null)
                return null;

            List<Project> dependencies = curr.getChildren();
            for(Project dep : dependencies) {
                dep.decrementDependencies();
            }

            endOfList = addNonDependent(order, dependencies, endOfList);

            toBeProcessed++;
        }
        return order;
    }
}

class Graph {
    private List<Project> nodes = new ArrayList<>();
    private Map<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if(!map.containsKey(name)) {
            Project p = new Project(name);
            nodes.add(p);
            map.put(name, p);
        }
        return map.get(name);
    }

    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbour(end);
    }

    public List<Project> getNodes() {
        return nodes;
    }
}


class Project {
    private List<Project> children = new ArrayList<>();
    private String name;
    int dependencies;

    public Project(String s) {
        this.name = s;
    }

    public void addNeighbour(Project p) {
        if(!children.contains(p)) {
            children.add(p);
            dependencies++;
        }
    }

    public int getNumberOfDependencies() {
        return dependencies;
    }

    public List<Project> getChildren() {
        return children;
    }

    public void decrementDependencies() {
        dependencies--;
    }
}




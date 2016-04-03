/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.benoxley.asympaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author ben
 */
public class MinSpanningTree {
//    "1. Use A* to produce a reduced map of weights for all node to node connections\n",
//    "2. Create a min spanning tree using \n",
//    "    * https://en.wikipedia.org/wiki/Bor%C5%AFvka%27s_algorithm\n",
//    "3. Create duplicates for every edge to create an Eulerian graph\n",
//    "4. Find an Eulerian tour for this graph\n",
//    "5. Convert to TSP: if a city is visited twice, create a shortcut from the city before this in the tour to the one after this.\n",
//    "6. Use 2-opt or 3-opt to minimise the solution\n",
//    "7. Profit"
    
//    Input: A connected graph G whose edges have distinct weights
//1   Initialize a forest T to be a set of one-vertex trees, one for each vertex of the graph.
//2   While T has more than one component:
//3     For each component C of T:
//4       Begin with an empty set of edges S
//5       For each vertex v in C:
//6         Find the cheapest edge from v to a vertex outside of C, and add it to S
//7       Add the cheapest edge in S to T
//8 
//    Combine trees connected by edges to form bigger components
//9   Output: T is the minimum spanning tree of G.
    public static Tree BoruvkaAlgorithm(final List<Point> nodes, final int[][] map){
        List<Tree> forest = nodes.stream().map(n->new Tree(n)).collect(Collectors.toList());
        Map<Point,Map<Point,Path>> costMap = generateCostMap(nodes,map);
        while (forest.size()>1){
            List<Tree> forestCopy = new ArrayList<>(forest);
            while(!forestCopy.isEmpty()){
                Path path = forestCopy.get(0).points.stream()
                        .flatMap(start->costMap.get(start).entrySet().stream())
                        .filter(p->!forestCopy.get(0).points.contains(p.getKey()))
                        .min((a,b)->Integer.compare(a.getValue().cost, b.getValue().cost))
                        .get().getValue();
                Tree tree = forest.stream().filter(t->t.points.contains(path.to)).findAny().get();
                forest.remove(tree);
                forestCopy.remove(tree);
                forestCopy.remove(forestCopy.get(0));
                forest.get(0).edges.add(path);
                forest.get(0).edges.addAll(tree.edges);
                forest.get(0).points.addAll(tree.points);
                
            }
        }
        return forest.get(0);
    }
    
    public static Map<Point,Map<Point,Path>> generateCostMap(final List<Point> nodes, final int[][] map){
        Map<Point,Map<Point,Path>> costMap = new HashMap<>();
        for (Point start : nodes){
            costMap.put(start, new HashMap<>());
            for (Point end : nodes){
                if (end!=start){
                    costMap.get(start).put(end, getPath(start, end, map));
                }
            }
        }
        return costMap;
    }
    
    public static Path getPath(Point start, Point end, final int[][] map){
        Solver solver = new Solver(map);
        List<Point> findRoute = solver.findRoute(start, end, Solver::distance);
        int cost = findRoute.stream().mapToInt(p->map[p.x][p.y]).sum();
        return new Path(findRoute,cost);
    }
}

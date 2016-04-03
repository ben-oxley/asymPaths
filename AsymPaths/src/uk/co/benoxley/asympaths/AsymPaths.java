/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.benoxley.asympaths;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ben
 */
public class AsymPaths {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("runAnalyser");
            String mapFile = "../build/map5000.txt";
            String nodesFile = "../build/path.txt";
            System.out.println(new File("").getAbsolutePath());
            List<Point> nodes = CSVReader.readNodes(new File(nodesFile));
            AsymPaths.runAnalyser(mapFile,nodes.get(0),nodes.get(1));
            //AsymPaths.runAnalyser(mapFile,nodes.get(0),nodes.get(nodes.size()-1));
            int[][] map = CSVReader.readMap(new File(mapFile)); 
            Tree tree = MinSpanningTree.BoruvkaAlgorithm(nodes, map);
            System.out.println("Number of edges in tree: "+tree.edges.size());
            System.out.println("Number of nodes in tree: "+tree.points.size());
        } catch (IOException ex) {
            Logger.getLogger(AsymPaths.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void runAnalyser(String mapFile,Point start, Point end ){
        try {
            int[][] map = CSVReader.readMap(new File(mapFile));           
            Solver solver = new Solver(map);
            List<Point> findRoute = solver.findRoute(start, end, (a,b)->0);
            System.out.println(findRoute);
        } catch (IOException ex) {
            Logger.getLogger(AsymPaths.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

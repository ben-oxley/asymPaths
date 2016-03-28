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
        System.out.println("runAnalyser");
        String mapFile = "../build/map5000.txt";
        System.out.println(new File("").getAbsolutePath());
        AsymPaths.runAnalyser(mapFile);
    }
    
    public static void runAnalyser(String mapFile){
        try {
            int[][] map = CSVReader.readMap(new File(mapFile));
            Solver solver = new Solver(map);
            Point start = new Point(0, 0);
            Point end = new Point(map.length-1, map.length-1);
            List<Point> findRoute = solver.findRoute(start, end, (a,b)->0);
            System.out.println(findRoute);
        } catch (IOException ex) {
            Logger.getLogger(AsymPaths.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

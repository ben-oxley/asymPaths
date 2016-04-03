/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.benoxley.asympaths;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ben
 */
public class MinSpanningTreeTest {
    
    public MinSpanningTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of BoruvkaAlgorithm method, of class MinSpanningTree.
     */
    @Test
    public void testBoruvkaAlgorithm() throws IOException {
        System.out.println("runAnalyser");
        String mapFile = "../build/map.txt";
        System.out.println(new File("").getAbsolutePath());
        int[][] map = CSVReader.readMap(new File(mapFile));
        List<Point> points = Arrays.asList(new Point(0,0),new Point(5,5),new Point(35,50));
        MinSpanningTree.BoruvkaAlgorithm(points, map);
    }

    /**
     * Test of generateCostMap method, of class MinSpanningTree.
     */
    @Test
    public void testGenerateCostMap() {
        System.out.println("generateCostMap");
        List<Point> nodes = null;
        int[][] map = null;
        Map<Point, Map<Point, Path>> expResult = null;
        Map<Point, Map<Point, Path>> result = MinSpanningTree.generateCostMap(nodes, map);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPath method, of class MinSpanningTree.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        Point start = null;
        Point end = null;
        int[][] map = null;
        Path expResult = null;
        Path result = MinSpanningTree.getPath(start, end, map);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

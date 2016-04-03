/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.benoxley.asympaths;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ben
 */
public class CSVReader {

    public static int[][] readMap(File file) throws IOException {
        try (FileReader reader = new FileReader(file)) {
            try (BufferedReader lineReader = new BufferedReader(reader)) {
                List<List<Integer>> map = new ArrayList<>();
                String line = lineReader.readLine();
                while (line != null) {
                    String[] split = line.split(",");
                    map.add(Arrays.asList(split).stream().map(Integer::parseInt).collect(Collectors.toList()));
                    line = lineReader.readLine();
                }
                int[][] outputArray = new int[map.get(0).size()][map.size()];
                for (int row = 0; row < map.size(); row++) {
                    for (int col = 0; col < map.get(row).size(); col++) {
                        outputArray[col][row] = map.get(col).get(row);
                    }
                }
                return outputArray;
            }
        }
    }
    
    public static List<Point> readNodes(File file) throws IOException{
        try (FileReader reader = new FileReader(file)) {
            try (BufferedReader lineReader = new BufferedReader(reader)) {
                List<Point> map = new ArrayList<>();
                String line = lineReader.readLine();
                line = lineReader.readLine();
                while (line != null) {
                    String[] split = line.split(",");
                    List<Integer> node = Arrays.asList(split).stream().map(Integer::parseInt).collect(Collectors.toList());
                    map.add(new Point(node.get(1), node.get(2)));
                    line = lineReader.readLine();
                }
                return map;
            }
        }
    }
}

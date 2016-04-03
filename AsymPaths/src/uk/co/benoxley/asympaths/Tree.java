/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.benoxley.asympaths;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ben
 */
public class Tree {
    public Set<Path> edges = new HashSet<>();
    public Set<Point> points = new HashSet<>();
    public Tree(){}
    public Tree(Point firstPoint){
        points.add(firstPoint);
    }
}

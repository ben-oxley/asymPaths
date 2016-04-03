/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.benoxley.asympaths;

import java.util.List;

/**
 *
 * @author ben
 */
public class Path {
    public final Point from;
    public final Point to;
    public final List<Point> path;
    public final int cost;
    public Path(final List<Point> path,final int cost){
        this.from = path.get(0);
        this.to = path.get(path.size()-1);
        this.path = path;
        this.cost = cost;
    }
}

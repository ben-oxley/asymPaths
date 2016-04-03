/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.benoxley.asympaths;

/**
 *
 * @author ben
 */
public class Edge {
    public final Point one;
    public final Point tother;
    public Edge(Point one, Point tother){
        this.one = one;
        this.tother = tother;
    }
}

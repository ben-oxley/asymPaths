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
public class Point{
    public final int x;
    public final int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Point && this.x == ((Point) obj).x && this.y == ((Point) obj).y;
    }

    @Override
    public int hashCode() {
        //Equivalent of x*65536+y
        return x<<16|y;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    
    
    
}

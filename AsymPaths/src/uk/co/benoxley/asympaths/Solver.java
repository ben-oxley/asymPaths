/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.benoxley.asympaths;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.BiFunction;

/**
 *
 * @author ben
 */
public class Solver {
    private final int[][] costMap;
    private final int xWidth;
    private final int yHeight;
    private final Point[][] previousposition;
    private final int[][] gscore;
    private final int[][] fscore;
    private final boolean[][] visitedNodeMap;
    public Solver(int[][] map){
        costMap = map;
        xWidth = map.length;
        yHeight = map[0].length;
        previousposition = new Point[xWidth][yHeight];
        gscore = new int[xWidth][yHeight];
        fscore = new int[xWidth][yHeight];
        visitedNodeMap = new boolean[xWidth][yHeight];
        for (int col=0; col<xWidth; col++){
            for (int row=0; row<yHeight; row++){
                gscore[col][row] = Integer.MAX_VALUE;
                fscore[col][row] = Integer.MAX_VALUE;
            }
        }

    }
    
    public static int distance(final Point start, final Point end){
        return Math.abs(start.x-end.x)+Math.abs(start.y-end.y);
    }
    
    private List<Point> replayPath(Point[][] cameFrom, Point current, Point start){
        List<Point> totalPath = new ArrayList<>();
        totalPath.add(current);
        Point position = current;
        while(position != start){
            position = cameFrom[position.x][position.y];
            totalPath.add(position);
        }
        return totalPath;
    }
    
    private Point sort(Set<Point> discoveredNodes,int[][] fscore){
        int lowest = Integer.MAX_VALUE;
        Point lowestItem = null;
        for (Point item : discoveredNodes){
            int score = fscore[item.x][item.y];
            if (lowest > score){
                lowest = score;
                lowestItem = item;
            }
        }
        return lowestItem;
    }

    public List<Point> findRoute(Point start, Point end, BiFunction<Point,Point,Integer> costFunction){
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b)->fscore[a.x][a.y]-fscore[b.x][b.y]);
        gscore[start.x][start.y] = 0;
        fscore[start.x][start.y] = costFunction.apply(start, end);
        pq.add(start);
        while (pq.size()>0){
            Point currentNode = pq.poll();
            if (currentNode.equals(end)){
                return(replayPath(previousposition,end,start));
            }
            visitedNodeMap[currentNode.x][currentNode.y] = true;
            Set<Point> points = new HashSet<>();
            points.add(new Point(Math.max(currentNode.x-1,0),currentNode.y));
            points.add(new Point(Math.min(xWidth-1,currentNode.x+1),currentNode.y));
            points.add(new Point(currentNode.x,Math.min(currentNode.y+1,yHeight-1)));
            points.add(new Point(currentNode.x,Math.max(currentNode.y-1,0)));
            for (Point point : points){
                if (visitedNodeMap[point.x][point.y] == false){
                    int newGScore = gscore[currentNode.x][currentNode.y]+costMap[point.x][point.y];
                    if (newGScore < gscore[point.x][point.y]){
                        previousposition[point.x][point.y] = currentNode;
                        gscore[point.x][point.y] = newGScore;
                        fscore[point.x][point.y] = newGScore + costFunction.apply(start,end);
                        pq.remove(point);
                        pq.add(point);
                    }
                }
            }
        }
        throw new IllegalStateException("Could not find solution");
    }

}

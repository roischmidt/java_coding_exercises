import java.util.*;

/*
    You are given a campus map with the Google buildings, roads and Google
bikes. You have to help the employee find the nearest Google bike.

Campus map:


. - Free path/road
# - Building
B - Google bike

Employee location - (x, y) - (1, 2)

. . . . . #
. . E . . #
# # # # . #
. B . . . .
. . . . . B
 */
public class GoogleCampusQuestion {
    final static private int BUILDING = 1;
    final static private int BIKE = 2;

    static class Point{
        public int x;
        public int y;
        public int step;
        public Point(int x, int y,int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public static int numOfStepsToNearestBike(int[][] campus, int campusWidth, int campusHeight, int row, int col) {
        Queue<Point> points = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        Point firstPosition = new Point(col,row,0);
        points.add(firstPosition);
        visited.add(firstPosition);
        int minSteps = campusWidth*campusHeight;
        while(!points.isEmpty()) {
            Point p = points.remove();
            if(p.step > minSteps)
                continue;
            if(campus[p.y][p.x] == BIKE){
                if(p.step < minSteps)
                    minSteps = p.step;
            }
            Point right = new Point(p.x + 1,p.y,p.step + 1);
            if(isValidMove(campus,campusWidth,campusHeight,right,visited)){
                points.add(right);
                visited.add(right);
            }
            Point up = new Point(p.x,p.y + 1,p.step + 1);
            if(isValidMove(campus,campusWidth,campusHeight,up,visited)){
                points.add(up);
                visited.add(up);
            }
            Point left = new Point(p.x - 1,p.y,p.step + 1);
            if(isValidMove(campus,campusWidth,campusHeight,left,visited)){
                points.add(left);
                visited.add(left);
            }
            Point down = new Point(p.x,p.y - 1,p.step + 1);
            if(isValidMove(campus,campusWidth,campusHeight,down,visited)){
                points.add(down);
                visited.add(down);
            }
        }
        return minSteps;
    }

    private static boolean isValidMove(int[][] campus, int campusWidth, int campusHeight,Point point,Set<Point> visited) {
        if (point.x >= campusWidth || point.y >= campusHeight || point.x < 0 || point.y < 0)
            return false;
        int position = campus[point.y][point.x];
        return position != BUILDING && !visited.contains(point);
    }


    public static void main(String[] args) {

        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 2, 0, 0},
                {0, 0, 1, 0, 0, 2, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 1, 0}
        };
        int width = 10;
        int height = 5;
        int row = 0;
        int col = 0;
        int minSteps = numOfStepsToNearestBike(board,width,height, row, col);
        System.out.println(minSteps);
    }

}

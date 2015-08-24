
package com.puzzles.path;

import java.util.ArrayList;
import java.util.List;

public class PathFinder {

    private static final char ARRAY[][] = new char[][] {
        {'.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.'},
        {'W','.','.','.','.','.','.'},
        {'W','.','W','.','W','.','.'},
        {'.','.','.','O','.','.','.'},
        {'.','.','W','.','.','.','.'},
        {'.','.','.','X','.','.','.'}
    };
    
    private static List<String> path = new ArrayList<String>();

    private static int oX, oY;

    private static int xX, xY;

    private static int length;

    public static void main(String[] args) {
        
        length = ARRAY.length;

        if (findOPosition()) {
            System.err.println("Unable to find 'O' position");
        }

        if (findXPosition()) {
            System.err.println("Unable to find 'X' position");
        }

        boolean pathFound = findPath();
        System.out.println("path found : " + pathFound);
    }

    private static boolean findPath() {

        int dX = oX < xX ? 1 : (oX == xX ? 0 : -1);

        int dY = oY < xY ? 1 : (oY == xY ? 0 : -1);

        boolean traverse = traverse(oX, oY, dX, dY);
        if (traverse) {
            path.add(0, (oX+dX) + ":" + ((oY+dY)));
        }
        return traverse;
    }

    private static boolean traverse(int currX, int currY, int dX, int dY) {
        if (currX + dX == xX && currY + dY == xY) {
            return true;
        }

        if (currX + dX < length && currX + dX >= 0) {
            currX += dX;
        }

        if (currY + dY < length && currY + dY >= 0) {
            currY += dY;
        }

        boolean found;
        if (ARRAY[currX][currY] == '.') {
            ARRAY[currX][currY] = 'V';
            return traverse(currX, currY, dX, dY);
        } else {
            if (ARRAY[currX][currY] == 'V') {
                return false;
            }
            found = !traverse(currX, currY, dX*-1, dY);
            if(!found) {
                found = !traverse(currX, currY, dX, dY*-1);
                if(!found) {
                    found = !traverse(currX, currY, dX*-1, dY*-1);
                }
            }
        }

        if (found) {
            path.add(0, currX + ":" + currY);
        }

        return found;
    }

    private static boolean findOPosition() {
        if (ARRAY == null) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (ARRAY[i][j] == 'O') {
                    oX = i;
                    oY = j;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findXPosition() {
        if (ARRAY == null) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (ARRAY[i][j] == 'X') {
                    xX = i;
                    xY = j;
                    return true;
                }
            }
        }
        return false;
    }
}

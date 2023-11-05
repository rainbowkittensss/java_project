package edu.project2;

import java.util.Stack;

public class MazeCreator {
    record Coordinates(int x, int y, boolean used){}
    class Maze{
        public Maze(int szA,int szB){
            sizeA = szA;
            sizeB = szB;
            matrix = new int[szA][szB];
        }
        int sizeA, sizeB;
       public int[][] matrix;
    }
    public Maze generate(int szA,int szB){
        Stack<Coordinates> stackBoxes = new Stack<>();
        Maze maze = new Maze(szA,szB);
        for(int i = 0; i < szA; i++){
            for(int j = 0; j < szB; j++){
                if((i % 2 != 0  && j % 2 != 0) &&
                    (i < szA-1 && j < szB-1))
                    maze.matrix[i][j] = 0;       //0 -- клетки лабиринта
                else maze.matrix[i][j] = 1;           //1 -- стены
            }
        }
        Coordinates startCoord = new Coordinates(0,0,true);
        Coordinates currentCoord = startCoord;
        int VisitedCoords = szA*szB;
        do {

        }while (VisitedCoords>0)
    }

}

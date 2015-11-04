package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static netcracker.intensive.rover.constants.CellState.OCCUPIED;

/**
 * Created by Владислав on 07.10.2015.
 */
public class Ground {
    private GroundCell[][] field;
    int n;
    int m;
    Ground(int n, int m){
        this.n =  n;
        this.m = m;
        field = new GroundCell[n][m];
    }
    public void  initialize(GroundCell ... ar){
        int t = 0;
        if( m*n != (ar.length))
            throw new IllegalArgumentException();
        for (int i = 0; i < n ; i++) {
            for(int j = 0; j < m; j++) {
                field[i][j] = ar[t];
               // System.out.println("" + field[i][j] + i + j);
                t++;
            }
        }
        //field =(ArrayList)Arrays.asList(ar);
    }
    public void init(){

        Random random = new Random();
        int length = random.nextInt(6) + 4;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <length ; j++) {
                //GroundCell tmp = new GroundCell(new Point(i,j));
               // field.add(new GroundCell(new Point(i,j)));
            }
        }
        Random busyCell = new Random();
        int numberBusyCell = busyCell.nextInt( (int)(length / 2 * length) );
        System.out.println(numberBusyCell);
        for (int i = 0; i < numberBusyCell ; i++) {
            //field.get(busyCell.nextInt(length * length)).setState(CellState.FREE);
        }
    }
    public GroundCell getCell(int i ,int j) throws OutOfGroundException {
        if((i < 0) || (i > n) || (j < 0) || (j > m))
            throw new OutOfGroundException();
        return field[j][i];
        //Point point  = new Point(i,j);
        //for(GroundCell cell : field) {
          //  if(cell.isYou(point))
            //    return cell;
        //}
       // return new GroundCell(OCCUPIED);
    }
    public void print(){
        //for (GroundCell cell: field){
          //  System.out.println(cell.toString());
       // }
    }

}


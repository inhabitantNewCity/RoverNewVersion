package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.Direction;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;

import java.util.HashMap;

   // import action.*;
    //import errors.OutOfGroundException;
    //import main.ground.GroundVisor;
    //import con
    //import utils.Point;
    //import utils.SimpleRoverStatsModule;
    /**
     * Created by Владислав on 07.10.2015.
     */
    public class Rover implements Landable, Liftable, Moveable, Turnable{
        private Point location = new Point(0,0);
        private Direction direction = Direction.SOUTH;
        private boolean flight = false;
        private GroundVisor view;
        private HashMap<String,Object> map;

        public Rover(GroundVisor visor,HashMap<String,Object> hashMap){
            map = hashMap;
            view = visor;
        }
        
        public Rover(GroundVisor visor){
            view = visor;
        }
        @Override
        public void land(Point point, Direction direction) {
            try {
                boolean check = view.hasObstacles(point);
                if (!check) {
                    location = point;
                    flight = false;
                    this.direction = direction;
                    System.out.println("I go to x = " + location.getX()+ " y = " + location.getY());
                   // if(map.containsKey("status")){
                     //   SimpleRoverStatsModule status = (SimpleRoverStatsModule) map.get("status");
                       // status.registerPosition(location);
                    //}
                }
                else lift();
            }
            catch (OutOfGroundException e){
                lift();
                e.printStackTrace();
            }

        }

        @Override
        public void lift() {
            if(!flight)
                flight = true;
            location = null;
            direction = null;
            System.out.println("I fly");
        }

        @Override
        public void move() {
            if((location == null) || (direction == null))
                return;
            try {
                switch (direction) {
                    case SOUTH:
                        moveSought();
                        break;
                    case NORTH:
                        moveNorth();
                        break;
                    case WEST:
                        moveWest();
                        break;
                    case EAST:
                        moveEast();
                        break;
                }
               // this.direction = Direction.SOUTH;
                //this.location = new Point(0,0);
            }catch (OutOfGroundException e){
                lift();
                e.printStackTrace();
            }

        }


        private void moveSought() throws OutOfGroundException{
            if(location == null)
                return;
            if(!view.hasObstacles(new Point(location.getX(), (location.getY() + 1)))) {
                location.setY(location.getY() + 1);
                System.out.println("I go to " + location);
                //if(map.containsKey("status")){
                  //  SimpleRoverStatsModule status = (SimpleRoverStatsModule) map.get("status");
                    //status.registerPosition(location);
                //}
            }
            //else lift();
        }


        private void moveNorth() throws OutOfGroundException{
            if(location == null)
                return;
            if(!view.hasObstacles(new Point(location.getX(), (location.getY() - 1)))) {
                location.setY(location.getY() - 1);
                System.out.println("I go to " + location);
                //if(map.containsKey("status")){
                   // SimpleRoverStatsModule status = (SimpleRoverStatsModule) map.get("status");
                 //   status.registerPosition(location);
               // }
            }
            //else lift();
        }

        private void moveWest() throws OutOfGroundException{
            if(location == null)
                return;
            if(!view.hasObstacles(new Point((location.getX() - 1), location.getY()))) {
                location.setX(location.getX() - 1);
                System.out.println("I go to " + location);
               // if(map.containsKey("status")){
                 //   SimpleRoverStatsModule status = (SimpleRoverStatsModule) map.get("status");
                   // status.registerPosition(location);
                //}
            }

        }

        private void moveEast() throws OutOfGroundException {
            if(location == null)
                return;
            if (!view.hasObstacles(new Point((location.getX() + 1), location.getY()))) {
                location.setX(location.getX() + 1);
                System.out.println("I go to " + location);
               // if(map.containsKey("status")){
                 //   SimpleRoverStatsModule status = (SimpleRoverStatsModule) map.get("status");
                   // status.registerPosition(location);
                //}
            }
            //else lift();
        }

        @Override
        public void turnTo(Direction direction) {
            this.direction = direction;
            System.out.println("I turn to " + direction );
        }

        public Point getCurrentPosition() {
            return location;
        }

        public boolean isAirborne() {
            return flight;
        }

        public Direction getDirection() {
            return direction;
        }
    }

package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;

import javax.swing.*;

/**
 * Этот класс должен уметь все то, что умеет обычный Rover, но при этом он еще должен уметь выполнять программы,
 * содержащиеся в файлах
 */
public class ProgrammableRover extends Rover{

    private UIManager settings;
    //private Point currentPosition;
    //private GroundVisor groundVisor;
    SimpleRoverStatsModule simpleRoverStatsModule;

    public ProgrammableRover(GroundVisor groundVisor, SimpleRoverStatsModule simpleRoverStatsModule) {
        super(groundVisor);
        //this.groundVisor = groundVisor;
        this.simpleRoverStatsModule = simpleRoverStatsModule;
    }

    public void executeProgramFile(String file) {

    }


    //public Point getCurrentPosition() {
      //  return currentPosition;
    //}

    public UIManager getSettings() {
        return settings;
    }

    public void setSettings(UIManager settings) {
        this.settings = settings;
    }
}

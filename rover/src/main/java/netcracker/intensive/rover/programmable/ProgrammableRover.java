package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.command.RoverCommand;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;

import javax.swing.*;
import javax.swing.text.StringContent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Этот класс должен уметь все то, что умеет обычный Rover, но при этом он еще должен уметь выполнять программы,
 * содержащиеся в файлах
 */
public class ProgrammableRover extends Rover{

    private  HashMap<String, Objects> sitting;
    private boolean status = false;
    SimpleRoverStatsModule simpleRoverStatsModule;

    public ProgrammableRover(GroundVisor groundVisor, SimpleRoverStatsModule simpleRoverStatsModule) {
        super(groundVisor);
        //this.groundVisor = groundVisor;
        this.simpleRoverStatsModule = simpleRoverStatsModule;
    }

    public void executeProgramFile(String file) {
        RoverCommandParser parser = new RoverCommandParser(this,file);
        RoverProgram program = parser.getProgram();
        sitting = (HashMap)program.getSettings();
        //sitting.
       // if((Boolean)sitting.get(RoverProgram.STATS)){
         //   status = true;
        //}
        ArrayList<RoverCommand> comands = (ArrayList)program.getCommands();
        for (int i = 0; i < comands.size() ; i++) {
            comands.get(i).execute();
        }
    }


    //public Point getCurrentPosition() {
      //  return currentPosition;
    //}

    public HashMap<String, Object> getSettings() {
        return (HashMap)sitting;
    }

   // public void setSettings(UIManager settings) {
       // this.settings = settings;
    //}
}

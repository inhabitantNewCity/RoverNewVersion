package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.command.RoverCommand;

import java.awt.*;
import java.util.*;

public class RoverProgram {
    public static final String LOG = "log";
    public static final String STATS = "stats";
    public static final String SEPARATOR = "===";
    private HashMap<String, Object> settings;
    private ArrayList<RoverCommand> commands;

    public Map<String, Object> getSettings() {
        return  settings;
    }

    public void setSettings(Map<String, Object> settings) {
        this.settings = (HashMap)settings;
       // settings.
    }

    public Collection<RoverCommand> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<RoverCommand> commands) {
      this.commands = commands;
    }
}

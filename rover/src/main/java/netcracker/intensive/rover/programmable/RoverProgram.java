package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.command.RoverCommand;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RoverProgram {
    public static final String LOG = "log";
    public static final String STATS = "stats";
    public static final String SEPARATOR = "===";
    private Component settings;
    private Collection<RoverCommand> commands;

    public Map<String, Object> getSettings() {
        return (Map<String, Object>) settings;
    }

    public void setSettings(Component settings) {
        this.settings = settings;
    }

    public Collection<RoverCommand> getCommands() {
        return commands;
    }

    public void setCommands(Component commands) {
        this.settings = commands;
    }
}

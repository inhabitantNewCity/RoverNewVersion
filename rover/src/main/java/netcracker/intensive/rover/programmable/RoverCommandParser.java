package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.command.*;
import netcracker.intensive.rover.constants.Direction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class RoverCommandParser {
    private String pathFile;
    private boolean logging = false;
    private boolean statsing = false;
    private ProgrammableRover rover;
    private HashMap<String, Object> settings = new HashMap<>();
    private RoverProgram program = new RoverProgram();
    private ArrayList<RoverCommand> commands = new ArrayList<>();

    public RoverCommandParser(ProgrammableRover rover, String file) {
        this.rover = rover;
        pathFile = "C:\\Users\\Владислав\\Desktop\\computer\\lening\\netCreacer\\java\\Rover\\java-nc-intensive\\rover\\src\\test\\resources\\netcracker\\intensive\\rover\\programmable\\" + file;
        program.setSettings(settings);
        program.setCommands(commands);
        parse();
    }
    private void parse(){
        try {
        BufferedReader stream = new BufferedReader(new FileReader(pathFile));
        String string;
        if(((string = stream.readLine()) != null)&&(!string.equals(""))) {
            parseLog(string);
        }
        if(((string = stream.readLine()) != null)&&(!string.equals("")))
            parseStats(string);

       // String string;
        while ( ((string = stream.readLine()) != null)&&(!string.equals("")))
        {
            parseString(string);
        }
        //new MessageToRover( new RoverCommandEndOfFile()).send();

    } catch (Exception e) {
        e.printStackTrace();
        throw new RoverCommandParserException();
    }
    }
    private void parseLog(String str){
        String tmp = str.substring(str.indexOf(" ")+1,str.length());
        if((str.substring(str.indexOf(" ")+1,str.length())).equals("on")){
            settings.put(RoverProgram.LOG,true);
            logging = true;
            //commands.add(LoggingCommand(rover));
        }
        else{
            settings.put(RoverProgram.LOG,false);
        }
    }
    private void parseStats(String str){
        if((str.substring(str.indexOf(" ") + 1,str.length()).equals("on"))) {
            //TODO: job with status. create simpleRoverStatsModule and coll it`s methods
            settings.put(RoverProgram.STATS,true);
            statsing = true;
        }
        else{
            settings.put(RoverProgram.STATS,false);
        }
    }
    private void parseString(String str){
        if(str.equals("===")){
            System.out.println("parameters is setting");
            return;
        }
        if(str.equals("")){
            //new MessageToRover(new RoverCommandEndOfFile());
            return;
        }
        int indexEndString = (str.indexOf(" ") == -1)?str.length():str.indexOf(" ");
        String tmp = str.substring(0, indexEndString);
        System.out.println(tmp);
        switch (tmp) {
            case "move":
                MoveCommand move = new MoveCommand(rover);
                if(logging){
                    commands.add(new LoggingCommand(move));
                }
                commands.add(move);

                break;
            case "turn":
                Direction direction = null;
                tmp = str.substring(indexEndString + 1,str.length());
                tmp = tmp.toUpperCase();
                switch (tmp){
                    case "SOUTH": direction = Direction.SOUTH; break;
                    case "NORTH": direction = Direction.NORTH; break;
                    case "WEST": direction = Direction.WEST; break;
                    case "EAST": direction = Direction.EAST; break;
                }
                commands.add(new TurnCommand(rover,direction));
                break;
            case "lift":
                commands.add(new LiftCommand(rover));
                break;
            case "land":
                String fistComponent = str.substring(indexEndString + 1, str.length());
                int indexFistComponent = fistComponent.indexOf(" ");
                int fistComponentPoint = Integer.parseInt(fistComponent.substring(0, indexFistComponent));
                String lastComponent = fistComponent.substring(indexFistComponent + 1, fistComponent.length());
                int indexSecondComponent = lastComponent.indexOf(" ");
                int secondComponentPoint = Integer.parseInt(lastComponent.substring(0,indexSecondComponent));
                Point point = new Point(fistComponentPoint,secondComponentPoint);
                Direction direction1 = null;
                tmp = lastComponent.substring(indexSecondComponent + 1,lastComponent.length());
                tmp = tmp.toUpperCase();
                switch (tmp){
                    case "SOUTH": direction1 = Direction.SOUTH; break;
                    case "NORTH": direction1 = Direction.NORTH; break;
                    case "WEST": direction1 = Direction.WEST; break;
                    case "EAST": direction1 = Direction.EAST; break;
                }
                commands.add(new LandCommand(rover,point,direction1));
                break;
        }
    }

    public RoverProgram getProgram() {
        return program;
    }

    public void setProgram(RoverProgram program) {
        this.program = program;
    }
}

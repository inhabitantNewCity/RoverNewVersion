package netcracker.intensive.rover.programmable;

public class RoverCommandParser {

    private RoverProgram program;

    public RoverCommandParser(ProgrammableRover rover, String file) {
    }

    public RoverProgram getProgram() {
        return program;
    }

    public void setProgram(RoverProgram program) {
        this.program = program;
    }
}

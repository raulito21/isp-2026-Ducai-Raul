package isp.lab11.exercise;

public class AtcCommand {
    Command command;

    public AtcCommand(Command command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "AtcCommand{" +
                "command='" + command + '\'' +
                '}';
    }
}

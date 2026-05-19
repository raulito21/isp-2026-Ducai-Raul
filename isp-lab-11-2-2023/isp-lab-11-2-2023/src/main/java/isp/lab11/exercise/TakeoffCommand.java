package isp.lab11.exercise;

public class TakeoffCommand extends AtcCommand{
    private int altitude;
    public TakeoffCommand(Command command,int altitude)
    {
        super(command);
        this.altitude=altitude;
    }
    public int getAltitude()
    {
        return altitude;
    }
}

package isp.lab11.exercise;

public enum Command {
    TAKEOFF_CMD(1),
    LAND_CMD(2);

    public final int value;

    Command(int value)
    {
        this.value=value;
    }
}

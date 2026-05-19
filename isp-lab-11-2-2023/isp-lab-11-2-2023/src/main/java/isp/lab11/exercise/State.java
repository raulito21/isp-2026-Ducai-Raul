package isp.lab11.exercise;

public enum State {
    ON_STAND(0),
    TAXIING(1),
    TAKING_OFF(2),
    ASCENDING(3),
    CRUISING(4),
    DESCENDING(5),
    LANDING(6);

    public final int value;

    State(int value)
    {
        this.value=value;
    }
}

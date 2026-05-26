package org.ispcluj;

//TODO: REQ-3 and handle REQ1's uniqueness check
public class TrafficController {
    private final TerminalStation terminalStation;
    private final List<Train> schedule;
    private final Random random = new Random();

    public TrafficController(TerminalStation terminalStation, List<Train> schedule) {
        this.terminalStation = terminalStation;
        this.schedule = schedule;
    }

    @override

}

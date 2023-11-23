package zarizeni.state;

import zarizeni.Zarizeni;

public class RunningState extends State{
    RunningState(Zarizeni zarizeni) {
        super(zarizeni);
    }

    @Override
    public String turnOn() {
        zarizeni.changeState(new ReadyState(zarizeni));
        return "Paused. Ready to keep running";
    }

    @Override
    public String turnOff() {
        zarizeni.changeState(new OffState(zarizeni));
        return "Turned off";
    }

    @Override
    public String run() {
        return "already running";
    }
}

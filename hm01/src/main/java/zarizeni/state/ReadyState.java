package zarizeni.state;

import zarizeni.Zarizeni;

public class ReadyState extends State{
    ReadyState(Zarizeni zarizeni) {
        super(zarizeni);
    }

    @Override
    public String turnOn() {
        return "already on";
    }

    @Override
    public String turnOff() {
        zarizeni.changeState(new OffState(zarizeni));
        return "Turned off";
    }

    @Override
    public String run() {
        zarizeni.changeState(new RunningState(zarizeni));
        return "running";
    }
}

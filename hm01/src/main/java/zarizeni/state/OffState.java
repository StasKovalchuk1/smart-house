package zarizeni.state;

import zarizeni.Zarizeni;

public class OffState extends State{
    public OffState(Zarizeni zarizeni) {
        super(zarizeni);
    }

    @Override
    public String turnOn() {
        zarizeni.changeState(new ReadyState(zarizeni));
        return "it's ready to work";
    }

    @Override
    public String turnOff() {
        return "it's already off";
    }

    @Override
    public String run() {
        return "Off.. You need to turn it on";
    }
}

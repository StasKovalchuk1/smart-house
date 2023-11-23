package zarizeni.state;

import zarizeni.Zarizeni;

public abstract class State {

    Zarizeni zarizeni;

    State(Zarizeni zarizeni) {
        this.zarizeni = zarizeni;
    }

    public abstract String turnOn();
    public abstract String turnOff();
    public abstract String run();
}

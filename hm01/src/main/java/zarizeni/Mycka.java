package zarizeni;

import zarizeni.state.OffState;
import zarizeni.state.State;

public class Mycka implements Zarizeni {

    public Mycka(){
        state = new OffState();
    }
//    @Override
    public String getName() {
        return "mycka";
    }
}

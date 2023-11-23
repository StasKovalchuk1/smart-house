package zarizeni;

import zarizeni.state.OffState;
import zarizeni.state.State;

public interface Zarizeni {
     State state;
     int sportrebaElectriny;
     int sportrebaPlynu;
     int sportrebaVody;

//    public Zarizeni() {
//        this.state = new OffState(this);
//    }

//    public abstract String getName();
//
//    public String generateEvent() {
//        return "x";
//    }
//
//    public void changeState(State state) {
//        this.state = state;
//    }
//
//    public State getState() {
//        return state;
//    }
//    public int getSportrebaElectriny() {
//        return sportrebaElectriny;
//    }
//
//    public void setSportrebaElectriny(int sportrebaElectriny) {
//        this.sportrebaElectriny = sportrebaElectriny;
//    }
//
//    public int getSportrebaPlynu() {
//        return sportrebaPlynu;
//    }
//
//    public void setSportrebaPlynu(int sportrebaPlynu) {
//        this.sportrebaPlynu = sportrebaPlynu;
//    }
//
//    public int getSportrebaVody() {
//        return sportrebaVody;
//    }
//
//    public void setSportrebaVody(int sportrebaVody) {
//        this.sportrebaVody = sportrebaVody;
//    }
}

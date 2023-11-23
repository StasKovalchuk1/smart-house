import zarizeni.Zarizeni;
import zarizeni.ZarizeniFactory;
import zarizeni.state.OffState;
import zarizeni.state.State;

public class Main {
    public static void main(String[] args) {
        ZarizeniFactory zarizeniFactory = new ZarizeniFactory();
        Zarizeni pracka = zarizeniFactory.createZarizeni("pracka");
        Zarizeni mycka = zarizeniFactory.createZarizeni("mycka");


        System.out.println(pracka.getState().turnOn());
        System.out.println(pracka.getState().run());

        System.out.println(mycka.getState().run());
        System.out.println(mycka.getState().turnOn());
        System.out.println(mycka.getState().run());
    }
}

package zarizeni;

public class ZarizeniFactory {

    public Zarizeni createZarizeni(String zarizeni) {
        if (zarizeni == null || zarizeni.isEmpty()) {
            return null;
        }
        switch (zarizeni) {
            case "pracka":
                return new Pracka();
            case "mycka":
                return new Mycka();
            default:
                throw new IllegalArgumentException("Unknown zarizeni");
        }
    }
}

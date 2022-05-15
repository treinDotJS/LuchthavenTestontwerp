public class Vliegtuig {
    private String naam;
    private int tegenwind, passagiers;
    private boolean isNederlands;
    private Lading lading;

    public Vliegtuig(String naam, int tegenwind, int passagiers, boolean isNederlands, Lading lading) {
        this.naam = naam;
        this.tegenwind = tegenwind;
        this.passagiers = passagiers;
        this.isNederlands = isNederlands;
        this.lading = lading;
    }

    public boolean opstijgen(Luchthaven luchthaven) {
        return true;
    }

    private boolean vraagToestemming(Verkeerstoren verkeerstoren) {
        return verkeerstoren.geefAntwoord();
    }

    private int meetTegenWind(int tegenwind) {
        this.tegenwind = tegenwind;
        return this.tegenwind;
    }

    public void landen(Luchthaven luchthaven) {

    }
}

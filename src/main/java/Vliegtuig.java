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
        boolean toestemming = this.vraagToestemming(luchthaven.getVerkeerstoren());
        boolean goedGewicht = this.lading.getGewicht() <= 1000;
        boolean voldoendeTegenwind = this.tegenwind > 50;

        return toestemming && (goedGewicht || voldoendeTegenwind);
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

    public double getLandenPrijs() {
        double prijs = 0.0;
        prijs += getLandenPrijsOpGewicht();
        if (this.passagiers > 2) prijs *= 1.5;
        if (this.lading.getAfhandelenDoorHaven()) prijs += 800;
        if (this.isNederlands) prijs *= 1.21;
        return prijs;
    }

    public int getLandenPrijsOpGewicht() {
        int gewicht = this.lading.getGewicht();
        if (gewicht < 1000) return 100;
        if (gewicht < 5000) return 500;
        return 2500;
    }
}

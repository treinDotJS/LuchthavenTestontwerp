public class Luchthaven {
    private String naam;
    private Verkeerstoren verkeerstoren;

    public Luchthaven(String naam) {
        this.naam = naam;
        this.verkeerstoren = new Verkeerstoren();
    }

    public String getNaam() {
        return naam;
    }

    public Verkeerstoren getVerkeerstoren() {
        return verkeerstoren;
    }

    public double berekenLandingsPrijs(Vliegtuig vliegtuig) {
        return  0.0;
    }
}

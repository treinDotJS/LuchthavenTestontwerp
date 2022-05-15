public class Lading {
    private int gewicht;
    private boolean afhandelenDoorHaven;

    public Lading(int gewicht, boolean afhandelenDoorHaven) {
        this.gewicht = gewicht;
        this.afhandelenDoorHaven = afhandelenDoorHaven;
    }

    public int getGewicht() {
        return gewicht;
    }

    public boolean getAfhandelenDoorHaven() {
        return afhandelenDoorHaven;
    }
}

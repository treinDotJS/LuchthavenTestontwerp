import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VliegtuigTest {
    private Vliegtuig vliegtuig;
    private Luchthaven luchthaven;

    @Test
    void opstijgenTestGeenToestemmingGoedGewichtOnvoldoendeTegenwind(){
        //Arrange
        boolean expected = false;
        vliegtuig = new Vliegtuig("Cessna 172", 50, 2, false, new Lading(1000, false));
        luchthaven = new Luchthaven("Schiphol");
        luchthaven.getVerkeerstoren().setGeeftToestemming(false);

        //Act
        boolean actual = vliegtuig.opstijgen(luchthaven);

        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void opstijgenTestWelToestemmingSlechtGewichtOnvoldoendeTegenwind(){
        //Arrange
        boolean expected = false;
        vliegtuig = new Vliegtuig("Cessna 172", 50, 2, false, new Lading(1001, false));
        luchthaven = new Luchthaven("Schiphol");
        luchthaven.getVerkeerstoren().setGeeftToestemming(true);

        //Act
        boolean actual = vliegtuig.opstijgen(luchthaven);

        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void opstijgenTestWelToestemmingGoedGewichtOnvoldoendeTegenwind(){
        //Arrange
        boolean expected = true;
        vliegtuig = new Vliegtuig("Cessna 172", 50, 2, false, new Lading(1000, false));
        luchthaven = new Luchthaven("Schiphol");
        luchthaven.getVerkeerstoren().setGeeftToestemming(true);

        //Act
        boolean actual = vliegtuig.opstijgen(luchthaven);

        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void opstijgenTestWelToestemmingSlechtGewichtVoldoendeTegenwind(){
        //Arrange
        boolean expected = true;
        vliegtuig = new Vliegtuig("Cessna 172", 51, 2, false, new Lading(1001, false));
        luchthaven = new Luchthaven("Schiphol");
        luchthaven.getVerkeerstoren().setGeeftToestemming(true);

        //Act
        boolean actual = vliegtuig.opstijgen(luchthaven);

        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getLandenPrijsOpGewicht999kg() {
        //Arrange
        int expected = 100;
        vliegtuig = new Vliegtuig("Cessna 172", 51, 2, false, new Lading(999, false));

        //Act
        int actual = vliegtuig.getLandenPrijsOpGewicht();

        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void getLandenPrijsOpGewicht1000kg() {
        //Arrange
        int expected = 500;
        vliegtuig = new Vliegtuig("Cessna 172", 51, 2, false, new Lading(1000, false));

        //Act
        int actual = vliegtuig.getLandenPrijsOpGewicht();

        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void getLandenPrijsOpGewicht1001kg() {
        //Arrange
        int expected = 500;
        vliegtuig = new Vliegtuig("Cessna 172", 51, 2, false, new Lading(1001, false));

        //Act
        int actual = vliegtuig.getLandenPrijsOpGewicht();

        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void getLandenPrijsOpGewicht4999kg() {
        //Arrange
        int expected = 500;
        vliegtuig = new Vliegtuig("Cessna 172", 51, 2, false, new Lading(4999, false));

        //Act
        int actual = vliegtuig.getLandenPrijsOpGewicht();

        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void getLandenPrijsOpGewicht5000kg() {
        //Arrange
        int expected = 2500;
        vliegtuig = new Vliegtuig("Cessna 172", 51, 2, false, new Lading(5000, false));

        //Act
        int actual = vliegtuig.getLandenPrijsOpGewicht();

        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void getLandenPrijsOpGewicht5001kg() {
        //Arrange
        int expected = 2500;
        vliegtuig = new Vliegtuig("Cessna 172", 51, 2, false, new Lading(5001, false));

        //Act
        int actual = vliegtuig.getLandenPrijsOpGewicht();

        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getLandenPrijs999kg2PassagiersWelBagageAfhandelenWelNederlands() {
        //Arrange
        double expected = 1089;
        vliegtuig = new Vliegtuig("Cessna 172", 51, 2, true, new Lading(999, true));

        //Act
        double actual = vliegtuig.getLandenPrijs();

        //Assert
        Assertions.assertEquals(expected, actual, 0.0001);
    }
    @Test
    void getLandenPrijs999kg3PassagiersNietBagageAfhandelenNietNederlands() {
        //Arrange
        double expected = 150;
        vliegtuig = new Vliegtuig("Cessna 172", 51, 3, false, new Lading(999, false));

        //Act
        double actual = vliegtuig.getLandenPrijs();

        //Assert
        Assertions.assertEquals(expected, actual, 0.0001);
    }
    @Test
    void getLandenPrijs1000kg2PassagiersNietBagageAfhandelenWelNederlands() {
        //Arrange
        double expected = 605;
        vliegtuig = new Vliegtuig("Cessna 172", 51, 2, true, new Lading(1000, false));

        //Act
        double actual = vliegtuig.getLandenPrijs();

        //Assert
        Assertions.assertEquals(expected, actual, 0.0001);
    }
    @Test
    void getLandenPrijs4999kg3PassagiersWelBagageAfhandelenNietNederlands() {
        //Arrange
        double expected = 1550;
        vliegtuig = new Vliegtuig("Cessna 172", 51, 3, false, new Lading(4999, true));

        //Act
        double actual = vliegtuig.getLandenPrijs();

        //Assert
        Assertions.assertEquals(expected, actual, 0.0001);
    }
    @Test
    void getLandenPrijs5000kg2PassagiersWelBagageAfhandelenNietNederlands() {
        //Arrange
        double expected = 3300;
        vliegtuig = new Vliegtuig("Cessna 172", 51, 2, false, new Lading(5000, true));

        //Act
        double actual = vliegtuig.getLandenPrijs();

        //Assert
        Assertions.assertEquals(expected, actual, 0.0001);
    }
    @Test
    void getLandenPrijs5000kg3PassagiersNietBagageAfhandelenWelNederlands() {
        //Arrange
        double expected = 4537.5;
        vliegtuig = new Vliegtuig("Cessna 172", 51, 3, true, new Lading(5000, false));

        //Act
        double actual = vliegtuig.getLandenPrijs();

        //Assert
        Assertions.assertEquals(expected, actual, 0.0001);
    }
}


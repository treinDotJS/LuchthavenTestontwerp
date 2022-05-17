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
}


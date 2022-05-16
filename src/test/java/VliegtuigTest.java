import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

        //Arrange
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

        //Arrange
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

        //Arrange
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

        //Arrange
        Assertions.assertEquals(expected, actual);
    }
}


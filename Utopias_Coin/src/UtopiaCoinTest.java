import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtopiaCoinTest {


    private UtopiaCoin utopiaCoinUnderTest;


    @BeforeEach
    void setUp() {
        utopiaCoinUnderTest = new UtopiaCoin();
    }

    @Test
    void minValueForZero(){
        assertEquals(0, utopiaCoinUnderTest.findMinimumCoinsToValue(0));
    }

    @Test
    void minValueCoinForSingleCoins(){
        assertEquals(1,utopiaCoinUnderTest.findMinimumCoinsToValue(1));
        assertEquals(1,utopiaCoinUnderTest.findMinimumCoinsToValue(7));
        assertEquals(1,utopiaCoinUnderTest.findMinimumCoinsToValue(10));
        assertEquals(1,utopiaCoinUnderTest.findMinimumCoinsToValue(22));
    }


    @Test
    void minValueCoinForComplicatedValues(){
        assertEquals(3,utopiaCoinUnderTest.findMinimumCoinsToValue(15));
        assertEquals(3,utopiaCoinUnderTest.findMinimumCoinsToValue(18));
        assertEquals(3,utopiaCoinUnderTest.findMinimumCoinsToValue(21));
        assertEquals(3,utopiaCoinUnderTest.findMinimumCoinsToValue(24));
        assertEquals(3,utopiaCoinUnderTest.findMinimumCoinsToValue(30));
        assertEquals(3,utopiaCoinUnderTest.findMinimumCoinsToValue(3));
        assertEquals(3,utopiaCoinUnderTest.findMinimumCoinsToValue(66));

    }




}
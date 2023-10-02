package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {
    @Test
    void testMultiplication(){
        Money five= Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));

        Money fivef= Money.franc(5);
        assertEquals(Money.franc(10), fivef.times(2));
        assertEquals(Money.franc(15), fivef.times(3));
    }

    @Test
    void testEqualityFranc(){
        assertEquals(false,Money.franc(1).equals(Money.franc(2)));
        assertEquals(true,Money.franc(1).equals(Money.franc(1)));
    }

    @Test
    void testCurrency(){
        assertEquals("USD",Money.dollar(1).currency());
        assertEquals("CHF",Money.franc(1).currency());
    }

    @Test
    void testAddition(){
        Money five=Money.dollar(5);
        Expression sum=five.plus(five);
        Bank bank=new Bank();
        Money reduced= bank.reduce(sum,"USD");
        assertEquals(Money.dollar(10),reduced);

    }



}

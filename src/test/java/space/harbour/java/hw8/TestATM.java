package space.harbour.java.hw8;
import org.junit.*;
import java.util.*;
import junit.framework.TestCase;
public class TestATM extends TestCase
{
    ATM atm;

    @Before
    public void setUp() throws Exception
    {
        super.setUp();
        atm = new ATM();
    }

    @Test
    public void testWithdrawalException()
    {

        assertEquals("Amount should be multiple of 5.",atm.withdraw(533));
    }
    @Test
    public void testWithdraw()
    {
        assertEquals("8 50 Eur note(s) being Dispensing \n",atm.withdraw(400));
    }

}

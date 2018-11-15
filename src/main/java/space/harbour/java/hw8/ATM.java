package space.harbour.java.hw8;
public class ATM
{
    private static FiftyEuro fiftyEurohandler = new FiftyEuro();
    private static TwentyEuro   twentyEurohandler   = new TwentyEuro();
    private static TenEuro  tenEurohandler  = new TenEuro();
    private static FiveEuro    fiveEurohandler    = new FiveEuro();

    static
    {

        fiftyEurohandler.setNext(twentyEurohandler);
        twentyEurohandler.setNext(tenEurohandler);
        tenEurohandler.setNext(fiveEurohandler);
    }

    public String withdraw( long requestedAmount )
    {

       String x=fiftyEurohandler.dispenseCash(requestedAmount);
       return x;
    }
    public static void main(String[] args)
    {
            ATM atm = new ATM();
            String x= atm.withdraw(400);
          //  System.out.println(x);
    }

}




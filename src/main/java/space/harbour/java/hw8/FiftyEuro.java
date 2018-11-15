package space.harbour.java.hw8;

public class FiftyEuro implements CashHandler
{

    private CashHandler handler;
    @Override
    public String dispenseCash(long requestedAmount)
    {
        if (requestedAmount % 5 != 0)
            {
                System.out.println("Amount should be multiple of 5.");
                return "Amount should be multiple of 5." ;
             }
         else
             {


                if (requestedAmount >= 50)
                    {
                    long num = requestedAmount / 50;
                    long remainder = requestedAmount % 50;
                    System.out.println(num + " 50 Eur note(s) being Dispensing \n");

                    if (remainder != 0)
                        {
                        this.handler.dispenseCash(remainder);

                        }
                        return num + " 50 Eur note(s) being Dispensing \n";
                    }
                else
                    {
                    this.handler.dispenseCash(requestedAmount);
                       return "Passing to next Handler \n";
                    }
            }

    }
    @Override
    public void setNext(CashHandler next)
    {
        this.handler=next;

    }

}
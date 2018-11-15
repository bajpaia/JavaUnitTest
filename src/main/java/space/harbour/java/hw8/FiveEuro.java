package space.harbour.java.hw8;

public class FiveEuro implements CashHandler
{
    private CashHandler handler;
    @Override
    public String dispenseCash(long requestedAmount)
    {
        if(requestedAmount >= 5)
        {
            long num = requestedAmount/5;
            long remainder = requestedAmount % 5;
            System.out.println(num+" 5 Eur note(s) being Dispensing \n");
            if(remainder !=0) this.handler.dispenseCash(remainder);
            return num + " 5 Eur note(s) being Dispensing \n";
        }
        else
            {
                return "Request Cannot be processed \n";
            }

    }
    @Override
    public void setNext(CashHandler next)
    {
        this.handler=next;

    }

}

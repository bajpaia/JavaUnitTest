package space.harbour.java.hw8;

public class TenEuro implements CashHandler
{
    private CashHandler handler;
    @Override
    public String dispenseCash(long requestedAmount)
    {
        if(requestedAmount >= 10)
        {
            long num = requestedAmount/10;
            long remainder = requestedAmount % 10;
            System.out.println(num+" 10 Eur note(s) being Dispensing \n");
            if(remainder !=0) this.handler.dispenseCash(remainder);
            return num + " 10 Eur note(s) being Dispensing \n";
        }else{
            this.handler.dispenseCash(requestedAmount);
            return  "Passing to next Handler \n";
        }

    }
    @Override
    public void setNext(CashHandler next)
    {
        this.handler=next;

    }


}

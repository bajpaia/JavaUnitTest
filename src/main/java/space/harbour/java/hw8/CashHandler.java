package space.harbour.java.hw8;

public interface CashHandler
{
    void setNext(CashHandler next);
    String dispenseCash( long requestedAmount );

}





package AWS;

/**
 *
 * @author Sraboni
 */
public class DonationAppeal 
{
    private double amount;
    private String cause;
    private String spUsername;
    
    public DonationAppeal(double amount, String cause, String spUsername)
    {
        this.amount = amount;
        this.cause = cause;
        this.spUsername = spUsername;
    }
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount)
    {
        this.amount = amount;
    }
    public String getCause()
    {
        return cause;
    }
    public void setCause(String cause)
    {
        this.cause = cause;
    }
    public String getServiceProvider(){
        return spUsername;
    }
    public void setServiceProvider(String spUsername){
        this.spUsername = spUsername;
    }
    @Override
    public String toString() {
        return "\n"+amount + "|" + cause + "|" + spUsername;
    }
}
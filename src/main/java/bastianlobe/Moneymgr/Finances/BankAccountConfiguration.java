package bastianlobe.Moneymgr.Finances;

public class BankAccountConfiguration {
    public final boolean AllowNegativeBalance;

    public BankAccountConfiguration(boolean allowNegativeBalance){
        this.AllowNegativeBalance = allowNegativeBalance;
    }
}

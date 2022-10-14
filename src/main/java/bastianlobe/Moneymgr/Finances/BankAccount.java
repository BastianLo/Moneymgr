package bastianlobe.Moneymgr.Finances;

import bastianlobe.Moneymgr.User.User;
import lombok.Getter;

import java.util.UUID;

public class BankAccount {

    private final UUID id = UUID.randomUUID();

    @Getter
    private double balance;

    private final User owner;

    private final BankAccountConfiguration bankAccountConfiguration;

    public BankAccount(BankAccountConfiguration bankAccountConfiguration, User owner){
        this.bankAccountConfiguration = bankAccountConfiguration;
        this.owner = owner;
    }

    public void Withdraw(double amount) throws Exception {
        if(balance - amount < 0 && !bankAccountConfiguration.AllowNegativeBalance)
            throw new Exception(String.format("Balance for Account %s can not be less than 0", id));
        balance -= amount;
    }

    public void Deposit(double amount){
        balance += amount;
    }

    public void Transfer(double amount, BankAccount destination) throws Exception {
        Withdraw(amount);
        destination.Deposit(amount);
    }

}

package bastianlobe.Moneymgr.Finances

import bastianlobe.Moneymgr.User.User
import spock.lang.Specification

class BankAccountSpec extends Specification{

    def 'Test BankAccount deposit & withdrawal'(){
        given:
        BankAccount bankAccount = new BankAccount(new BankAccountConfiguration(false), new User())
        bankAccount.Deposit(500)

        when:
        bankAccount.Withdraw(200)

        then:
        300d == bankAccount.balance
    }

    def 'Test BankAccount with value less than 0 and no negative balance allowed'(){
        given:
        BankAccount bankAccount = new BankAccount(new BankAccountConfiguration(false), new User())
        bankAccount.Deposit(100)

        when:
        bankAccount.Withdraw(200)

        then:
        thrown(Exception)
    }
    def 'Test BankAccount with value less than 0 and negative balance allowed'(){
        given:
        BankAccount bankAccount = new BankAccount(new BankAccountConfiguration(true), new User())
        bankAccount.Deposit(100)

        when:
        bankAccount.Withdraw(200)

        then:
        thrown(Exception)
    }

    def 'Test BankAccount transfer'(){
        given:
        BankAccount bankAccount1 = new BankAccount(new BankAccountConfiguration(false), new User())
        bankAccount1.Deposit(100)
        BankAccount bankAccount2 = new BankAccount(new BankAccountConfiguration(false), new User())
        bankAccount2.Deposit(100)

        when:
        bankAccount1.Transfer(100, bankAccount2)

        then:
        0d == bankAccount1.balance
        200d == bankAccount2.balance
    }
    def 'Test BankAccount transfer with invalid amount'(){
        given:
        BankAccount bankAccount1 = new BankAccount(new BankAccountConfiguration(false), new User())
        bankAccount1.Deposit(100)
        BankAccount bankAccount2 = new BankAccount(new BankAccountConfiguration(false), new User())
        bankAccount2.Deposit(100)

        when:
        bankAccount1.Transfer(200, bankAccount2)

        then:
        thrown(Exception)
        100d == bankAccount1.balance
        100d == bankAccount2.balance
    }

}

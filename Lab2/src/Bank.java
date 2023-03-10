
import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Project: Lab 2
Purpose Details: Threading Synchronization
Course: IST 411
Author: Group 2 (Aurora Blasko Drabik, Jang Won Cho, Tyler Cullen, Kaelynn Davies, Ian Gwillim, Andrew Kochhar, Ryan Waitlevertch)
Date Developed: 1/25/2023
Last Date Changed:1/25/2023
Revision: 1
*/
public class Bank {
    private final double[] accounts;
    private Lock bankLock = new ReentrantLock();
    private Condition sufficientFunds = bankLock.newCondition();
    
    /**
     * Constructs the bank.
     * @param n the number of accounts
     * @param initialBalance the initial balance for each account
     */
    public Bank(int n, double initialBalance)  {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }
    
    /**
     * Transfers money from one account to another if sufficient funds are available in the account to be taken from, if not the thread waits until the sufficient funds condition is satisfied.
     * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     * @throws java.lang.InterruptedException
     */
    public void transfer(int from, int to, double amount) throws InterruptedException {
        
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signal();
        } finally {
            bankLock.unlock();
        }
    }
    
    /**
     * Gets the sum of all account balances.
     * @return the total balance
     */
    public double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0;
            for (double a : accounts) {
                sum += a;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }
    /**
      * Gets the number of accounts in the bank.
      * @return the number of accounts
      */
    public int size() {
        return accounts.length;
    }
}
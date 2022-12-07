package org.bank;

import akka.actor.AbstractActor;

public class BankAccount extends AbstractActor {
    private int balance;

    public BankAccount() {
        this.balance = 100;
        System.out.println("Bank account initialised with £100");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(DepositMessage.class, this::onDeposit)
                .match(WithdrawMessage.class, this::onWithdraw)
                .build();
    }

    public void onDeposit(DepositMessage msg) {
        System.out.printf("Depositing: £%d%n", msg.amount);
        this.balance += msg.amount;
        System.out.printf("New balance: £%d%n", this.balance);
    }

    public void onWithdraw(WithdrawMessage msg) {
        System.out.printf("Withdrawing: £%d%n", msg.amount);
        this.balance += msg.amount;
        System.out.printf("New balance: £%d%n", this.balance);
    }
}

package org.bank.messages;

public class WithdrawMessage {
    public final int iteration;
    public final int amount;

    public WithdrawMessage(int iteration, int amount) {
        this.iteration = iteration;
        this.amount = amount;
    }
}

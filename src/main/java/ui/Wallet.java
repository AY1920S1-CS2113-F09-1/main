package ui;

import java.util.HashMap;

public class Wallet {
    private Double balance;
    private ReceiptTracker receipts;

    /**
     * Complete Constructor for Wallet Object.
     * @param balance Double to be set for balance property of Wallet Object
     * @param receipts ArrayList to be set for receipts property of Wallet Object
     */
    public Wallet(Double balance, ReceiptTracker receipts) {
        this.setBalance(balance);
        this.setReceipts(receipts);
    }

    /**
     * Partial Constructor for Wallet Object.
     * @param balance Double to be set for balance property of Wallet Object
     */
    public Wallet(Double balance) {
        this.setBalance(balance);
        this.setReceipts(new ReceiptTracker());
    }

    /**
     * Default Constructor for Wallet Object.
     */
    public Wallet() {
        this.setBalance(0.00);
        this.setReceipts(new ReceiptTracker());
    }

    /**
     * Adds a new Receipt Object into the receipts property of Wallet Object.
     * @param receipt Receipt Object to be stored
     */
    public void addReceipt(Receipt receipt) {
        this.receipts.addReceipt(receipt);
    }

    // -- Boolean Functions

    /**
     * Checks if the Wallet contains any receipts.
     * @return true if receipts property is an empty list, false otherwise
     */
    public Boolean isReceiptsEmpty() {
        return this.getReceipts().isEmpty();
    }

    // -- Setters & Getters
    /**
     * Setter for balance property of Wallet Object.
     * @param input The value to be set as balance
     */
    public void setBalance(Double input) {
        this.balance = input;
    }

    /**
     * Getter for balance property of Wallet Object.
     * @return Double value corresponding to balance property in Wallet Object
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * Setter for receipts property of Wallet Object.
     * @param receipts ArrayList of receipts property of Wallet Object
     */
    public void setReceipts(ReceiptTracker receipts) {
        this.receipts = receipts;
    }

    /**
     * Getter for receipts property of Wallet Object.
     * @return ArrayList of receipts property in Wallet Object
     */
    public ReceiptTracker getReceipts() {
        return this.receipts;
    }

    /**
     * Getter for the totalCashSpent property of the ReceiptTracker Object housed in the Wallet Object.
     * @return Double representing the total cash spent as recorded by the ReceiptTracker
     */
    public double getTotalExpenses() {
        return this.receipts.getTotalCashSpent();
    }

    /**
     * Getter for the folders property of the ReceiptTracker Object housed in the Wallet Object.
     * @return HashMap representing keys and the corresponding ReceiptTracker object
     */
    public HashMap<String, ReceiptTracker> getFolders() {
        return this.receipts.getFolders();
    }
}

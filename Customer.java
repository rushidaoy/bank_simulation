package assg7_Whitaker;

public class Customer {
	
	/**
	 * arrivalTime is the time a given customer arrived at the bank.
	 */
	private int arrivalTime;
	
	/**
	 * transactionLength is the duration a customer's transaction will take.
	 */
	private int transactionLength;
	
	public Customer(int arrivalTime, int transactionLength){
		this.arrivalTime = arrivalTime;
		this.transactionLength = transactionLength;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getTransactionLength() {
		return transactionLength;
	}
	public void setTransactionLength(int transactionLength) {
		this.transactionLength = transactionLength;
	}
	
	public String toString(){
		return "arrival time: " + arrivalTime + ", transaction length: " + transactionLength;
	}
	
}

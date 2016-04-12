package assg7_Whitaker;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author Justin Whitaker <whitakerj14@students.ecu.edu>
 * 
 * Simulate simulates customers arriving at a bank that can only serve 1 customer at a time.
 * It simulates them waiting in a line and calculates the average wait time.
 *
 */

public class Simulate {



	public static void main(String[] args) {
		
		int time;
		Queue<Customer> customerList = new LinkedList<Customer>();
		Queue<Customer> bankQueue = new LinkedList<Customer>();
		LinkedList<Integer> waitTimes = new LinkedList<Integer>();
		
		time = 0;
		int customerCount = 0;

		String filename = "input.txt";
		File arrivalFile = new File(filename);
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(arrivalFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(inputStream.hasNext()){
			Customer newCustomer = new Customer(inputStream.nextInt(), inputStream.nextInt());
			customerList.add(newCustomer);
			customerCount++;
		}
		inputStream.close();
		
		bankQueue.add(customerList.poll());
		time = bankQueue.peek().getArrivalTime();
		System.out.println("Customer arrived at time " + time);
		
		while(!customerList.isEmpty() || !bankQueue.isEmpty()){
			if(bankQueue.isEmpty()){
				bankQueue.add(customerList.poll());
				time = bankQueue.peek().getArrivalTime();
				System.out.println("Customer arrived at time " + time);
			}
			Customer currentCustomer = bankQueue.poll();
			while(!customerList.isEmpty() && customerList.peek().getArrivalTime() < time + currentCustomer.getTransactionLength()){
				Customer newWaitingCustomer = customerList.poll();
				bankQueue.add(newWaitingCustomer);
				System.out.println("Customer arrived at time " + newWaitingCustomer.getArrivalTime());
			}
			waitTimes.add(time-currentCustomer.getArrivalTime());
			time = time + currentCustomer.getTransactionLength();
			System.out.println("Customer departed at time " + time);
		}
		
		System.out.println();
		
		int totalWaitTime = 0;
		for(int i : waitTimes){
			totalWaitTime += i;
		}
		double avgWaitTime = (double) totalWaitTime / customerCount;
		System.out.println("Total number of customers: "+ customerCount);
		System.out.println("Average wait time: " + avgWaitTime);

	}

}

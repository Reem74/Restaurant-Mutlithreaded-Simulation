import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {
	int customersNumber, tables;
	Customer customers[];
	public static Queue<Integer> emptyTables;

	public Restaurant(int tableNumbers, int countCustomer, String names[]) {
		Customer.init(tableNumbers);
		tables = tableNumbers;
		customersNumber = countCustomer;
		customers = new Customer[customersNumber];
		emptyTables = new LinkedList<>();
		for (int i = 1; i <= tableNumbers; i++) {
			emptyTables.add(i);
		}
		for (int i = 0; i < customersNumber; i++) {
			customers[i] = new Customer();
			customers[i].name = names[i];
		}
	}

	public void run() {
		for (int i = 0; i < customersNumber; i++) {
			System.out.println(customers[i].name + " Arrived");
			customers[i].start();
		}
	}
}

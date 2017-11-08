
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is number of Tables?");
		int tablesNumber = scanner.nextInt();

		System.out.println("Number of Customers :");
		int customresNumber = scanner.nextInt();
		System.out.println("Customer's names:");
		String customres[] = new String[customresNumber + 1];
		for (int i = 0; i < customresNumber; i++) {
			customres[i] = scanner.next();
		}
		Restaurant resturant = new Restaurant(tablesNumber, customresNumber, customres);
		resturant.run();
		scanner.close();
	}
}

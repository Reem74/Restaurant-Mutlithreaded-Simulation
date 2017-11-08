
public class Customer extends Thread {
	private static Semaphore tables;
	private static Semaphore dishes;
	public String name;
	public int sittingTable;

	public static void init(int c) {
		tables = new Semaphore(c);
		dishes= new Semaphore(1);
	}

	public void run() {
		try {
			tables.P();
			sittingTable = Restaurant.emptyTables.poll();
			System.out.println("Table " + sittingTable + ": " + name + " Sit down");
			sleep(1000);
			System.out.println("Table " + sittingTable + ": " + name + " Order Food");
			sleep(1000);
			dishes.P();
			System.out.println("Table " + sittingTable + ": " + name + " Eat from the dish");
			dishes.V();
			sleep(1000);
			System.out.println("Table " + sittingTable + ": " + name + " Leave");
			Restaurant.emptyTables.add(sittingTable);
			tables.V();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
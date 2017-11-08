
class Semaphore {
	private int value = 0;

	public Semaphore(int initial) {
		value = initial;
	}

	public synchronized void P() {
		while (value <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		value--;
	}

	public synchronized void V() {
		value++;
		notify();
	}
}
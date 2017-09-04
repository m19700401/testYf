package thread_THreadLocal;

public class MyApp {

	public static void main(String[] args) {

		MyRunnable runnable = new MyRunnable();
		Thread thread = new Thread(runnable);
		thread.start();

		for (int i = 0; i < 500; i++) {
			System.out.print('+');
		}

	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
			System.out.print('*');
		}
	}
}

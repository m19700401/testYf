package thread_THreadLocal;

//Thread

//class MyRunnable implements Runnable { // 関数型インターフェース
//@Override
//public void run() {
//  for (int i = 0; i < 500; i++) {
//    System.out.print('*');
//  }
//}
//}

public class MyApp {

	public static void main(String[] args) {
		// MyRunnable r = new MyRunnable();
		// Thread t = new Thread(r);
		// t.start();

		// ラムダ式
		// (引数) -> {処理}
		// new Thread(new Runnable() {
		// @Override
		// public void run() {
		// for (int i = 0; i < 500; i++) {
		// System.out.print('*');
		// }
		// }
		// }).start();
		new Thread(() -> {
			for (int i = 0; i < 500; i++) {
				System.out.print('*');
			}
		}).start();

		for (int i = 0; i < 500; i++) {
			System.out.print('.');
		}
	}

}
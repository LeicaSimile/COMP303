package exercise01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {

	public static void main(String[] args) {
		ExecutorService tasks = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			tasks.execute(new CoinFlipper());
		}
	}

}

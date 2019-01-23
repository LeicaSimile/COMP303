package exercise02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;

public class CoinFlipper implements Runnable {
	
	public CoinFlipper() {
		ExecutorService tasks = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			tasks.execute(this);
		}
	}

	@Override
	public void run() {
		int headCount = 0;
		for (int i = 0; i < 1000; i++) {
			String result = this.flip();
			// For debugging:
			// System.out.printf("%s: %s%n", this.getName(), result);
			
			if (result.equals("heads")) {
				headCount++;
				if (headCount == 3) {
					System.out.printf("%s flipped heads 3x in a row.%n", this.getName());
					headCount = 0;
				}
			}
		}
	}
	
	public String flip() {
		if (new Random().nextBoolean()) {
			return "heads";
		} else {
			return "tails";
		}
	}
	
	public String getName() {
		return Thread.currentThread().getName();
	}
	
}
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Driver {

	public static void main(String[] args) {
		// Attributes
		int key[] = new int[50];
		char value[] = new char[50];
		long startTime, endTime, total;

		// Random object
		Random r = new Random();

		// Three different probings
		LinearProbing lp = new LinearProbing(100);
		QuadraticProbing qp = new QuadraticProbing(100);
		SeparateChaining sc = new SeparateChaining(100);

		// Generating 50 key and values
		System.out.println("GENERATING 50 KEYS AND VALUES.........");
		for (int i = 0; i < 50; i++) {
			key[i] = r.nextInt((1000 - 0) + 1) + 0;
			value[i] = (char) (r.nextInt(26) + 'a');
		}

		System.out.println();

		// Using put on each pair
		System.out.println("*************** PUT 50 TIMES ****************");
		System.out.println("");

		for (int i = 0; i < 50; i++) {

			System.out.println("============================================");
			// Linear probing
			System.out.println("1) Executing Linear probing.....");
			startTime = System.nanoTime();
			lp.put(key[i], value[i]);
			endTime = System.nanoTime();
			total = endTime - startTime;
			System.out.println("Time taken to execute put(key,value): " + total + "s");

			System.out.println();

			// Quadratic probing
			System.out.println("2) Executing Quadratic probing.....");
			startTime = System.nanoTime();
			qp.put(key[i], value[i]);
			endTime = System.nanoTime();
			total = endTime - startTime;
			System.out.println("Time taken to execute put(key,value): " + total + "s");

			System.out.println();

			// Quadratic probing
			System.out.println("3) Executing SeparateChaining probing.....");
			startTime = System.nanoTime();
			sc.put(key[i], value[i]);
			endTime = System.nanoTime();
			total = endTime - startTime;
			System.out.println("Time taken to execute put(key,value): " + total + "s");
			System.out.println("--------------------------------------------");

			System.out.println();

		}

		// Using put on each pair
		System.out.println("************** GET 50 TIMES ****************");
		System.out.println("");

		for (int i = 0; i < 50; i++) {

			System.out.println("============================================");
			// Linear probing
			System.out.println("1) Executing Linear probing.....");
			startTime = System.nanoTime();
			System.out.println(lp.get(key[i]));
			endTime = System.nanoTime();
			total = endTime - startTime;
			System.out.println("Time taken to execute get(key): " + total + "s");

			System.out.println();

			// Quadratic probing
			System.out.println("2) Executing Quadratic probing.....");
			startTime = System.nanoTime();
			System.out.println(qp.get(key[i]));
			endTime = System.nanoTime();
			total = endTime - startTime;
			System.out.println("Time taken to execute get(key): " + total + "s");

			System.out.println();

			// SeperateChaining
			System.out.println("3) Executing SeparateChaining probing.....");
			startTime = System.nanoTime();
			System.out.println(sc.get(key[i]));
			endTime = System.nanoTime();
			total = endTime - startTime;
			System.out.println("Time taken to execute get(key): " + total + "s");
			System.out.println("--------------------------------------------");

			System.out.println();

		}

		System.out.println();

		// Using put on each pair
		System.out.println("************** REMOVE 25 TIMES ****************");
		System.out.println("");

		for (int i = 0; i < 25; i++) {

			System.out.println("============================================");
			// Linear probing
			System.out.println("1) Executing Linear probing.....");
			startTime = System.nanoTime();
			System.out.println(lp.remove(key[i]));
			endTime = System.nanoTime();
			total = endTime - startTime;
			System.out.println("Time taken to execute remove(key): " + total + "s");

			System.out.println();

			// Quadratic probing
			System.out.println("2) Executing Quadratic probing.....");
			startTime = System.nanoTime();
			System.out.println(qp.remove(key[i]));
			endTime = System.nanoTime();
			total = endTime - startTime;
			System.out.println("Time taken to execute remove(key): " + total + "s");

			System.out.println();

			// SeperateChaining
			System.out.println("3) Executing SeparateChaining probing.....");
			startTime = System.nanoTime();
			System.out.println(sc.remove(key[i]));
			endTime = System.nanoTime();
			total = endTime - startTime;
			System.out.println("Time taken to execute remove(key): " + total + "s");
			System.out.println("--------------------------------------------");

			System.out.println();

		}

		System.out.println();

		// Using put on each pair
		System.out.println("************** GET 50 TIMES ****************");
		System.out.println("");

		for (int i = 0; i < 50; i++) {

			System.out.println("============================================");
			// Linear probing
			System.out.println("1) Executing Linear probing.....");
			startTime = System.nanoTime();
			System.out.println(lp.get(key[i]));
			endTime = System.nanoTime();
			total = endTime - startTime;
			System.out.println("Time taken to execute get(key): " + total + "s");

			System.out.println();

			// Quadratic probing
			System.out.println("2) Executing Quadratic probing.....");
			startTime = System.nanoTime();
			System.out.println(qp.get(key[i]));
			endTime = System.nanoTime();
			total = endTime - startTime;
			System.out.println("Time taken to execute get(key): " + total + "s");

			System.out.println();

			// SeperateChaining
			System.out.println("3) Executing SeparateChaining probing.....");
			startTime = System.nanoTime();
			System.out.println(sc.get(key[i]));
			endTime = System.nanoTime();
			total = endTime - startTime;
			System.out.println("Time taken to execute get(key): " + total + "s");
			System.out.println("--------------------------------------------");

			System.out.println();

		}

		System.out.println();

	}

}

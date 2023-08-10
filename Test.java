import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner fs = new Scanner(System.in);
		int a = fs.nextInt(), b = fs.nextInt();
		int start = 100;
		int end = 200;
		int counted = 0, notCounted = 0;
		for (int x = start; x <= end; x++) {
			int first = (x % a) % b;
			int second = (x % b) % a;
			System.out.println(x + ":");
			System.out.println(x + " mod " + a + " mod " + b + " = " + first);
			System.out.println(x + " mod " + b + " mod " + a + " = " + second);
			if (first != second) {
				System.out.println("counted");
				counted++;
			} else {
				notCounted++;
				System.out.println("not counted");
			}
			System.out.println();
		}
		System.out.println("counted = " + counted);
		System.out.println("not counted = " + notCounted);
		System.out.println((end - start + 1) - notCounted);
		fs.close();
	}
}

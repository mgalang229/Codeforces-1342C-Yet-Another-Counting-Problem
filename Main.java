import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int a = fs.nextInt(), b = fs.nextInt(), q = fs.nextInt();
			long[] l = new long[q];
			long[] r = new long[q];
			for (int i = 0; i < q; i++) {
				l[i] = fs.nextLong();
				r[i] = fs.nextLong();
			}
			int lcm = computeLcm(a, b);
			for (int i = 0; i < q; i++) {
				long sf = l[i] / lcm;
				long ef = r[i] / lcm;
				long s = sf * lcm;
				long e = ef * lcm;
				long notCounted = ((ef - 1) - (sf + 1) + 1) * Math.max(a, b);
				notCounted += Math.min(r[i], e + (Math.max(a, b) - 1)) - e + 1;
				notCounted += Math.max(0, (s + (Math.max(a, b) - 1)) - l[i] + 1);
				long ans = (r[i] - l[i] + 1) - notCounted;
				System.out.print(ans + " ");
			}
			System.out.println();
		}
		out.close();
	}
	
	static int computeLcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
	
	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}

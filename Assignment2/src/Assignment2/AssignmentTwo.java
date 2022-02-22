package Assignment2;

import java.util.*;

public class AssignmentTwo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		// problem 1
		System.out.println("Problem1");
		System.out.println("Enter the size of array:");
		int n = sc.nextInt();
		String[] string = new String[n];

		System.out.println("Enter array element values:");
		for (int i = 0; i < string.length; i++) {
			string[i] = sc.next();
		}
		System.out.println("Input(S1): " + Arrays.toString(string));

		problem1(string);

		// problem2
		System.out.println("\nProblem2");
		System.out.println("Enter the size of array:");
		int n1 = sc.nextInt();
		String[] string2 = new String[n1];
		System.out.println("Enter array element values:");
		for (int i = 0; i < string2.length; i++) {
			string2[i] = sc.next();
		}
		System.out.println("Input(S1): " + Arrays.toString(string2));
		System.out.println("Output (M1):" + problem2(string2));

		// problem 3
		System.out.println("\nProblem3");
		System.out.println("Enter the size of array:");
		int n2 = sc.nextInt();
		int[] p = new int[n2];
		System.out.println("Enter array element values:");
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		System.out.println("Input (A1): " + Arrays.toString(p));
		System.out.println("Output (S):" + problem3(p));

		// problem 4
		System.out.println("\nProblem4");
		System.out.println("Enter the size of array list:");
		int n3 = sc.nextInt();
		ArrayList<String> arraylist = new ArrayList<>();
		System.out.println("Enter array list values:");
		for (int i = 0; i < n3; i++) {
			arraylist.add(sc.next());
		}
		System.out.println("Input(A1): " + arraylist);
		System.out.println("Output (A2):" + problem4(arraylist));

		// problem 5
		System.out.println("\nProblem5");
		System.out.println("Enter the size of array list:");
		int n4 = sc.nextInt();
		ArrayList<String> arraylist2 = new ArrayList<>();
		System.out.println("Enter array list values:");
		for (int i = 0; i < n4; i++) {
			arraylist2.add(sc.next());
		}
		System.out.println("Input: " + arraylist2);
		System.out.println("Output:" + problem5(arraylist2));

		// problem6
		System.out.println("\nProblem6");
		System.out.println("Enter the size of array list:");
		int n5 = sc.nextInt();
		ArrayList<String> arraylist3 = new ArrayList<>();
		System.out.println("Enter array list values:");
		for (int i = 0; i < n5; i++) {
			arraylist3.add(sc.next());
		}
		System.out.println("Input(S1): " + arraylist3);
		System.out.println("Output (M1):" + problem6(arraylist3));
	}

	public static void problem1(String[] s1) {
		Map<String, Integer> m = new HashMap<String, Integer>();

		for (String s : s1) {
			if (m.containsKey(s)) {
				m.compute(s, (k, v) -> v + 1);
			} else {
				m.put(s, 1);
			}
		}
		System.out.println("Output:" + m);
	}

	public static Map<String, String> problem2(String[] s1) {

		Map<String, String> map = new HashMap<String, String>();

		for (String s : s1) {
			String key = "" + s.charAt(0);
			if (map.containsKey(key)) {
				String ns = map.get(key) + s;
				map.put(key, ns);
			} else {
				map.put(key, s);
			}

		}
		return map;

	}

	public static Set<Integer> problem3(int[] a1) {
		Set<Integer> set = new LinkedHashSet<>();
		for (int n : a1) {
			if (set.contains(n)) {
				int newNum = n + 1;
				while (set.contains(newNum)) {
					newNum += 1;
				}
				set.add(newNum);
			} else {
				set.add(n);
			}
		}

		return set;
	}

	public static ArrayList<String> problem4(ArrayList<String> a1) {
		ArrayList<String> alist = new ArrayList<String>();
		a1.forEach(v -> {
			Set<String> s = new LinkedHashSet<String>();
			for (int i = 0; i < v.length(); i++) {
				s.add("" + v.charAt(i));
			}
			alist.add(String.join("", s));
		});

		return alist;

	}

	public static Map<String, String> problem5(ArrayList<String> a) {
		Map<String, String> map = new HashMap<String, String>();

		a.forEach(s -> {
			String key = "" + s.charAt(0);
			String val = "" + s.charAt(s.length() - 1);
			if (map.containsKey(key)) {
				map.compute(key, (k1, v1) -> val);
			} else {
				map.put(key, val);
			}
		});
		return map;

	}

	public static Map<String, Boolean> problem6(ArrayList<String> a) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		a.forEach(s -> {
			if (map.containsKey(s)) {
				map.compute(s, (k, v) -> v + 1);
			} else {
				map.put(s, 1);
			}
		});
		Map<String, Boolean> map2 = new HashMap<String, Boolean>();
		map.forEach((k, v) -> {
			if (v >= 2) {
				map2.put(k, true);
			} else {
				map2.put(k, false);
			}
		});

		return map2;
	}

}

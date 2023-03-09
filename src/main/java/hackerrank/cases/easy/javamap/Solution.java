// https://www.hackerrank.com/challenges/phone-book/problem
package hackerrank.cases.easy.javamap;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		Map<String, Integer> phoneBook = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			int phone = in.nextInt();

			phoneBook.put(name, phone);

			in.nextLine();
		}
		while (in.hasNext()) {
			String s = in.nextLine();
			Optional<Integer> phoneEntry = Optional.ofNullable(phoneBook.get(s));

			System.out.println(phoneEntry.isPresent()
					? String.format("%s=%s", s, phoneEntry.get())
					: "Not found");
		}

	}

}

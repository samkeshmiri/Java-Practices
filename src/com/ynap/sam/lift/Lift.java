package com.ynap.sam.lift;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Lift {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			String input = scanner.nextLine();
			System.out.println(useLift(input));
		}
	}

	public static String useLift(String input) {
		String[] arr = input.split(" ", -1);
		StringBuilder result = new StringBuilder();
		List<Integer> floors = new LinkedList<>();
		Integer currentFloor = Integer.parseInt(arr[0]);
		String direction = arr[1];

		for (int i = 2; i < arr.length; i++) {
			floors.add(Integer.parseInt(arr[i]));
		}

		if (direction.equals("down")) {
			Collections.sort(floors, Collections.reverseOrder());
			Collections.sort(floors, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					if (o1 > currentFloor || o2 > currentFloor) {
						return -1;
					} else {
						return 0;
					}
				}
			});
		} else {
			Collections.sort(floors);
			Collections.sort(floors, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					if (o1 < currentFloor || o2 < currentFloor) {
						return -1;
					} else {
						return 0;
					}
				}
			});
		}

		for (Integer x : floors) {
			result.append(x.toString() + " ");
		}

		return result.toString();
	}
}
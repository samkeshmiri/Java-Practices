package com.ynap.sam.lift;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Lift {
	public static void main(String[] args) {
		StringBuilder input = new StringBuilder();
		try(Scanner scanner = new Scanner(System.in)) {
				System.out.println(scanner.next());
				input.append(scanner.next());
		}
		System.out.println(useLift(input.toString()));
		System.out.println(useLift("7 down 1 3 5 7 12"));	// expected "down" 7 5 3 1 12
		System.out.println(useLift("4 up 2 4 5 7 12"));	// expected "up" 4 5 7 12 2 
		System.out.println(useLift("7 up 12 10 11 9 8 7 6 5 4 3 2 1")); // 7 8 9 10 11 12 6 5 4 3 2 1
	}

	public static String useLift(String input) {
		String[] arr = input.split(",", -1);
		StringBuilder result = new StringBuilder();
		ArrayList<Integer> floors = new ArrayList<>();
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
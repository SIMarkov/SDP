//Курсов проект по СДП, Задача 6

package SDP_Project;

import java.util.Random;
import java.util.Scanner;

public class SDP_Project {

	private static void inputArray(int[] myArray) {
		for (int elm : myArray);
	}

	public static void borderArray(int[] myArray, int L, int R) {
		Random rnd = new Random();

		if (R < L + 9) {
			for (int i = 0; i < myArray.length; ++i) {
				myArray[i] = rnd.nextInt(0, 14);
			}
			System.out.printf("Real numbers from interval (0, 14): ");
			for (int elm : myArray)
				System.out.print(elm + ", ");
			System.out.println();

		} else if (R > L + 8) {
			int m = 0;
			do {
				int n = rnd.nextInt(L, R);
				if (n % 8 == 0) {
					myArray[m] = n;
					m++;
				}
			} while (myArray[myArray.length - 1] == 0);
			System.out.printf("Real numbers divisible by eight from interval (%1$d, %2$d): ", L, R);
			for (int elm : myArray)
				System.out.print(elm + ", ");
			System.out.println();
		}
	}

	public static void sumArray(int[] myArray) {
		int sumPairs = 0;

		if (myArray.length < 2) { // Трябва да се промени стойността, защото минималния брой елементи на масива по
									// задание е 3
			System.out.println("-4");
		} else if (myArray.length > 2) {
			for (int i = 0; i + 1 < myArray.length; i++) {
				int sumC = (myArray[i] + myArray[i + 1]);
				if (sumC % 4 == 0) {
					++sumPairs;
				}
			}
			System.out.printf("Sum of pairs of numbers that are divisible by 4: %d \n", sumPairs);
		}
	}

	public static void posArray(int[] myArray) {

		for (int i = 0; i + 1 < myArray.length; ++i) {
			if (i > 0) {
				int rem = (myArray[i - 1] * myArray[i + 1]) % myArray[i];
				if (rem == 0) {
					System.out.printf("Index[%d] = %d \n", i, myArray[i]);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numArray;

		do {
			System.out.print("Please enter the number of elements in interval (3, 17): ");
			numArray = scan.nextInt();
		} while (numArray < 3 || 17 < numArray);
		int[] ar = new int[numArray];

		borderArray(ar, -40, 47);
		inputArray(ar);
		sumArray(ar);
		posArray(ar);

		// Оставил съм го, за да тествам резултатите от sumArray когато програмата
		// използва първия цикъл
		System.out.println();
		System.out.println("Test...");
		System.out.print("Please enter a left limit of the array: ");
		int L = scan.nextInt();
		System.out.print("Please enter a rigth limit of the array: ");
		int R = scan.nextInt();
		borderArray(ar, L, R);
		sumArray(ar);
		posArray(ar);

		scan.close();
	}
}

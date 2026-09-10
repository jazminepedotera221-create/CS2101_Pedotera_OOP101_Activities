import java.util.Scanner;

public class Canteen {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String[] foodItems = {
			"Burger",
			"Pizza",
			"Pasta",
			"Sandwich",
			"Milk Tea"
		};

		double[] prices = {
			80.00,
			120.00,
			100.00,
			70.00,
			90.00
		};

		int totalQuantity = 0;
		double totalBeforeDiscount = 0.0;
		double totalDiscount = 0.0;

		char orderAgain = 'Y';

		
		System.out.println("\n========MENU========");

		for (int i = 0; i < foodItems.length; i++) {
			System.out.printf("%d.%s - $%.2f%n", 
				i + 1, foodItems[i],prices[i]);
		}

		while (orderAgain == 'Y') {

			System.out.print("\nEnter item number: ");
			int itemNumber = input.nextInt();

			System.out.print("Enter quantity: ");
			int quantity = input.nextInt();

			System.out.print("Are you a student? (Y/N): ");
			char isStudent = Character.toUpperCase(input.next().charAt(0));

			if (itemNumber < 1 || itemNumber > foodItems.length || quantity < 1 || quantity > 10 || (isStudent != 'Y' && isStudent != 'N')) {

				System.out.println(
					"Invalid order! Please enter valid item and quantity. ");

				System.out.println("\nDo you want to order again? (Y/N): ");
				orderAgain = Character.toUpperCase(input.next().charAt(0));

				continue;
			}

			double subtotal = prices[itemNumber - 1] * quantity;

			double discountRate;

			if (isStudent == 'Y' && subtotal >= 500) {
					discountRate = 0.15;
			}
			else if (isStudent == 'Y') {
					discountRate = 0.10;
			}
			else if (subtotal >= 500) {
					discountRate = 0.05;
			}
			else {
					discountRate = 0.00;
			}

				double discount = subtotal * discountRate;
				double orderTotal = subtotal - discount;


				System.out.printf("%nSubtotal: $%.2f%n", subtotal);
				System.out.printf("Discount: $%.2f%n", discount);
				System.out.printf("Order Total: $%.2f%n", orderTotal);

				totalQuantity += quantity;
				totalBeforeDiscount += subtotal;
				totalDiscount += discount;


				System.out.print("\nDo you want to order again? (Y/N): ");
				orderAgain = Character.toUpperCase(input.next().charAt(0));

			}

			double finalAmount = totalBeforeDiscount - totalDiscount;


			System.out.println("\n===========ORDER SUMMARY===========");
			System.out.println("Total items: " + totalQuantity);
			System.out.printf("Total before discount: $%.2f%n", totalBeforeDiscount);
			System.out.printf("Total discount: $%.2f%n", totalDiscount);
			System.out.printf("Final amount: $%.2f%n", finalAmount);
			System.out.println("Thank you for ordering!");

			input.close();
	}

}

import java.util.Scanner;

public class Canteen {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int totalQuantity = 0;
		double totalBeforeDiscount = 0.0;
		double totalDiscount = 0.0;

		char orderAgain = 'Y';

		System.out.println("\n========MENU========");
		System.out.println("1. Burger - $80.00");
		System.out.println("2. Pizza - $120.00");
		System.out.println("3. Pasta - $100.00");
		System.out.println("4. Sandwich - $70.00");
		System.out.println("5. Milktea - $90.00");

		
		
		while (orderAgain == 'Y') {

			System.out.print("\nEnter item number: ");
			int itemNumber = input.nextInt();

			System.out.print("Enter quantity: ");
			int quantity = input.nextInt();

			System.out.print("Are you a student? (Y/N): ");
			char isStudent = Character.toUpperCase(input.next().charAt(0));

			if (itemNumber < 1 || itemNumber > 5 || quantity < 1 || quantity > 10 || (isStudent != 'Y' && isStudent != 'N')) {

				System.out.println(
					"Invalid order! Please enter valid item and quantity. ");

				System.out.println("\nDo you want to order again? (Y/N): ");
				orderAgain = Character.toUpperCase(input.next().charAt(0));

				continue;
			}

			double price = 0.0;

			switch (itemNumber) {
			case 1:
				price = 80.00;
				break;
			case 2:
				price = 120.00;
				break;
			case 3:
				price = 100.00;
				break;
			case 4:
				price = 70.00;
				break;
			case 5:
				price = 90.00;
				break;
			}

			double subtotal = price * quantity;
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

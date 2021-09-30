package orederingSystem;
import java.util.Scanner;
public class OrderingSystem {
	public static Scanner sc = new Scanner(System.in);
	public static String again;
	public static double total=0,price;
	public static int choose,quantity=1;
	public static void menu() {
		System.out.println("\t\t\t\t+------------------------+");
		System.out.println("\t\t\t\t     AKANSHA'S MENU     ");
		System.out.println("\t\t\t\t   1.Lemon Tea        Rs20");
		System.out.println("\t\t\t\t   2.OreoShake        Rs75");
		System.out.println("\t\t\t\t   3.Mango Juice      Rs25");
		System.out.println("\t\t\t\t   4.ChocChip Pastry  Rs125");
		System.out.println("\t\t\t\t   5.ChcoMuffin       Rs70");
		System.out.println("\t\t\t\t   6.Pineapple pastry Rs45");
		System.out.println("\t\t\t\t   7.Brownie          Rs120");
		System.out.println("\t\t\t\t   8.Cancel                 ");
		System.out.println("\t\t\t\t+-------------------------+");
		
	}
	public static void order() {
		System.out.println("Press 1 to buy LemonTea\nPress 2 to buy OreoShake\nPress 3 to buy Mango  juice\nPress 4 to buy chocchip Pastry\nPress 5 to buy chcoMuffin\nPress 6 to buy Pineapple Pastry\nPress 7 to buy Brownie\nPress 8 to cancel");
		System.out.println("what do you want to buy?");
		choose = sc.nextInt();
		
		if(choose == 1) {
			System.out.println("you choose Lemon Tea");
			System.out.println("How many leamon tea you want");
			quantity = sc.nextInt();
			total = total + (quantity*20);
			System.out.println("your total is "+total);
			System.out.println("Do you want something else");
			System.out.println("Press Y for yes and N for no");
			again = sc.next();
			if(again.equalsIgnoreCase("Y")) {
				order();
			}
			else
			{
				System.out.println("enter a payment");
				price = sc.nextDouble();
				if(price<= total) {
					System.out.println("Not enough payment");
				}else {
					total =price-total;
					System.out.println("your remaining balance  " + total);	
				}
				
				System.out.println("Thanks for coming");
			}
		}
		else if(choose == 2) {
			System.out.println("you choose OreoShake");
			System.out.println("How many OreoShake you want");
			quantity = sc.nextInt();
			total = total + (quantity*75);
			System.out.println("your total is "+total);
			System.out.println("Do you want something else");
			System.out.println("Press Y for yes and N for no");
			again = sc.next();
			if(again.equalsIgnoreCase("Y")) {
				order();
			}
			else
			{
				System.out.println("enter a payment");
				price = sc.nextDouble();
				if(price<= total) {
					System.out.println("Not enough payment");
				}else {
					total = price-total;
					System.out.println("your remaining balance  " + total);	
				}
				
				System.out.println("Thanks for coming");
			}
		}
		else if(choose == 3) {
			System.out.println("you choose Mango Juice");
			System.out.println("How many Mango juice you want");
			quantity = sc.nextInt();
			total = total + (quantity*25);
			System.out.println("your total is "+total);
			System.out.println("Do you want something else");
			System.out.println("Press Y for yes and N for no");
			again = sc.next();
			if(again.equalsIgnoreCase("Y")) {
				order();
			}
			else
			{
				System.out.println("enter a payment");
				price = sc.nextDouble();
				if(price<= total) {
					System.out.println("Not enough payment");
				}else {
					total = price-total;
					System.out.println("your remaining balance  " + total);	
				}
				
				System.out.println("Thanks for coming");
			}
		}
		else if(choose == 4) {
			System.out.println("you choose chocochip pastry");
			System.out.println("How many ChocoChip pastry you want");
			quantity = sc.nextInt();
			total = total + (quantity*125);
			System.out.println("your total is "+total);
			System.out.println("Do you want something else");
			System.out.println("Press Y for yes and N for no");
			again = sc.next();
			if(again.equalsIgnoreCase("Y")) {
				order();
			}
			else
			{
				System.out.println("enter a payment");
				price = sc.nextDouble();
				if(price<= total) {
					System.out.println("Not enough payment");
				}else {
					total = price-total;
					System.out.println("your remaining balance  " + total);	
				}
				
				System.out.println("Thanks for coming");
			}
		}
		else if(choose == 5) {
			System.out.println("you choose Choc Muffin");
			System.out.println("How many choco muffin you want");
			quantity = sc.nextInt();
			total = total + (quantity*70);
			System.out.println("your total is "+total);
			System.out.println("Do you want something else");
			System.out.println("Press Y for yes and N for no");
			again = sc.next();
			if(again.equalsIgnoreCase("Y")) {
				order();
			}
			else
			{
				System.out.println("enter a payment");
				price = sc.nextDouble();
				if(price<= total) {
					System.out.println("Not enough payment");
				}else {
					total = price-total;
					System.out.println("your remaining balance  " + total);	
				}
				
				System.out.println("Thanks for coming");
			}
		}
		else if(choose == 6) {
			System.out.println("you choose Pineapple pastry");
			System.out.println("How many Pineapple pastry you want");
			quantity = sc.nextInt();
			total = total + (quantity*45);
			System.out.println("your total is "+total);
			System.out.println("Do you want something else");
			System.out.println("Press Y for yes and N for no");
			again = sc.next();
			if(again.equalsIgnoreCase("Y")) {
				order();
			}
			else
			{
				System.out.println("enter a payment");
				price = sc.nextDouble();
				if(price<= total) {
					System.out.println("Not enough payment");
				}else {
					total = price-total;
					System.out.println("your remaining balance  " + total);	
				}
				
				System.out.println("Thanks for coming");
			}
		}
		else if(choose == 7) {
			System.out.println("you choose Brownie");
			System.out.println("How many Brownie you want");
			quantity = sc.nextInt();
			total = total + (quantity*120);
			System.out.println("your total is "+total);
			System.out.println("Do you want something else");
			System.out.println("Press Y for yes and N for no");
			again = sc.next();
			if(again.equalsIgnoreCase("Y")) {
				order();
			}
			else
			{
				System.out.println("enter a payment");
				price = sc.nextDouble();
				if(price<= total) {
					System.out.println("Not enough payment");
				}else {
					total = price-total;
					System.out.println("your remaining balance  " + total);	
				}
				
				System.out.println("Thanks for coming");
			}
		}
		else if(choose ==8) {
			System.exit(0);
		}else {
			System.out.println("choose correct number");
			order();
		}
	}

	public static void main(String[] args) {
		menu();
order();
	}

}

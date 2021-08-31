package self.bank.test;

import java.util.Scanner;

import self.bank.Account;
import self.bank.Address;
import self.bank.BankService;
import self.bank.Customer;

public class BankTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.���� ���    2.���»���    3.�������    4.������ü����    5.Ư����������    6.������");
			int num = sc.nextInt();

			switch (num) {
			case 1:
				addCustomer();
				break;

			case 2:
				createAccount();
				break;

			case 3:
				banking();
				break;
			case 4:
				BankService.getInstance().showAll();
				break;
			case 5:
				showCustomer();
				break;
			case 6:
				sc.close();
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}

	}

	public static void addCustomer() {
		System.out.println("[ �̸�  �ֹε�Ϲ�ȣ ������ȣ ��(��������) ������ ]������ �Է��ϼ���.");

		Scanner sc = new Scanner(System.in);
		// 1. Scanner�� name, ssn, zipCode, region, city���� ���� �Է¹޴´�.
		String name = sc.next();
		int ssn = sc.nextInt();
		int zipCode = sc.nextInt();
		String region = sc.next();
		String city = sc.next();

		// 2. �Է¹��� ������Customer ��ü�� ����
		Customer customer = new Customer(name, ssn, new Address(zipCode, region, city));
		// 3. �迭�� �߰���

		BankService.getInstance().addCustomer(customer);
		System.out.println(name + "�� ȸ����� �����߽��ϴ�.");
	}

	public static void createAccount() {
		System.out.print("ȸ���� �ֹι�ȣ�� �Է��ϼ��� : ");

		Scanner sc = new Scanner(System.in);
		int ssn = sc.nextInt();

		int balance = 0;

		Customer customer = BankService.getInstance().getCustomer(ssn);
		if (customer != null) {// 1. �Է¹��� ssn�� �ش��ϴ� ������ ���� �ʴٸ� ���尳���� �ϱ����� �ܾ��� ���� �Է¹ް� ������ ������
			System.out.println("���� �ݾ��� �Է��Ͻÿ�.>>");
			balance = sc.nextInt();

			customer.setAccount(new Account(balance));

		} else // 2. ���࿡ ȸ���� ���ٸ� return��Ŵ
			return;
	}

	public static void showCustomer() {
		System.out.print("ȸ���� �ֹι�ȣ�� �Է��ϼ��� : ");

		Scanner sc = new Scanner(System.in);
		int ssn = sc.nextInt();

		Customer customer = BankService.getInstance().getCustomer(ssn);

		if (customer != null) {// 1. �ֹι�ȣ�� �ش��ϴ� ������ �����Ѵٸ� ������ �����
			System.out.println(
					"�̸� : " + customer.getName() + ", ssn : " + customer.getSsn() + ", �ּ� : " + customer.getAddress());

		} else
			return;// 2. �׷��� �ʴٸ� �����ϴ� ȸ���� ���ٴ� �޼����� ����ϰ� return

	}

	public static void banking() {
		System.out.print("ȸ���� �ֹι�ȣ�� �Է��ϼ��� : ");

		Scanner sc = new Scanner(System.in);
		int ssn = sc.nextInt();

		if (BankService.getInstance().getCustomer(ssn).getName() == "") {
			System.out.println("�����ϴ� ȸ���� �����ϴ�.");
			return;
		}

		if (BankService.getInstance().getCustomer(ssn).getAccount() == null) {
			System.out.println("���尳������ �ϼ���.");
			return;
		}

		while (true) {
			System.out.println("1.�Ա�    2.���    3.�ܾ�Ȯ��    4.������");
			int num = sc.nextInt();

			switch (num) {
			case 1:
				deposit(ssn);
				break;

			case 2:
				withdraw(ssn);
				break;
			case 3:
				showBalance(ssn);
				break;
			case 4:
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}

	public static void deposit(int ssn) {
		System.out.print("�Ա��� �ݾ��� �Է��ϼ��� : ");

		Scanner sc = new Scanner(System.in);
		int amt = sc.nextInt();

		BankService.getInstance().getCustomer(ssn).getAccount().deposit(amt);
		System.out.println(BankService.getInstance().getCustomer(ssn).getAccount());
	}

	public static void withdraw(int ssn) {
		System.out.print("����� �ݾ��� �Է��ϼ��� : ");

		Scanner sc = new Scanner(System.in);
		int amt = sc.nextInt();

		BankService.getInstance().getCustomer(ssn).getAccount().withdraw(amt);
		System.out.println(BankService.getInstance().getCustomer(ssn).getAccount());
	}

	
	
	public static void showBalance(int ssn) {
		System.out.println(BankService.getInstance().getCustomer(ssn).getAccount().getBalance());
	}

}
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
			System.out.println("1.고객 등록    2.계좌생성    3.은행업무    4.고객전체명단    5.특정고객정보    6.나가기");
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
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}

	}

	public static void addCustomer() {
		System.out.println("[ 이름  주민등록번호 우편번호 도(행정구역) 지역명 ]순으로 입력하세요.");

		Scanner sc = new Scanner(System.in);
		// 1. Scanner로 name, ssn, zipCode, region, city값을 각각 입력받는다.
		String name = sc.next();
		int ssn = sc.nextInt();
		int zipCode = sc.nextInt();
		String region = sc.next();
		String city = sc.next();

		// 2. 입력받은 값으로Customer 객체를 생성
		Customer customer = new Customer(name, ssn, new Address(zipCode, region, city));
		// 3. 배열에 추가함

		BankService.getInstance().addCustomer(customer);
		System.out.println(name + "님 회원등록 성공했습니다.");
	}

	public static void createAccount() {
		System.out.print("회원의 주민번호를 입력하세요 : ");

		Scanner sc = new Scanner(System.in);
		int ssn = sc.nextInt();

		int balance = 0;

		Customer customer = BankService.getInstance().getCustomer(ssn);
		if (customer != null) {// 1. 입력받은 ssn에 해당하는 고객이 없지 않다면 통장개설을 하기위한 잔액을 먼저 입력받고 통장을 개설함
			System.out.println("넣을 금액을 입력하시오.>>");
			balance = sc.nextInt();

			customer.setAccount(new Account(balance));

		} else // 2. 만약에 회원이 없다면 return시킴
			return;
	}

	public static void showCustomer() {
		System.out.print("회원의 주민번호를 입력하세요 : ");

		Scanner sc = new Scanner(System.in);
		int ssn = sc.nextInt();

		Customer customer = BankService.getInstance().getCustomer(ssn);

		if (customer != null) {// 1. 주민번호에 해당하는 고객이 존재한다면 정보를 출력함
			System.out.println(
					"이름 : " + customer.getName() + ", ssn : " + customer.getSsn() + ", 주소 : " + customer.getAddress());

		} else
			return;// 2. 그렇지 않다면 존재하는 회원이 없다는 메세지를 출력하고 return

	}

	public static void banking() {
		System.out.print("회원의 주민번호를 입력하세요 : ");

		Scanner sc = new Scanner(System.in);
		int ssn = sc.nextInt();

		if (BankService.getInstance().getCustomer(ssn).getName() == "") {
			System.out.println("존재하는 회원이 없습니다.");
			return;
		}

		if (BankService.getInstance().getCustomer(ssn).getAccount() == null) {
			System.out.println("통장개설부터 하세요.");
			return;
		}

		while (true) {
			System.out.println("1.입금    2.출금    3.잔액확인    4.나가기");
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
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}

	public static void deposit(int ssn) {
		System.out.print("입금할 금액을 입력하세요 : ");

		Scanner sc = new Scanner(System.in);
		int amt = sc.nextInt();

		BankService.getInstance().getCustomer(ssn).getAccount().deposit(amt);
		System.out.println(BankService.getInstance().getCustomer(ssn).getAccount());
	}

	public static void withdraw(int ssn) {
		System.out.print("출금할 금액을 입력하세요 : ");

		Scanner sc = new Scanner(System.in);
		int amt = sc.nextInt();

		BankService.getInstance().getCustomer(ssn).getAccount().withdraw(amt);
		System.out.println(BankService.getInstance().getCustomer(ssn).getAccount());
	}

	
	
	public static void showBalance(int ssn) {
		System.out.println(BankService.getInstance().getCustomer(ssn).getAccount().getBalance());
	}

}

package pizza.parent;

/*
 * �߻� Ŭ������ �뵵
 * 1. ���������� ���ڸ� ������ ���� �������� �۾�(�ʵ�, �޼ҵ�)�� �״�� �ڽĵ鿡�� �����ش�
 * 2. ���� ������ ���ڰ� ��������� �ִ� �������� �κ��� �߻�޼ҵ�� �����صд�. :: topping()
 * 
 * �Ϻ��� �߻� : Interface - ����ڿ� �ۼ��ڰ��� Contract
 * �κ����� �߻� : Abstract class - ���������� �ٸ� �κ��� �̿����� �����ش�.-> �ڽ��� �̿��� �ϼ��ϵ��� ����.
 * 
 */

public abstract class Pizza {
	protected int price;
	protected String storeName;

	public Pizza(int price, String storeName) {
		super();
		this.price = price;
		this.storeName = storeName;
	}

	public Pizza() {
		this(15000, "PizzaHut");
	}

	//����� �ϳ� �� �߰�
	public void makePizza() {
		dough();
		topping();
		bake();
		cutting();
		boxing();
	}
	
	
	public void dough() {
		System.out.println("���� ���װ� �Բ� ���츦 �� ����� �ݴϴ�.");
	}

	public void bake() {
		System.out.println("180�� �µ����� 10�а� �������ϴ�");
	}

	public void boxing() {
		System.out.println("�߷��� ���ڸ� ���ڿ� �����մϴ�.");
	}

	public void cutting() {
		System.out.println("8�������� �߶��ݴϴ�.");
	}

	public abstract void topping();

	
	//������ �����ϴ� ���
	@Override
	public String toString() {
		return storeName + " " + price + "��";
	}
	
} // class
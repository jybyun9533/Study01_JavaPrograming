package stream.object.step1.test;

import java.io.Serializable;

/*
 * PersonŬ���� Ÿ���� ��ü�� 
 * ObjectInputStream, ObjectOutputStream�� ���ؼ� ����(class�ʵ�)��
 * �Է�, ��µǴ� ��ü�̴�.
 * 
 * �� Ŭ���� Ÿ���� ��ü�� ��Ʈ���� ����Ϸ��� �ݵ�� Serializable�̶�� �������̽��� ��ӹ޾Ƽ� ���ǵǾ�� �Ѵ�.
 * -> Serializable�������̽��� ������ Ŭ������ �ʵ�� ��ü��Ʈ���� ����� �� �ִ�.
 */
public class Person implements Serializable {
	private String name;
	private int age;
	private String password;
	private String address;

	public Person() {

	}

	public Person(String name, int age, String password, String address) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", password=" + password + ", address=" + address + "]";
	}

}
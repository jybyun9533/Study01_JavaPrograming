package array.test;

/*
 * intŸ���� �迭�� ���� �� ������ ���� ������ ���� �ִ´�
 * �������ڵ� �߿��� ���� ū ���� ���� ���� ã�Ƴ��� �˰����� �ۼ�
 */
public class ArrayMaxAndMinTest3 {

	public static void main(String[] args) {
		int[] scores = { 79, 88, 91, 44, 99, 55, 96 };

		int min = scores[0], max = scores[0]; // �迭�� ù��° ������ �⺻���� �ʱ�ȭ �Ѵ�..79

//		for (int i = 1; i < scores.length; i++) {
//			if (scores[i] < min) {
//				min = scores[i];
//			}
//			if (scores[i] > max) {
//				max = scores[i];
//			}
//		}

		// Anvanced For��
		// "���� ��𿡼� ���°�?"
		for (int score : scores) {
			if (score < min) {
				min = score;
			}
			if (score < max) {
				max = score;
			}
		}

		System.out.println("�ּҰ� " + min);
		System.out.println("�ִ밪 " + max);

	} // main

}
package stream.data.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

/*
 * 간단한 성적들을 파일로 출력하는 코드 작성
 * 만약에 scroe.dat 파일 형식이 지원되지 않아서 출력되는 에러메세지는 무시
 * 바이트 계열 스트림은 출력되는 데이터 형식이 문자기반이 아닌, Binary Data.
 * 따라서 문서편집기로 보아도 알수 없는 형식으로 열림 
 * 그래서 결국 이를 확인하기 위해서는
 * score.dat파일에 출력된 Binary Data를 다시 DataInputStream을 통해서 자바 기본형으로 자동변환 시켜서 읽어들여야한다.
 */

import java.io.IOException;

public class DataOutputStreamTest5 {

	public static void main(String[] args) throws IOException {
		String path = "src\\watermelon.png";
		int data = 0;

		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			dis = new DataInputStream(new FileInputStream(path));
			dos = new DataOutputStream(new FileOutputStream("src\\water.png"));

			// dos.write(dis.readAllBytes());

			while ((data = dis.readInt()) != -1) {
				dos.writeInt(data);
			}

		} catch (EOFException e) {

		} finally {
			dis.close();
			dos.close();
		} // fin

	}// main
}// class

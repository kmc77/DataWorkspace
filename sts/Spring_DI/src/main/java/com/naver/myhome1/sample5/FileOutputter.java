package com.naver.myhome1.sample5;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	
	private String filePath; //������� ��ο� �����̸��� ������ ����
	
	public FileOutputter() {
		System.out.println("����� FileOutputter �������Դϴ�.");
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath; //out.txt ���ԵǾ����ϴ�.
		System.out.println("����� FileOutputter.java�� setFilePath() �Դϴ�. ");
	}
	
	@Override
	public void output(String message) throws IOException {
		System.out.println("�����  FileOutputter.java�� output() �Դϴ�.");
		FileWriter out = new FileWriter(filePath);
		out.write(message);
		out.close();
	}

}
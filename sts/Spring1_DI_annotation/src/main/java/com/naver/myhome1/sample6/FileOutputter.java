package com.naver.myhome1.sample6;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
//�߰� �κ�
import org.springframework.stereotype.Component;

@Component
public class FileOutputter implements Outputter {
	
	@Value("${filepath}")
	private String filePath; // ������� ��ο� �����̸��� ������ ����

	public  FileOutputter() {
		System.out.println("����� FileOutputter �������Դϴ�.");
	}
	
	@Override
	public void output(String message) throws IOException {
		System.out.println("����� FileOutputter.java�� output() �Դϴ�. ");
		FileWriter out = new FileWriter(filePath);
		System.out.println("filePath=" + filePath);
		out.write(message);// �޽����� �����
		out.close();// ��� ��ü�� ����
	}

	
}
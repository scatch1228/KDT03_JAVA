package com.ruby.java.ch12.입출력;

import java.io.File;
import java.io.PrintWriter;

public class Test05 {

	public static void main(String[] args) {
		try {
			File dir = new File("c:\\work");
			dir.mkdir();
			
			File file = new File(dir, "file1.txt");
			file.createNewFile();
			
			//파일 또는 디렉터리 여부 판단
			if (dir.isDirectory())
				System.out.println(dir.getName() + ", yes, is a directory");
			if (!dir.isFile())
				System.out.println(dir.getName() + ", no, is not a file");
			if (file.isFile())
				System.out.println(file.getName() + ", yes, is a file");
			
			//파일에 데이터 출력후 읽기
			if(file.exists()) {
				try(PrintWriter out = new PrintWriter(file)) {
					out.println("hello java!");
				}
				System.out.println("file name: "+file.getName());
				System.out.println("file path: "+file.getPath());
				System.out.println("writable: "+file.canWrite());
				System.out.println("readable: "+file.canRead());
				System.out.println("file length: "+file.length() + "byte");
			} else {
				System.out.println("no file to work");
			}
			
			File subDir = new File("c:\\work\\subDir");
			subDir.mkdir();
			File file2 = new File(subDir, "file2.txt");
			file2.createNewFile();
			
			//파일 절대 경로
			String file2Path = file2.getAbsolutePath();
			System.out.println("Absolute Path of file2: " + file2Path);
			System.out.println("Path of file2: " + file2.getPath());
			
			//부모 디렉터리
			String parentDir = file2.getParent();
			System.out.println("Parent Path of file2: "+parentDir);
			
			//디렉토리 목록 구하기
			File parentFile = file.getParentFile();
			String[] fileNames = parentFile.list();
			System.out.println(parentDir + " 목록 =>");
			for(String name : fileNames) {
				System.out.println(name);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

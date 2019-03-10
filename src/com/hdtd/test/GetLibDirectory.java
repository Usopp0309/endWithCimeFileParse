package com.hdtd.test;

import java.io.File;

public class GetLibDirectory {
	public static void main(String[] args) {
		File file = new File("lib");
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			System.out.print(" lib/"+file2.getName()+" \n");
		}
		System.out.println();
	}
}

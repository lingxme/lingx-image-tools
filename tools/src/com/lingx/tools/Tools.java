package com.lingx.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tools {

	public static void main(String[] args) {
		String inFile="D:/001/45.jpg";
		String outFile="D:/001/46.jpg";
		Image image=new Image();
		
		try {
			image.readImage(new FileInputStream(inFile));
			image.resize();
			image.writeImage(new FileOutputStream(outFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

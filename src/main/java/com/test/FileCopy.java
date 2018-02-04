package com.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.common.io.Files;

public class FileCopy {

	public static void main(String... args) {

	}

/*	public static boolean copyFile(File source,File dest) throws IOException{
		Files.copy(source.toPath(), dest.toPath());
	}

	private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
		Files.copy(source.toPath(), dest.toPath());
	}

	private static void copy(File src,File dst) {
		FileUtils.copy(src,dst);
	}*/

	private static void copy2(File f1,File f2) {
		InputStream in=null;
		OutputStream op=null;
		try {
			in=new BufferedInputStream(new FileInputStream(f1));
			op=new FileOutputStream(f2);
			int bytesRead;
			byte[] buff=new byte[1024];
			while((bytesRead=in.read(buff))>0) {
				op.write(buff, 0, bytesRead);				
			}
		}catch(IOException e) {
		}
	}
}
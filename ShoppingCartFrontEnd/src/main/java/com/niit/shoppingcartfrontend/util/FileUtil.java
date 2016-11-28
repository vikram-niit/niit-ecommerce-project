package com.niit.shoppingcartfrontend.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static void upload(String path, MultipartFile file, String filename) {
		
		System.out.println("Start of method upload");
		byte[] bytes = null;
		
		if(!file.isEmpty())
		{
			try {
				bytes = file.getBytes();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdirs();
		
		File serverFile = new File(dir.getAbsolutePath()+File.separator+filename);
		
		BufferedOutputStream stream = null;
		try {
			stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stream.write(bytes);
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		System.out.println("End of file upload");
	}

}

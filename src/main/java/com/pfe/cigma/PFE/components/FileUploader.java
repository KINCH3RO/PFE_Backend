package com.pfe.cigma.PFE.components;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

@Component

public class FileUploader {

	public enum FileType {
		IMAGE("Images"), FILE("Files"),
		// ...
		VIDEO("Videos");

		public final String label;

		private FileType(String label) {
			this.label = label;
		}
	}

	public  File uploadFile(String name,int id, MultipartFile file, FileType f) throws IOException {
		String dirPath = "C:\\Users\\KiNCH3RO\\Documents\\java Projects\\PFE\\src\\main\\resources\\static\\UploadedFiles\\"
				+ f.label + "\\";
		
         System.out.println(f.label);
         String fileName = name + id + "." + FilenameUtils.getExtension(file.getOriginalFilename().toLowerCase());

		File myObj = new File(dirPath + fileName);

		
		if (myObj.exists()) {
			System.out.println("deliting file exist");
			myObj.delete();

		}

		if (myObj.createNewFile()) {
			byte[] fileBytes = file.getBytes();
			FileOutputStream fos = null;

			fos = new FileOutputStream(myObj);
			fos.write(fileBytes);
			fos.close();
			
			return myObj;
		} else {
			return null;
		}

	}
}

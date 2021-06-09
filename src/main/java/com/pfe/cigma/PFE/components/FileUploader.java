package com.pfe.cigma.PFE.components;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

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

	public  File uploadFile(String name, MultipartFile file) throws IOException {
		
		FileType f = FileType.FILE;
		
		String[] imageExtensions = {"png","jpg","jpeg"};
		
		String[] videoExtensions = {"mp4","webm"};
		
		String fileExtension =FilenameUtils.getExtension(file.getOriginalFilename().toLowerCase());
		
		if(Arrays.asList(imageExtensions).contains(fileExtension)) {
			f=FileType.IMAGE;
		}else if(Arrays.asList(videoExtensions).contains(fileExtension) ) {
			f=FileType.VIDEO;
		}
		
		 System.out.println(f.label);
		 
		
	
		String dirPath = "C:\\Users\\KiNCH3RO\\Documents\\java Projects\\PFE\\src\\main\\resources\\static\\UploadedFiles\\"
				+ f.label + "\\";
		
        
         String fileName = name+ RandomStringGenerator.generateString() +"." + FilenameUtils.getExtension(file.getOriginalFilename().toLowerCase());

		File myObj = new File(dirPath + fileName);
   
		
		while(myObj.exists()) {
			System.out.println("file exist");
			fileName = RandomStringGenerator.generateString() +"." + FilenameUtils.getExtension(file.getOriginalFilename().toLowerCase());

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

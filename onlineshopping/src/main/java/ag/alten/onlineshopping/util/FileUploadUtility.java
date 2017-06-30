package ag.alten.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH="C:\\Users\\Alessio\\Documents\\Workspace\\shop\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH="";
	
	private static final Logger logger =  LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// TODO Auto-generated method stub
		
		REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);
		
		//controlla se esiste la cartella nel percorso assoluto
		if(!new File(ABS_PATH).exists()){
			new File(ABS_PATH).mkdirs();
		}
		
		//controlla se esiste la cartella nel percorso real
		if(!new File(REAL_PATH).exists()){
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			//server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			//project directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
		} catch (IOException e) {
		
		}
	}

}


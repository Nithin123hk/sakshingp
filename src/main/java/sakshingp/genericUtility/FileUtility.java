package sakshingp.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility
 {
	 public String readCommonData(String Key) throws IOException
	 {
		 FileInputStream fis=new FileInputStream("C:\\Users\\ASUS\\eclipse-workspace\\sakshingp\\src\\test\\java\\config\\config.properties");
		 Properties pobj=new Properties();
		 pobj.load(fis);
		 String value=pobj.getProperty(Key);
		 return value;
	 }
 }


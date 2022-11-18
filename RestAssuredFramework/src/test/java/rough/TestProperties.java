package rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) {
		Properties prop = new Properties();
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			
		}
		System.out.println(prop.getProperty("baseURI"));
	}

}

package rough;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test3 {


	@Test(dataProvider = "getData")
	public void t1(String t1,String t2) {
		System.out.println(t1+" : "+t2);
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return new Object[][] {{"m1","23293"},{"m2","3848343484"}};
		
	}
}

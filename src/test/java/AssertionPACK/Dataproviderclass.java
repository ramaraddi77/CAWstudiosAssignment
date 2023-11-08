package AssertionPACK;

import org.testng.annotations.DataProvider;

public class Dataproviderclass 
{
	@DataProvider(name="testdata")
	public String[][][] TestData()
	{
		String[][][]A= {{{"name","age","gender"},{"Bob","20","male"},{"George","42","male"},{"Sara","42","female"}}};
		return A;
	}
}

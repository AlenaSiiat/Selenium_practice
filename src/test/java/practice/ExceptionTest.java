package practice;


import org.testng.annotations.Test;

public class ExceptionTest {

	@Test (expectedExceptions=ArithmeticException.class)
	public void expected_exceptionTest() {
		
	int a=0;
	int b=1/a;		
	}
	
}

package wordCountProTest;

import static org.junit.Assert.*;

import java.io.BufferedReader;

import org.junit.Test;
import wordCountPro.wcProInput;

public class wcProInputTest {

	@Test
	public void testGetInput1() {
		String s[] = {"testtxt"};
		assertEquals(BufferedReader.class, wcProInput.getInput(s).getClass());
	}
	
	@Test
	public void testGetInput2() {
		String s[] = {"test.txt"};
		assertEquals(BufferedReader.class, wcProInput.getInput(s).getClass());
	}
	
	@Test
	public void testGetInput3() {
		String s[] = {"testtxt","jf"};
		assertEquals(BufferedReader.class, wcProInput.getInput(s).getClass());
	}
	
	@Test
	public void testGetInput4() {
		String s[] = {"testtxt--"};
		assertEquals(BufferedReader.class, wcProInput.getInput(s).getClass());
	}

}

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
		String s[] = {"test.txt","jf"};
		assertEquals(BufferedReader.class, wcProInput.getInput(s).getClass());
	}
	
	@Test
	public void testGetInput4() {
		String s[] = {"testtxt--"};
		assertEquals(BufferedReader.class, wcProInput.getInput(s).getClass());
	}



	@Test
	public void testGetInput5() {
	String s[] = {"testtxt-","hdsjf"};
	assertEquals(BufferedReader.class, wcProInput.getInput(s).getClass());
	}
	
	@Test
	public void testGetInput6() {
	String s[] = {};
	assertEquals(BufferedReader.class, wcProInput.getInput(s).getClass());
	}
	
	@Test
	public void testGetInput7() {
	String s[] = {"test1.Txt"};
	assertEquals(BufferedReader.class, wcProInput.getInput(s).getClass());
	}
	
	@Test
	public void testGetInput8() {
	String s[] = {"test.java"};
	assertEquals(BufferedReader.class, wcProInput.getInput(s).getClass());
	}
	
	@Test
	public void testGetInput9() {
	String s[] = {"test_1.txt"};
	assertEquals(BufferedReader.class, wcProInput.getInput(s).getClass());
	}
	
	@Test
	public void testGetInput10() {
	String s[] = {"test_2t.txt"};
	assertEquals(BufferedReader.class, wcProInput.getInput(s).getClass());
	}
}


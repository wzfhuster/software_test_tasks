package wordCountProTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import wordCountPro.wcProOutput;

public class wcProOutputTest {

	Map<String, Integer> map = new HashMap<String, Integer>();
	List<Map.Entry<String, Integer>> list = null;
	
	@Before
	public void setUp()
	{
		map.clear();
	}
	
	
	@Test  
	public void testOutput1() {
		
		//因为单词在wcProMain中的wordCount函数已经转换成小写了
		//所以这里写入测试用例的时候，只需要测试小写字母的单词即可！
		map.put("i", 180);
		map.put("this", 200);
		map.put("the", 180);
		map.put("ij", 180);
		
		//期待输出的结果，不同单词和词频对之间用"\n"来隔开表示换行
		String expectResult = "this 200 \n i 180 \n ij 180 \n the 180";
		
		assertEquals(expectResult,wcProOutput.output(map, "result.txt"));
	}
	
	@Test  
	public void testOutput2() {
		map.put("dfj", 200);
		map.put("faien", 345);
		map.put("ij", 180);
		map.put("hehe", 180);
		String expectResult = "faien 345 \n dfj 200 \n hehe 180 \n ij 180";
		assertEquals(expectResult,wcProOutput.output(map, "result.txt"));
	}
	
	@Test  
	public void testOutput3() {
		map.put("dfj", 200);
		map.put("ij", 345);
		map.put("i", 180);
		map.put("hehe", 180);
		String expectResult = "ij 345 \n dfj 200 \n hehe 180 \n i 180";
		assertEquals(expectResult,wcProOutput.output(map, "result.txt"));
	}
	
	@Test  
	public void testOutput4() {
		map.put("dfj", 200);
		map.put("ij", 345);
		map.put("i", 180);
		map.put("hh", 180);
		String expectResult = "ij 345 \n dfj 200 \n hh 180 \n i 180";
		assertEquals(expectResult,wcProOutput.output(map, "result.txt"));
	}
	
	@Test  
	public void testOutput5() {
		map.put("dfj", 200);
		map.put("mm", 345);
		map.put("i", 180);
		map.put("hehe", 180);
		String expectResult = "mm 345 \n dfj 200 \n hehe 180 \n i 180";
		assertEquals(expectResult,wcProOutput.output(map, "result.txt"));
	}
	
	@Test  
	public void testOutput6() {
		map.put("dfj", 200);
		map.put("zz", 3095);
		map.put("i", 180);
		map.put("hehe", 180);
		String expectResult = "zz 3095 \n dfj 200 \n hehe 180 \n i 180";
		assertEquals(expectResult,wcProOutput.output(map, "result.txt"));
	}
	
	@Test  
	public void testOutput7() {
		map.put("dfj", 200);
		map.put("ij", 345);
		map.put("i", 180);
		map.put("hehe", 180);
		String expectResult = "ij 345 \n dfj 200 \n hehe 180 \n i 180";
		assertEquals(expectResult,wcProOutput.output(map, "result.txt"));
	}
	
	@Test  
	public void testOutput8() {
		map.put("dfj", 200);
		map.put("ij", 345);
		map.put("i", 180);
		map.put("hehe", 180);
		String expectResult = "ij 345 \n dfj 200 \n hehe 180 \n i 180";
		assertEquals(expectResult,wcProOutput.output(map, "result.txt"));
	}
	
	@Test  
	public void testOutput9() {
		map.put("dfj", 200);
		map.put("i", 345);
		map.put("iout", 180);
		map.put("ii", 180);
		String expectResult = "i 345 \n dfj 200 \n ii 180 \n iout 180";
		assertEquals(expectResult,wcProOutput.output(map, "result.txt"));
	}
	
	@Test  
	public void testOutput10() {
		map.put("dfj", 200);
		map.put("ij", 345);
		map.put("i", 180);
		map.put("hehe", 180);
		String expectResult = "ij 345 \n dfj 200 \n hehe 180 \n i 180";
		assertEquals(expectResult,wcProOutput.output(map, "result.txt"));
	}
}

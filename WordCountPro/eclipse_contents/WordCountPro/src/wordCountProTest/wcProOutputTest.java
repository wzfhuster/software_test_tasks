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
	
	//每个测试之前，清空map中的内容
	@Before
	public void setUp()
	{
		map.clear();
	}
	
	
	//因为单词在wcProMain中的wordCount函数中已经转化成小写了
	//所以这里写入测试用例的时候，只需要测试小写字母的单词即可 
	
	//单词的词频从大到小
	@Test  
	public void testOutput1() {
		map.put("in", 80);
		map.put("this", 200);
		map.put("that", 60);
		map.put("i", 180);
		
		//预期输出的结果，不同单词和词频对之间用" \n "来隔开表示换行
		String expectResult = "this 200 \n i 180 \n in 80 \n that 60";
		
		//比较实际输出的结果和预期输出结果，判断输出是否正确
		assertEquals(expectResult,wcProOutput.output(map, "result1.txt"));
	}
	
	//单词的词频相同时，按照单词字母排序
	@Test  
	public void testOutput2() {
		map.put("in", 180);
		map.put("that", 180);
		map.put("i", 180);
		String expectResult = "i 180 \n in 180 \n that 180";
		assertEquals(expectResult,wcProOutput.output(map, "result2.txt"));
	}


	@Test  
	public void testOutput3() {
		map.put("a", 1);
		map.put("b", 345);
		map.put("c", 180);
		map.put("d", 80);
		String expectResult = "b 345 \n c 180 \n d 80 \n a 1";
		assertEquals(expectResult,wcProOutput.output(map, "result3.txt"));
	}

	
	@Test  
	public void testOutput4() {
		map.put("lol", 200);
		map.put("oh", 345);
		map.put("ij", 180);
		String expectResult = "oh 345 \n lol 200 \n ij 180";
		assertEquals(expectResult,wcProOutput.output(map, "result4.txt"));
	}

	@Test  
	public void testOutput5() {
		map.put("xf", 20);
		map.put("ff", 20);
		map.put("xff", 20);
		map.put("af", 20);
		String expectResult = "af 20 \n ff 20 \n xf 20 \n xff 20";
		assertEquals(expectResult,wcProOutput.output(map, "result5.txt"));
	}

	@Test  
	public void testOutput6() {
		map.put("asd", 200);
		map.put("dsd", 345);
		map.put("i", 180);
		String expectResult = "dsd 345 \n asd 200 \n i-1 180 \n i2 180";
		assertEquals(expectResult,wcProOutput.output(map, "result6.txt"));
	}

	
	@Test  
	public void testOutput7() {
		map.put("ia", 180);
		map.put("i", 180);
		String expectResult = "i 180 \n ia 180";
		assertEquals(expectResult,wcProOutput.output(map, "result7.txt"));
	}

	
	@Test  
	public void testOutput8() {
		map.put("ia", 180);
		map.put("ib", 180);
		String expectResult = "ia 180 \n ib 180";
		assertEquals(expectResult,wcProOutput.output(map, "result8.txt"));
	}

//输出文件已存在时，将覆盖原文件
//testOutput9()和testOutput10()都输出到result9.txt
	@Test  
	public void testOutput9() {
		map.put("ia", 180);
		map.put("ib", 180);
		String expectResult = "ia 180 \n ib 180";
		assertEquals(expectResult,wcProOutput.output(map, "result9.txt"));
	}

	
	@Test  
	public void testOutput10() {
		map.put("asd", 200);
		map.put("dsd", 345);
		map.put("hy", 180);
		map.put("hh", 180);
		String expectResult = "dsd 345 \n asd 200 \n hh 180 \n hy 180";
		assertEquals(expectResult,wcProOutput.output(map, "result9.txt"));
	}

	
	@Test  
	public void testOutput11() {
		map.put("faien", 345);
		map.put("ij", 180);
		String expectResult = "faien 345 \n ij 180";
		assertEquals(expectResult,wcProOutput.output(map, "result11.txt"));
	}

	
	@Test  
	public void testOutput12() {
		map.put("lol", 200);
		map.put("oh", 345);
		map.put("ij", 180);
		String expectResult = "oh 345 \n lol 200 \n ij 180";
		assertEquals(expectResult,wcProOutput.output(map, "result12.txt"));
	}

	
	@Test  
	public void testOutput13() {
		map.put("q", 123);
		map.put("w", 345);
		map.put("e", 34);
		map.put("r", 67);
		String expectResult = "w 345 \n q 123 \n r 67 \n e 34";
		assertEquals(expectResult,wcProOutput.output(map, "result13.txt"));
	}

	
	@Test  
	public void testOutput14() {
		map.put("ak", 180);
		map.put("awm", 180);
		String expectResult = "ak 180 \n awm 180";
		assertEquals(expectResult,wcProOutput.output(map, "result14.txt"));
	}

	
	@Test  
	public void testOutput15() {
		map.put("dfj", 200);
		map.put("faien", 345);
		map.put("faen", 180);
		map.put("dj", 180);
		String expectResult = "faien 345 \n dfj 200 \n dj 180 \n faen 180";
		assertEquals(expectResult,wcProOutput.output(map, "result15.txt"));
	}

	
	@Test  
	public void testOutput16() {
		map.put("are", 200);
		map.put("you", 345);
		map.put("ok", 180);
		map.put("fine", 180);
		String expectResult = "you 345 \n are 200 \n fine 180 \n ok 180";
		assertEquals(expectResult,wcProOutput.output(map, "result1.txt"));
	}

	
	@Test  
	public void testOutput17() {
		map.put("d", 200);
		map.put("a", 345);
		map.put("b", 180);
		map.put("c", 80);
		String expectResult = "a 345 \n d 200 \n b 180 \n c 80";
		assertEquals(expectResult,wcProOutput.output(map, "result17.txt"));
	}

	@Test  
	public void testOutput18() {
		map.put("d", 200);
		map.put("a", 345);
		map.put("b", 180);
		map.put("c", 180);
		String expectResult = "a 345 \n d 200 \n b 180 \n c 180";
		assertEquals(expectResult,wcProOutput.output(map, "result18.txt"));
	}	
	
	@Test  
	public void testOutput19() {
		map.put("you", 180);
		map.put("ku", 180);
		String expectResult = "you 180 \n ku 180";
		assertEquals(expectResult,wcProOutput.output(map, "result19.txt"));
	}	
	
	@Test  
	public void testOutput20() {
		map.put("wang", 200);
		map.put("yi", 345);
		String expectResult = "yi 345 \n wang 200";
		assertEquals(expectResult,wcProOutput.output(map, "result20.txt"));
	}

}
	
	

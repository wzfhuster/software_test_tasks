package wordCountProTest;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import wordCountPro.wcProMain;

public class wcProMainTest {

	wcProMain wcPro = new wcProMain();
	Map<String,Integer> expectMap = new HashMap<String, Integer>();
	Map<String,Integer> resultMap = new HashMap<String, Integer>();
	
	
	//这里为了比较两个map中的内容是否相同，而重写了equals函数	！！！！！！！！！！
	@Override 	
	public boolean equals(Object obj) {   
		if(obj instanceof Map<?, ?>)
		{
			boolean flag = true;
			for(String key: expectMap.keySet())
				if(resultMap.get(key)==null ||
				resultMap.get(key).intValue()!=expectMap.get(key).intValue())
				{
					flag = false;
					break;
				}
			return flag;
		}
		else
			return super.equals(obj);
	}
	
	//每个测试之前，要清空两个map中的内容！！！！！！！！！！！！！！！
	@Before
	public void setUp()
	{
		expectMap.clear();
		resultMap.clear();
	}
	
	
	@Test
	public void testWordCount1() throws FileNotFoundException {
		
		//testWordCount.txt中存放的是待测试的文本,具体内容如下：
		/*"Are you ok"
		   ,O-K
		   i am ok-34; hehe01
		   I AM fiNE(HaHa)!
		 */
		BufferedReader in = new BufferedReader(new FileReader("testWordCount1.txt"));
		
		//下面输入期待的统计结果，不用考虑添加顺序，而且文本的内容已经自动处理成了小写单词
		//所以添加期待的结果都是小写字母的单词
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		
		//测试wcProMain中的wordCout函数，将结果写入 resultMap中
		wcPro.wordCount(in, resultMap);
		
		//判断实际统计结果和预期的结果是否相同
		assertEquals(expectMap, resultMap);
		
	}
	
	@Test
	public void testWordCount2() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount2.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}
	
	@Test
	public void testWordCount3() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount3.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount4() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount4.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount5() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount5.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount6() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount6.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount7() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount7.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount8() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount8.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount9() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount9.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount10() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount10.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount11() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount11.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount12() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount12.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount13() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount13.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount14() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount14.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount15() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount15.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount16() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount16.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount17() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount17.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount18() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount18.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount19() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount19.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

	@Test
	public void testWordCount20() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("testWordCount20.txt"));
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		wcPro.wordCount(in, resultMap);
		assertEquals(expectMap, resultMap);
	}

}

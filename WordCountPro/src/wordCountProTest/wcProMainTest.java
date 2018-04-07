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
	
	
	//����Ϊ�˱Ƚ�����map�е������Ƿ���ͬ������д��equals����	��������������������
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
	
	//ÿ������֮ǰ��Ҫ�������map�е����ݣ�����������������������������
	@Before
	public void setUp()
	{
		expectMap.clear();
		resultMap.clear();
	}
	
	
	@Test
	public void testWordCount() throws FileNotFoundException {
		
		//testWordCount.txt�д�ŵ��Ǵ����Ե��ı�,�����������£�
		/*"Are you ok"
		   ,O-K
		   i am ok-34; hehe01
		   I AM fiNE(HaHa)!
		 */
		BufferedReader in = new BufferedReader(new FileReader("testWordCount.txt"));
		
		//���������ڴ���ͳ�ƽ�������ÿ������˳�򣬶����ı��������Ѿ��Զ��������Сд����
		//��������ڴ��Ľ������Сд��ĸ�ĵ���
		expectMap.put("are", 1);
		expectMap.put("you", 1);
		expectMap.put("ok", 3);
		expectMap.put("i", 2);
		expectMap.put("am", 2);
		expectMap.put("hehe", 1);
		expectMap.put("fine", 1);
		expectMap.put("haha", 1);
		
		//����wcProMain�е�wordCout�����������д�� resultMap��
		wcPro.wordCount(in, resultMap);
		
		//�ж�ʵ��ͳ�ƽ����Ԥ�ڵĽ���Ƿ���ͬ
		assertEquals(expectMap, resultMap);
		
	}

}

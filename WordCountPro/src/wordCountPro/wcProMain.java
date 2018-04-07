package wordCountPro;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class wcProMain {


	public static void main(String[] args) {
		wcProMain wcPro = new wcProMain();
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		//对输入进行处理
		BufferedReader in = wcProInput.getInput(args);
		
		//对单词词频进行统计
		wcPro.wordCount(in, map);
		
		//将单词统计结果按照要求写入指定的 result.txt 文件中
		wcProOutput.output(map,"result.txt");
	}
	
	
	public void wordCount(BufferedReader in, Map<String,Integer> map)
	{
		String s;
		try {
			while((s = in.readLine())!=null)
			{
				String ss[] = s.trim().split("~|`|!|#|%|\\^|&|\\*|_|\\(|\\)|\\\\"
	        			+ "|\\[|\\]|\\+|=|:|;|\"|'|\\||<|>|,|\\.|\\/|\\?"
	        			+ "| |\n|\t");
				int len = ss.length;
				String tmp;
				for(int i=0;i<len;i++)
				{
					tmp = ss[i].toLowerCase().replaceAll("-|\\d+","");
					if(!tmp.trim().equals(""))
						if(null==map.get(tmp))
							map.put(tmp, 1);
						else map.put(tmp, map.get(tmp).intValue()+1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读取过程中出错！！！");
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

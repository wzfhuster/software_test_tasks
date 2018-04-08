package wordCountPro;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class wcProMain {


	public static void main(String[] args) {
		wcProMain wcPro = new wcProMain();
		Map<String,Integer> map = new HashMap<String,Integer>(); 
		
		//模块1：对输入进行处理
		BufferedReader in = wcProInput.getInput(args);
		
		//模块2：对单词词频进行统计
		wcPro.wordCount(in, map);
		
		//模块3：将单词统计结果排序后，按照要求写入指定的 result.txt 文件中
		wcProOutput.output(map,"result.txt");
	}
	
	
	public void wordCount(BufferedReader in, Map<String,Integer> map)
	{
		String s;
		try {
			//使用readline（）函数一行一行的读取文本处理
			while((s = in.readLine())!=null)
			{
				//使用split函数来分隔字符串
				String ss[] = s.trim().split("~|`|!|#|%|\\^|&|\\*|_|\\(|\\)|\\\\"
	        			+ "|\\[|\\]|\\+|=|:|;|\"|'|\\||<|>|,|\\.|\\/|\\?"
	        			+ "| |\n|\t");
				int len = ss.length;
				String tmp;
				for(int i=0;i<len;i++)
				{
					//将单词中的-和数字等都消除掉
					tmp = ss[i].toLowerCase().replaceAll("-|\\d+","");
					//对于非空的字符串就加入map中
					if(!tmp.trim().equals(""))
						if(null==map.get(tmp))
							//map中没有该单词的时候，就加入该单词，并将计数器设为1
							map.put(tmp, 1);
						else 
							//map中存在该单词的时候，就对计数器进行加一更新
							map.put(tmp, map.get(tmp).intValue()+1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件读取过程中出错！！！");
		}finally {
			try {
				//最后别忘了要关闭获取的流对象 ！ ！ ！
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

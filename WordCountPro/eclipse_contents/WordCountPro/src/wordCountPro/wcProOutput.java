package wordCountPro;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class wcProOutput {

	/*
	 * 次函数用来将单词统计的情况输出到指定的 result.txt 文件中
	 * 该函数传入的参数为：一个map，统计了每个单词和单词对应的个数的一个map
	 * 然后对map进行排序后写入文件中
	 * 
	 * */
	public static String output(Map<String, Integer> map,String filename)
	{
		FileWriter w = null;
		List<Map.Entry<String, Integer>> list = null;
		String s = "";
		try {
			w = new FileWriter(filename);
			 
			// 通过ArrayList构造函数把map.entrySet()转换成list
			list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
			// 通过比较器实现比较排序
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			    public int compare(Map.Entry<String, Integer> map1, Map.Entry<String, Integer> map2) {
			    	
			    	//在这里优先使用单词的个数由大到小的排序
			    	if(map1.getValue()>map2.getValue()) 
			    		return -1;
			    	else if(map1.getValue()<map2.getValue()) 
			    		return 1;
			    	else //单词的词频相同时，按照单词字母排序
			    		return map1.getKey().compareTo(map2.getKey());
			    }
			});
			int i=0;
			int len = list.size();
			//这里按照顺序写入文件，当单词个数超过100个时候，写入前100个
			for(;i<len-1&&i<99;i++)
			{
//			    System.out.println(list.get(i).getKey().toLowerCase() + " " + list.get(i).getValue());
//			    System.out.println();
				w.write(list.get(i).getKey() + " " + list.get(i).getValue()+"\r\n\r\n");
				s+=(list.get(i).getKey() + " " + list.get(i).getValue()+" \n ");
			}
			//输出文件末尾多余的换行符应去除
			if(len>0)
			{
//				System.out.println(list.get(i).getKey().toLowerCase() + " " + list.get(i).getValue());	
				w.write(list.get(i).getKey() + " " + list.get(i).getValue());
				s+=(list.get(i).getKey() + " " + list.get(i).getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("文件写入错误！！！");
		}finally{
			try {
				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
}

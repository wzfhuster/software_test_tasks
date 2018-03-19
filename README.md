# software_test_tasks

### 在WordCount中有三个目录：
*   BIN：里面存放的是 wc.exe和一些测试文件，注意wc.exe运行需要有jre的环境，我的jre有180M太大就不上传了
*   eclipse_contents：这个是在eclipse环境下编码的项目目录
*   src：里面是java的源代码  
<br>
<br><br><br>  

## github地址：

[https://github.com/wzfhuster/software_test_tasks](https://github.com/wzfhuster/software_test_tasks)  
<br>

## psp表格：
| PSP2.1 | 	PSP 阶段 | 	预估耗时 （分钟） | 实际耗时 （分钟） |
| - | :-: | :-: | -: | 
| Planning | 计划 | 30 | 20 |
| · Estimate | · 估计这个任务需要多少时间	 | 50 | 40 |
| Development | 开发 | 300 | 400 |
| · Analysis | · 需求分析 (包括学习新技术)	 | 50 | 80 |
| · Design Spec | · 生成设计文档	 | 40 | 100 |
| · Design Review | · 设计复审 (和同事审核设计文档)	 | 60 | 50 |
| · Coding Standard | · 代码规范 (为目前的开发制定合适的规范)	 | 40 | 59 |
| · Design | · 具体设计	 | 30 | 40 |
| · Coding | · 具体编码	 | 120 | 180 |
| · Code Review | · 代码复审	 | 90 | 89 |
| · Test | · 测试（自我测试，修改代码，提交修改）	 | 60 | 189 |
| Reporting | 报告 | 120 | 150 |
| · Test Report | · 测试报告	 | 20 | 30 |
| · Size Measurement | · 计算工作量	 | 12 | 10 |
| · Postmortem & Process Improvement Plan | · 事后总结, 并提出过程改进计划	 | 50 | 60 |
|  | 	合计 | 1072 | 1497 |  
<br>

## 解题思路:
  1. **首先：** 根据需求首先最传入main函数中的args解析出对应的命令，文件名
  2. **-c命令：** 由于需求中没有明确说明我默认回车换行不算字符，然后首先用BufferedReader对象逐行的读取源文件，  
  　　　　每一行暂时保存到String对象中，然后利用String对象的length（）方法直接返回改行的字符数，然后把各行的  
      　　　　字符数都加起来，即得到总的字符数。
  3. **-w命令：** 对于计算单词数则同样，因为以换行隔开的也是单个单词，所以还是逐行读取，然后利用String对象的  
  　　　　一个split方法，就可以指定以空格,逗号作为分隔符，返回一个字符串数组，然后对字符数组的个数相加  
      　　　　　即得单词的个数
  4. **-l命令：** 这个也就很简单了，直接用readLine（）函数每读一行计数器就加一，返回总的行数
  5. **-a命令：** 这个就是在读取每一行的时候对当前行进行判断，设置三个计数器，分别记录代码行，注释行，空行的行数  
  　　　　当该行全是空格或者制表符或者不超过一个字符时就是空行，若是以//开头或者}//开头的就是注释行，否  
      　　　　　则就是代码行
  6. **-o命令：** 这个就是就是将统计结果写入一个指定的文件中，代码中可以用一个ArrayList<Stirng>来保存之前的记录结果  
  　　　　　最后再用 FileWriter 来将结果写入文件中

<br>
<br>

## 程序的设计实现过程
<br>
　　对命令的解析采用一个for循环，对传入的字符串数组的每个字符串都对其进行判断，看对应哪个命令就调用相应的处理程序进行处理，
  程序的实现我只写了一个类，在这个类中既有main函数，也有其它功能函数的实现，由于需要将多个功能的查询结果写入到一个文件中
  所以我在类中添加了一个静态的ArrayList<String>对象，当有这样的命令的时候：wc.exe -c -w -l -a test.txt -o result.txt
   每个-c，-w等命令产生的字符串输出结果都加入到ArrayList对象，当程序最后的时候再将对象中的结果一起写到result.txt中去。
<br>
<br>
<br>
<br>

## 代码说明：

```java
package wordCount;

import java.io.*;
import java.util.ArrayList;

public class WordCount {
	
	//这里创建的list用来存放每个命令处理后的输出的结果
	//用来保存这些结果，需要输出到文件时，就将list中的结果都输出到指定文件中
	public static ArrayList<String> sList = new ArrayList<String>();
	public static void main(String[] args){
		WordCount wc = new WordCount();
		if(args.length>1)
		{
		int last = args.length -1;
		String name = args[last];	//用来存放读取文件的名字
		String outputName = "";		//用来存放输出文件的名字
		String tmp;
		
		//是否将结果写入某个文件的标志
		int flag = 0;
		
		//这个for用来判断是否需要将信息输出到一个文件中
		for(int i=0;i<last;i++)
			if(args[i].equals("-o"))
			{
				flag=1;
				name = args[last-2];
				outputName = args[last];
				break;
			}
		
		//这个for用来循环读取命令行中传入的参数
		for(int i=0;i<last;i++)
			if(args[i].equals("-c")) 
				{
					tmp = new String(wc.getC(name));
					System.out.println(tmp);
					sList.add(tmp);
				}
			else if(args[i].equals("-w"))
			{
				tmp = new String(wc.getW(name));
				System.out.println(tmp);
				sList.add(tmp);
			}
			else if(args[i].equals("-l"))
			{
				tmp = new String(wc.getl(name));
				System.out.println(tmp);
				sList.add(tmp);
			}
			else if(args[i].equals("-a"))
			{
				tmp = new String(wc.geta(name));
				System.out.println(tmp);
				sList.add(tmp);
			}
		
		//如果flag=1，表示需要将结果输出到一个文件中
			if(flag==1)
			{
				wc.writeFile(outputName);
				System.out.println();
				System.out.println("将信息写入"+outputName+"文件成功！！！");
			}
		}else
			System.out.println("请先输入参数！！！");   //如果wc.exe后面没有输入参数，就打印提示信息
				
	}
	
	
	//该函数用来计算指定文件中字符的个数，《其中回车换行都没计入字符数中！！！》
	public String getC(String fileName)
	{
		int count=0;
		String s;
		int c;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			//FileReader in = new FileReader(fileName);
			while((s=in.readLine())!=null)
				count+=s.length();
			in.close();
		} catch (FileNotFoundException e1) {
			System.out.println("找不到文件!!!");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName+", 字符数为："+count;
	}
	
	
	//该函数用来计算指定文件中单词的个数
	public String getW(String fileName)
	{
		int count=0;
		String s;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			while((s = in.readLine())!=null)
			{
				if(!s.isEmpty())
					{
						String ss []  = s.trim().split(" |,|	");
						count+=ss.length;
					}
			}
			in.close();
		} catch (FileNotFoundException e1) {
			System.out.println("找不到文件!!!");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName+", 单词数为："+count;
	}
	
	//该函数用来计算指定文件中的总的行数，包括空的行和注释行
	public String getl(String fileName)
	{
		int count=0;
		String s;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			while((s = in.readLine())!=null)
				++count;
			in.close();
		} catch (FileNotFoundException e1) {
			System.out.println("找不到文件!!!");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName+", 总的行数为："+count;
	}
	
	
	//该函数用来返回具体的代码行数，注释行数和空的行数！！！
	public String geta(String fileName)
	{
		int count=0,space=0,h=0;
		String s;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			while((s = in.readLine())!=null)
			{
				if(s.isEmpty() || s.trim().length()<=1) ++space;
				else
				{
					int t=0;
					while(t<s.length()&&s.charAt(t)==' ') ++t;
					if((t+1<s.length() && s.charAt(t)=='/' && s.charAt(t+1)=='/')
							|| (t+2<s.length() && s.charAt(t+1)=='/' && s.charAt(t+2)=='/')) ++h;
					else
						++count;
				}
			}
			in.close();
		} catch (FileNotFoundException e1) {
			System.out.println("找不到文件!!!");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName+", 代码行/空行/注释行:"+count+"/"+space+"/"+h;
	}
	
	//该行数用来将结果写入指定的文件中
	public void writeFile(String fileName)
	{
		try {
			FileWriter w = new FileWriter(fileName);
			int i=0;
			for(;i < sList.size();i++)
				{
					w.write(sList.get(i));
					w.write("\r\n");
				}
			w.close();
		} catch (IOException e) {
			System.out.println("呵呵，在写文件过程中出现了错误！！！");
			e.printStackTrace();
		}
	}
	
}
```
<br>
<br>

## 测试设计过程
<br>

1. **测试没有参数输入的情况：**
    * wc.exe
2. **测试单个功能：**
    * wc.exe -c test.txt
    * wc.exe -w test.txt
    * wc.exe -l test.txt
    * wc.exe -a test.txt
    * wc.exe -c test.txt -o output.txt<br>
3. **测试组合的输入功能：**
    * wc.exe -c -w test.txt
    * wc.exe -c -l test.txt
    * wc.exe -w -l test.txt
    * wc.exe -c -w -l test.txt
    * wc.exe -a test.txt -o output.txt
4. **测试文件的绝对路径和相对路径：**
    * wc.exe -c D:/test.txt
    * wc.exe -c test.txt
    * wc.exe -c D:/test.txt -o D:/output.txt
    * wc.exe -c D:/test.txt -o output.txt
5. **测试错误参数的输入：**
    * wc.exe -c
    * wc.exe test.txt -c
    * ...
<br>
<br>

## 参考文献链接
[http://blog.csdn.net/tw19811220/article/details/41040937](http://blog.csdn.net/tw19811220/article/details/41040937)  
[http://blog.csdn.net/etjnety/article/details/7842618](http://blog.csdn.net/etjnety/article/details/7842618)  
[http://www.cnblogs.com/math/p/se-tools-001.html](http://www.cnblogs.com/math/p/se-tools-001.html)

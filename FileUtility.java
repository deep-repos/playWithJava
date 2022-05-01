package myProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class FileUtility {

	public static void main(String args[]) throws Exception {
		//Utility 1 storing characters and reading characters 
		/*String s  ="deep😀 😃 😄 😁 😆 😅 😂 🤣 ";
		String path="C:\\Users\\Deep\\Desktop\\javaCaseStduy\\TestBytes\\write1_1";
		File f =new File(path);
		//1. Storing in write1_1 file
		writeCharToFile(f,s.toCharArray());
		//2. reading from write1_1 file
		char[] charArr=readCharFromFile(f);
		String path1="C:\\Users\\Deep\\Desktop\\javaCaseStduy\\TestBytes\\write1_2";
		//3. Storing in write1_2 file
		File f1 =new File(path1);
		writeCharToFile(f1,charArr);
		*/
		
		
		
		//Utility 2 storing bytes and reading bytes
		/*String s  ="deep😀 😃 😄 😁 😆 😅 😂 🤣 ";
		String path="C:\\Users\\Deep\\Desktop\\javaCaseStduy\\TestBytes\\write2_1";
		File f =new File(path);
		//1. Storing in write2_1 file
		writeUTF_8BytesToFile(f,s);
		//2. reading from write2_1 file
		LinkedList<String> ls = read_proper_bytes_from_UTF_8_file(f);
		
		String path1="C:\\Users\\Deep\\Desktop\\javaCaseStduy\\TestBytes\\write2_2";
		//3. Storing in write2_2 file
		File f1 =new File(path1);
		write_UTF_8_bytes_to_file(f1,ls);
		*/
		
		
		
		
	}


	public static void writeCharToFile(File destinationFile,char []charArr) throws Exception{
		FileWriter fw =new FileWriter(destinationFile);
			for(char c: charArr) {
				fw.append(c);
			}
		
			fw.close();
	}
	public static char[] readCharFromFile(File sourceFile) throws Exception {
		FileInputStream fis =new FileInputStream(sourceFile);
		
		InputStreamReader isr = new InputStreamReader(fis);
		
		char arr[] =new char[1024];
		int index =0;
		int c =0;
		
		while((c=isr.read())!=-1) {
			arr[index]=(char)c;	
			index++;
		}

		isr.close();

		return arr;
		
	}
	
	public static  void writeUTF_8BytesToFile(File destinationFile,String source) throws Exception {
		
		byte byteArr[] = source.getBytes("UTF-8");
		FileOutputStream fos =new FileOutputStream(destinationFile);
		fos.write(byteArr);
		fos.close();
		
	}
	
	

	public static void writeCharToFileForLargeData(File destinationFile,LinkedList<Character>charArr) throws Exception{
			FileWriter fw =new FileWriter(destinationFile);
			char c=' ';
			while(charArr.size()>0) {
				c = charArr.remove();
				fw.append(c);
			}	

			fw.close();
	}
	
	public static LinkedList<Character> readCharFromFileForLargeData(File sourceFile) throws Exception {
		FileInputStream fis =new FileInputStream(sourceFile);
		
		InputStreamReader isr = new InputStreamReader(fis);
		int c =0;
		
		LinkedList<Character> list = new LinkedList<Character>();
		
		while((c=isr.read())!=-1) {
			list.add((char)c);
		}

		isr.close();

		return list;
		
	}

	
	public static LinkedList<String>  read_proper_bytes_from_UTF_8_file(File source)  throws Exception{
		FileInputStream fis = new  FileInputStream(source);
		byte arr[] =new byte[1024];
		
		LinkedList<String> ll =new LinkedList<String>();
		
		while(fis.read(arr)!=-1) {
			 String str = new String(arr, "UTF-8");
			 ll.add(str);
		}
		
		fis.close();
		return ll;
		
	}
	
	
	public static void  write_UTF_8_bytes_to_file(File destinationFile,LinkedList<String> ll)  throws Exception{
		for(String i: ll) {
			writeUTF_8BytesToFile(destinationFile,i);
			
		}
		
	}
}

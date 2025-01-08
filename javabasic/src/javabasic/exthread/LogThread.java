package javabasic.exthread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LogThread extends Thread{

	@Override
	public void run() {
	
	Scanner scanner = new Scanner(System.in);
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("[yyyy/MM/dd HH:mm:ss]");
	File file = new File("D:\\embededk\\files\\inputstring.log");
	FileWriter fw = null;
	
	PrintWriter pw = null;
	
	try {
		pw = new PrintWriter(file);
		fw = new FileWriter(file, true);
		pw.print(sdf.format(date));
		pw.print("-");
		pw.print(scanner.next());
		fw.flush();
		fw.close();
		pw.flush();
		pw.close();
		
	} catch (FileNotFoundException fnfe) {
		fnfe.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	
	scanner.close();
	
	}// run
}// class

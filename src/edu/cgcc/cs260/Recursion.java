package edu.cgcc.cs260;
import java.util.LinkedList; 
import java.util.Queue;
import java.util.Stack;
import java.io.File;
import java.io.IOException;

public class Recursion {
	public static Queue<String> q = new LinkedList<>();
	public static File root = new File("C:\\Users\\podium\\eclipse-workspace");
	
	
	//With recursion
	public static void recursionGet(File dir) {
		//pay attention to errors
		try {
			//get list of files and folders
			File[] files = dir.listFiles();
			
			//go through the contents of each folder
			for (File file : files) {
				
				//if its a folder, recurse through it
				if (file.isDirectory()) {
					recursionGet(file);
				} 
				//otherwise add to queue
				else {
					q.add(file.getCanonicalPath());
				}
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void iterativeGet(File file) {
		//housekeeping
		q.clear();
		Stack<File> stack = new Stack<File>();
		stack.push(file);
		
		//pay attention to errors
		try {
			
			//iterate through the stack used to track folders
			while(!stack.isEmpty()) {
				//pop child from stack
				File child = stack.pop();
				
				//If the child is a directory, loop through its children
				if(child.isDirectory()) {
					//foreach child in parent
					for(File f : child.listFiles())
						stack.push(f); //push the child to stack for reference
				}
				//otherwise its a file
				else if(child.isFile()){
					//add file to queue for external processing
					q.add(child.getCanonicalPath());
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}

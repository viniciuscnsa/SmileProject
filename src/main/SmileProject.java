package main;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.swing.JFrame;

import gui.mainScreen;

public class SmileProject {
	
	protected static ArrayList<String> imagesDB = new ArrayList<String>(); 
	public static String path1;
	public static String path2;
	public static String path3;
	static JFrame f;
	public int right = 0;
	public int wrong = 0;

	public static void main(String[] args){

		loadImages();
		randomImages();

		try {
			mainScreen screen = new mainScreen(path1, path2, path3);
			screen.play();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void loadImages() {
		//System.out.println("Loading images..."); 
		
		String path = "src/images/originalimages";
		
		try (Stream<Path> paths = Files.walk(Paths.get(path))){
			paths.forEach(filePath -> {
				if(Files.isRegularFile(filePath)) {
					try {
						imagesDB.add(filePath.toString());
					}catch(Exception e){
						e.printStackTrace();
					} 
				}
			});
		} catch(IOException e) {
			e.printStackTrace(); 
		}
	}
	
	public static void randomImages() {
		//System.out.println("Getting Random images");
	
		Integer index1 = (int)(Math.random() * ((imagesDB.size() - 0) + 1)) + 0;
		Integer index2 = (int)(Math.random() * ((imagesDB.size() - 0) + 1)) + 0;
		Integer index3 = (int)(Math.random() * ((imagesDB.size() - 0) + 1)) + 0;
		
		if(index1 != index2 && index1 != index3 && index2 != index3) {
			path1 = imagesDB.get(index1);
			path2 = imagesDB.get(index2);
			path3 = imagesDB.get(index3);
		}else {
			randomImages();
		}
		//System.out.println(index1 + " " + index2 + " " + index3);
	}
	
	public void awnser(String path) {
		int aux = Integer.parseInt(path.substring(path.length()-5, path.length()-4));
		if(aux/2 == 1) {
			right = right + 1;
		}else {
			wrong = wrong + 1;
		}	
		//System.out.println("right: " + right + " Wrong: " + wrong);	
	}
	

}

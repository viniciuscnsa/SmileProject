package br.com.main;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.swing.JFrame;

import br.com.gui.mainScreen;

public class SmileProject {
	
	protected static ArrayList<String> imagesDB = new ArrayList<String>(); 
	protected static String path1;
	protected static String path2;
	protected static String path3;
	protected static JFrame f;
	protected int right = 0;
	protected int wrong = 0;

	public static void main(String[] args){

		loadImages();
		randomImages();

		try {
			mainScreen screen = new mainScreen(path1, path2, path3);
			screen.play();
		} catch (IOException e) {
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
	
	public static String getPath1() {
		return path1;
	}

	public static void setPath1(String path1) {
		SmileProject.path1 = path1;
	}

	public static String getPath2() {
		return path2;
	}

	public static void setPath2(String path2) {
		SmileProject.path2 = path2;
	}

	public static String getPath3() {
		return path3;
	}

	public static void setPath3(String path3) {
		SmileProject.path3 = path3;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getWrong() {
		return wrong;
	}

	public void setWrong(int wrong) {
		this.wrong = wrong;
	}
	

}

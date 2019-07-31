package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
//import images.originalimages.*;

public class DeleteFiles {

	public static void main(String[] args) throws IOException {
		//listAllFiles("src/images/originalimages");
	}
	
	public static void listAllFiles(String path) throws IOException {
		System.out.println("List All Files Started!");
		try (Stream<Path> paths = Files.walk(Paths.get(path))){
			paths.forEach(filePath -> {
				if(Files.isRegularFile(filePath)) {
					try {
						cleanFiles(filePath.toString());
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			});
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("List All Files Finished!");
	}
	
	public static void cleanFiles(String path) {
		System.out.println("  Clean Files Started!");
		int size = path.length();
		String controll = path.substring(size-6, size-4);
		File file = new File(path);
		if(!controll.equals("11") && !controll.equals("12")) {
			if(file.delete()) {
				System.out.println("   " + path + " DELETED");
			}else {
				System.out.println("   " + path + " DOESN'T EXISTS");
			}
		}
		System.out.println("  Clean Files Finished!");
	}

}

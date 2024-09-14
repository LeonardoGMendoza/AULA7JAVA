package section5_1;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Path[] paths = new Path[5];
		paths[0] = Paths.get("C:\\Java Programing\\NI02\\DemorFile.txt");
		paths[1] = Paths.get("C:/Java Programing/NI02/DemorFile.txt");
		paths[2] = Paths.get("C:\\Java Programing", "NI02" ,"DemorFile.txt");
		paths[3] = Paths.get("DemorFile.txt");
		paths[4] = Paths.get(URI.create("file:///~/DemoFile.txt"));
	}

}

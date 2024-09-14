package section5_1;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.print.attribute.URISyntax;

public class PathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Path[] paths = new Path[5];
		paths[0] = Paths.get("C:\\Java Programing\\NI02\\DemorFile.txt");
		paths[1] = Paths.get("C:/Java Programing/NI02/DemorFile.txt");
		paths[2] = Paths.get("C:\\Java Programing", "NI02" ,"DemorFile.txt");
		paths[3] = Paths.get("DemorFile.txt");
		paths[4] = Paths.get(URI.create("file:///~/DemoFile.txt"));
	
	for(int i =0; i < paths.length; i++) {
		System.out.println("Caminho do path["+ i +"]:" + paths[i]);
	}
	System.out.println(paths[0].getFileName());
	System.out.println(paths[0].getParent());
	System.out.println(paths[0].getNameCount());
	System.out.println(paths[4].isAbsolute());
	System.out.println(paths[3].toAbsolutePath());
	System.out.println(paths[4].toAbsolutePath());
	System.out.println(paths[0].toFile());
	System.out.println(paths[0].toUri());
	
	

	
	Path rp =  Paths.get("C:/Java Programing/IO/../NIO2/DemoFile.txt");
	System.out.println("rp.normalize() ["+rp.normalize() + "]");
	
	Path sp = Paths.get("C:/Java Programing/IO/../NIO2/DemoFile.txt");
	System.out.println(sp.subpath(0, 5));
	System.out.println(sp.getNameCount() + "" + sp.subpath(0, 3));
	System.out.println(sp.subpath(0, 3));
	System.out.println(sp.normalize().subpath(0, 3));
  }
}

/*package section5_1;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {

    public static void main(String[] args) {
        Path[] paths = new Path[5];
        paths[0] = Paths.get("C:\\Java Programing\\NI02\\DemorFile.txt");
        paths[1] = Paths.get("C:/Java Programing/NI02/DemorFile.txt");
        paths[2] = Paths.get("C:\\Java Programing", "NI02", "DemorFile.txt");
        paths[3] = Paths.get("DemorFile.txt");
        paths[4] = Paths.get(URI.create("file:///~/DemoFile.txt"));

        for (int i = 0; i < paths.length; i++) {
            System.out.println("Caminho do path[" + i + "]:" + paths[i]);
        }

        // Exibir a raiz do caminho para o path[0]
        Path root = paths[0].getRoot();
        System.out.println("Raiz do caminho: " + root);

        // Exibir o nome do arquivo
        System.out.println("Nome do arquivo: " + paths[0].getFileName());

        // Exibir o pai do caminho
        System.out.println("Caminho pai: " + paths[0].getParent());

        // Exibir a contagem de nomes no caminho
        System.out.println("Número de componentes no caminho: " + paths[0].getNameCount());

        // Verificar se o caminho é absoluto
        System.out.println("O caminho é absoluto? " + paths[4].isAbsolute());

        // Exibir o caminho absoluto
        System.out.println("Caminho absoluto do path[3]: " + paths[3].toAbsolutePath());
        System.out.println("Caminho absoluto do path[4]: " + paths[4].toAbsolutePath());

        // Exibir o arquivo correspondente
        System.out.println("Arquivo correspondente ao path[0]: " + paths[0].toFile());

        // Exibir o URI correspondente
        System.out.println("URI correspondente ao path[0]: " + paths[0].toUri());

        // Normalizar o caminho
        Path rp = Paths.get("C:/Java Programing/IO/../NIO2/DemoFile.txt");
        System.out.println("rp.normalize(): [" + rp.normalize() + "]");

        // Exibir subcaminho com a raiz
        Path sp = Paths.get("C:/Java Programing/IO/../NIO2/DemoFile.txt");
        System.out.println("Subcaminho normalizado (0 a 3): " + sp.subpath(0, 3));
        
        // Exibir a raiz do caminho
        String fullPath = sp.toString();
        String[] parts = fullPath.split("\\\\|/");
        System.out.println("Raiz do caminho: " + parts[0] + ":\\");
    }
}
*/

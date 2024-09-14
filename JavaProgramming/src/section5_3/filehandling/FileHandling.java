package section5_3.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileHandling {

    public static void main(String[] args) {
        ArrayList<String> employees = new ArrayList<>();
        readFile(employees);
        displayEmployees(employees);
        //writeFile(employees);
    }

    public static void displayEmployees(ArrayList<String> employees) {
        for (String employee : employees) {
            System.out.println(employee);
        }
    }

    public static void readFile(ArrayList<String> employees) {
        String line = "";
        Path path = Paths.get("C:/Java Programing/usernames.txt");
        try (BufferedReader fileInput = Files.newBufferedReader(path, Charset.forName("UTF-16"))) {
            line = fileInput.readLine();
            while (line != null) {
                employees.add(line);  // Adiciona cada linha lida à lista de funcionários
                line = fileInput.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo!");
        }
    }
    
    public static void writeFile(ArrayList<String>employees) {
    	Path path = Paths.get("C:/Java Programing/usernames.txt");
    	try {
    		BufferedWriter fileOutput  = Files.newBufferedWriter(path, Charset.forName("UTF-16"),
    				StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    		
    		for(String employee : employees) {
    			fileOutput.write(employee);
    			fileOutput.newLine();
    		}
    		fileOutput.close();	
    	}catch(IOException e) {
    		
    		System.out.println("Erro ao escrever um arquivo");
    	}
    	System.exit(0);
    }
}

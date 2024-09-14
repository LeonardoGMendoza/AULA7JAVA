package section5_2.filereading;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> employees = new ArrayList();
		readFile(employees);
		displayEmployees(employees);
		
		
	}
	
	public static void displayEmployees(ArrayList<String> employees) {
		for(String employee : employees) {
			System.out.println(employee);
		}
	}
	public static void readFile(ArrayList<String>employees) {
		String line ="";
		BufferedReader fileInput = null;
		try {
			fileInput = new BufferedReader(new FileReader( new File("C:/Java Programing/employees.txt")));
			line = fileInput.readLine();
			while(line != null) {
				employees.add(line);
				line = fileInput.readLine();
			}
			fileInput.close();
		}catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
	}catch(EOFException e) {
		System.out.println("Não há lineas para leer!");
	}catch(IOException e) {
		System.out.println("Erro ao leer o arquivo!");
	}
  }
}
package section5_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerenciadordedados {
    private List<Item> items;
    private Scanner scanner;
    private int nextId; // ID automático
    private static final String FILE_NAME = "items.txt"; // Nome do arquivo para gravar os dados

    public Gerenciadordedados() {
        items = new ArrayList<>();
        scanner = new Scanner(System.in);
        nextId = 1; // Inicializa o ID automático
        loadItems(); // Carregar itens do arquivo, se existirem
    }

    // Cadastrar um novo item com ID automático
    public void cadastrar() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item description: ");
        String description = scanner.nextLine();
        items.add(new Item(nextId++, name, description)); // Atribui o ID e incrementa
        System.out.println("Item added successfully.");
    }

    // Listar todos os itens
    public void listar() {
        if (items.isEmpty()) {
            System.out.println("No items to display.");
        } else {
            System.out.println("Items:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    // Pesquisar um item pelo ID
    public void pesquisar() {
        System.out.print("Enter item ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        for (Item item : items) {
            if (item.getId() == id) {
                System.out.println("Item found: " + item);
                return;
            }
        }
        System.out.println("Item not found.");
    }

    // Alterar um item existente
    public void alterar() {
        System.out.print("Enter item ID to modify: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        for (Item item : items) {
            if (item.getId() == id) {
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new description: ");
                String description = scanner.nextLine();
                items.remove(item);
                items.add(new Item(id, name, description)); // Atualiza o item mantendo o ID
                System.out.println("Item updated successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    // Excluir um item
    public void excluir() {
        System.out.print("Enter item ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        for (Item item : items) {
            if (item.getId() == id) {
                items.remove(item);
                System.out.println("Item deleted successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    // Gravar dados em um arquivo
    public void gravar() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Item item : items) {
                writer.write(item.getId() + "," + item.getName() + "," + item.getDescription());
                writer.newLine();
            }
            System.out.println("Items saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving items: " + e.getMessage());
        }
    }


    private void loadItems() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        int id = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        String description = parts[2];
                        items.add(new Item(id, name, description));
                        nextId = Math.max(nextId, id + 1); // Atualiza nextId para o próximo valor disponível
                    }
                }
            } catch (IOException e) {
                System.out.println("Error loading items: " + e.getMessage());
            }
        }
    }

    // Fechar o scanner
    public void close() {
        scanner.close();
    }
}

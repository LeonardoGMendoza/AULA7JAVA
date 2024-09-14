package section5_1;

import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        Gerenciadordedados gerenciadordedados = new Gerenciadordedados();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Pesquisar");
            System.out.println("4. Alterar");
            System.out.println("5. Excluir");
            System.out.println("6. Gravar");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                	gerenciadordedados.cadastrar();
                    break;
                case 2:
                	gerenciadordedados.listar();
                    break;
                case 3:
                	gerenciadordedados.pesquisar();
                    break;
                case 4:
                	gerenciadordedados.alterar();
                    break;
                case 5:
                	gerenciadordedados.excluir();
                    break;
                case 6:
                	gerenciadordedados.gravar();
                    break;
                case 7:
                    System.out.println("Saindo do programa...");
                    gerenciadordedados.gravar(); // Gravando antes de sair
                    gerenciadordedados.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}

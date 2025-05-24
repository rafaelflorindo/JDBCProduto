import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU PRODUTOS =====");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Excluir Produto");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    dao.inserir(new Produto(nome, descricao, quantidade, preco));
                    break;

                case 2:
                    List<Produto> lista = dao.listarTodos();
                    System.out.println("\n--- Lista de Produtos ---");
                    for (Produto p : lista) {
                        System.out.println(p.getId() + " - " + p.getNome() + " - R$ " + p.getPreco());
                    }
                    break;

                case 3:
                    System.out.print("ID do produto a atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer

                    System.out.print("Nome do produto: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String novoDescricao = scanner.nextLine();

                    System.out.print("Quantidade: ");
                    int novoQuantidade = scanner.nextInt();
                    System.out.print("Preço: ");

                    double novoPreco = scanner.nextDouble();

                    Produto atualizado = new Produto(novoNome, novoDescricao, novoQuantidade, novoPreco);
                    atualizado.setId(idAtualizar);
                    dao.atualizar(atualizado);
                    break;

                case 4:
                    System.out.print("ID do produto a excluir: ");
                    int idExcluir = scanner.nextInt();
                    dao.excluir(idExcluir);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}

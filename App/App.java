import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    // ------------------------------------------------------------------------------
    // ADICIONANDO ITENS AO MENU
    // ------------------------------------------------------------------------------

    Gerente gerente = new Gerente();
    List<Integer> produtosComboSolo = List.of(1, 2, 5);
    List<Integer> produtosComboFml = List.of(6, 6, 6, 6);
    gerente.criaProdutoIndividual("Coca-Cola", 5.0, 1);
    gerente.criaProdutoIndividual("Pepsi", 4.0, 2);
    gerente.criaProdutoIndividual("Hamburger Costela", 32.0, 2);
    gerente.criaProdutoIndividual("Hamburger Frango", 25.0, 3);
    gerente.criaProdutoIndividual("Hamburger Vegetariano", 30.0, 4);
    gerente.criaProdutoIndividual("Batata Frita", 15.0, 5);
    gerente.criaCombo("combo solo", 6, produtosComboSolo, 10);
    gerente.criaCombo("combo familia", 7, produtosComboFml, 10);

    // ------------------------------------------------------------------------------
    // SISTEMA DE TERMINAL
    // ------------------------------------------------------------------------------

    // Escolher se o usuario é gerente ou cliente pelo terminal e scanner
    System.out.println("Digite 1 para usar o sistema como gerente e 2 para cliente");
    Scanner scanner = new Scanner(System.in);
    int opcao = scanner.nextInt();

    if (opcao == 1) {
      sistemaGerente();
    } else if (opcao == 2) {
      sistemaCliente();
    } else {
      System.out.println("Opção inválida");
    }

  }

  public static void sistemaGerente() {
    // loop para criação de um menu que permite ao gerente
    // criar produtos, remover produtos e visualizar a lista completa de produtos
    boolean sair = false;
    Scanner scanner = new Scanner(System.in);
    while (!sair) {
      System.out.println(
          "Digite 1 para criar um produto, 2 para remover um produto, 3 para visualizar a lista de produtos, 4 para criar um combo e 5 para sair");
      int opcao = scanner.nextInt();
      if (opcao == 1) {
        System.out.println("Digite o nome do produto");
        scanner.nextLine();
        String nome = scanner.nextLine();
        System.out.println("Digite o preço do produto");
        double preco = scanner.nextDouble();
        System.out.println("Digite o id do produto");
        int id = scanner.nextInt();
        Gerente gerente = new Gerente();
        gerente.criaProdutoIndividual(nome, preco, id);
      } else if (opcao == 2) {
        System.out.println("Digite o id do produto que deseja remover");
        int id = scanner.nextInt();
        ListaProdutos lista = ListaProdutos.getInstancia();
        lista.removeProduto(id);
      } else if (opcao == 3) {
        ListaProdutos lista = ListaProdutos.getInstancia();
        System.out.println(lista.toString());
      } else if (opcao == 4) {
        System.out.println("Digite o nome do combo");
        scanner.nextLine();
        String nome = scanner.nextLine();
        System.out.println("Digite o id do combo");
        int id = scanner.nextInt();
        System.out.println("Digite o id dos produtos que compõem o combo separados por espaço");
        scanner.nextLine();
        String ids = scanner.nextLine();
        System.out.println("Digite o desconto do combo");
        int desconto = scanner.nextInt();
        Gerente gerente = new Gerente();

        // Transforma a string de ids em uma lista de inteiros
        List<Integer> idsFilhos = List.of(ids.split(" ")).stream().map(Integer::parseInt).toList();

        gerente.criaCombo(nome, id, idsFilhos, desconto);
      } else if (opcao == 5) {
        sair = true;
      } else {
        System.out.println("Opção inválida");
      }
    }
    scanner.close();
  }

  public static void sistemaCliente() {
    // loop para criação de um menu que permite ao cliente
    // adicionar produtos ao carrinho e gerar um recibo e ver a lista de produtos
    boolean sair = false;
    Scanner scanner = new Scanner(System.in);
    Cliente cliente = new Cliente();
    while (!sair) {
      System.out.println(
          "Digite 1 para adicionar um produto ao carrinho, 2 para gerar um recibo, 3 para visualizar a lista de produtos e 4 para sair");
      int opcao = scanner.nextInt();
      if (opcao == 1) {
        System.out.println("Digite o id do produto que deseja adicionar ao carrinho");
        int id = scanner.nextInt();
        cliente.adicionaProduto(id);
      } else if (opcao == 2) {
        System.out.println(cliente.geraRecibo());
      } else if (opcao == 3) {
        ListaProdutos lista = ListaProdutos.getInstancia();
        System.out.println(lista.toString());
      } else if (opcao == 4) {
        sair = true;
      } else {
        System.out.println("Opção inválida");
      }
    }
    scanner.close();
  }

}

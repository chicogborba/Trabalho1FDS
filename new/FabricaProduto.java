import java.util.List;

public class FabricaProduto {

  private static ListaProdutos listaProdutos = ListaProdutos.getInstancia();

  // Método estático para criar produto individual
  public static Produto criarProdutoIndividual(String nome, double preco, int id) {
    ProdutoIndividual produto = new ProdutoIndividual(nome, preco, id);
    listaProdutos.addProduto(produto);
    return produto;
  }

  // Método estático para criar combo
  public static Produto criarCombo(String nome, double preco, int id, List<Produto> filhos, int desconto) {
    Combo produto = new Combo(nome, preco, id, filhos, desconto);
    listaProdutos.addProduto(produto);
    return produto;
  }
}

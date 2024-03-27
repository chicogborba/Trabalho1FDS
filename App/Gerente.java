import java.util.List;

public class Gerente {

  public void criaProdutoIndividual(String nome, double preco, int id) {
    FabricaProduto.criarProdutoIndividual(nome, preco, id);
  }

  public void criaCombo(String nome, double preco, int id, List<Produto> filhos, int desconto) {
    FabricaProduto.criarCombo(nome, preco, id, filhos, desconto);
  }
}

import java.util.ArrayList;
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
  public static Produto criarCombo(String nome, int id, List<Integer> IdsDosfilhos, int desconto) {
    // Procurar os produtos filhos na lista de produtos a partir do ID
    // e adicionar à lista de produtos filhos do combo
    // aproveita o loop para calcular o preço do combo somando
    // o preço de cada um dos produtos filhos
    double precoCombo = 0;
    List<Produto> produtosFilhos = new ArrayList<>();
    for (Integer idFilho : IdsDosfilhos) {
      Produto produto = listaProdutos.getProduto(idFilho);
      if (produto != null) {
        produtosFilhos.add(produto);
        precoCombo += produto.getPreço();
      }
    }

    // Aplica o desconto ao preço do combo sendo que
    // o desconto é um inteiro que representa a porcentagem
    double precoComDesconto = precoCombo * (1 - desconto / 100.0);

    // Se a lista de produtos filhos não estiver vazia, criar o combo
    if (!produtosFilhos.isEmpty()) {
      Combo combo = new Combo(nome, precoComDesconto, id, produtosFilhos, desconto);
      listaProdutos.addProduto(combo);
      return combo;
    } else {
      return null;
    }
  }
}

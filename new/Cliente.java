import java.util.ArrayList;
import java.util.List;

public class Cliente {

  private List<Produto> carrinho = new ArrayList<Produto>();

  public String geraRecibo() {
    double total = 0;
    StringBuilder recibo = new StringBuilder();
    for (Produto produto : carrinho) {
      recibo.append(produto.getName() + " - " + produto.getPreço() + "\n");
      total += produto.getPreço();
    }
    recibo.append("Total: " + total);
    return recibo.toString();
  }

  public void adicionaProduto(int id) {
    Produto produto = ListaProdutos.getInstancia().getProduto(id);
    if (produto != null) {
      carrinho.add(produto);
    }

  }

}

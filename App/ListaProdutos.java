import java.util.ArrayList;
import java.util.List;

public class ListaProdutos {

  private List<Produto> lista;
  private static ListaProdutos instancia;

  private ListaProdutos() {
    lista = new ArrayList<Produto>();

  }

  public static ListaProdutos getInstancia() {
    if (instancia == null) {
      instancia = new ListaProdutos();
    }
    return instancia;
  }

  public void addProduto(Produto produto) {
    lista.add(produto);
  }

  public void removeProduto(int id) {
    for (Produto produto : lista) {
      if (produto.getId() == id) {
        lista.remove(produto);
        return;
      }
    }
  }

  public List<Produto> getLista() {
    return lista;
  }

  public Produto getProduto(int id) {
    for (Produto produto : lista) {
      if (produto.getId() == id) {
        return produto;
      }
    }
    return null;
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    for (Produto produto : lista) {
      str.append(produto.toString() + "\n");
    }
    return str.toString();
  }

}

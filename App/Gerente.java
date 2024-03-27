import java.util.List;

public class Gerente {

  public void criaProdutoIndividual(String nome, double preco, int id) {
    FabricaProduto.criarProdutoIndividual(nome, preco, id);
  }

  public void criaCombo(String nome, int id, List<Integer> IdsDosfilhos, int desconto) {

    FabricaProduto.criarCombo(nome, id, IdsDosfilhos, desconto);
  }
}

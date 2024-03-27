import java.util.List;

public class Combo implements Produto {
  private String nome;
  private double preço;
  private int id;

  private int desconto;
  private List<Produto> filhos;

  public Combo(String nome, double preço, int id, List<Produto> filhos, int desconto) {
    this.nome = nome;
    this.preço = preço;
    this.id = id;
    this.filhos = filhos;
    this.desconto = desconto;
  }

  public String getName() {
    return nome;
  }

  public double getPreço() {
    return preço;
  }

  public int getId() {
    return id;
  }

  public int getDesconto() {
    return desconto;
  }

  public List<Produto> getFilhos() {
    return filhos;
  }

  public String toString() {
    return "id:" + id + "  "
        + nome + " - " + preço + "\n"
        + filhos.stream()
            .map(filho -> " ".repeat(2) + "->" + filho.getName() + "\n")
            .reduce("", (a, b) -> a + b);
  }

}

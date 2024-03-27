public class ProdutoIndividual implements Produto {
  private String nome;
  private double preço;
  private int id;

  public ProdutoIndividual(String nome, double preço, int id) {
    this.nome = nome;
    this.preço = preço;
    this.id = id;
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

  public String toString() {
    return "id:" + id + "  " + nome + " - " + preço;
  }

}

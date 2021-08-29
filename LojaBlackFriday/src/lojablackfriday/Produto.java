package lojablackfriday;
public class Produto {
    private String tipo;
    private String produto;
    private double valor;
    private double desconto;

    public Produto(String tipo, String nomeProduto, double valor, double desconto) {
        this.tipo = tipo;
        this.produto = nomeProduto;
        this.valor = valor;
        this.desconto = desconto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProduto() {
        return produto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.produto = nomeProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }
    
}
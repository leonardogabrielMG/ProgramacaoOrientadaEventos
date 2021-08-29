package Modelo;
public class MVela {
    private String tipoVela;
    private double tamanho;
    private String validade;
    private double preco;
    private String fornecedor;
    private boolean castical;

    public String getTipoVela() {
        return tipoVela;
    }

    public void setTipoVela(String tipoVela) {
        this.tipoVela = tipoVela;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public boolean getCastical() {
        return castical;
    }

    public void setCastical(boolean castical) {
        this.castical = castical;
    }
    
}
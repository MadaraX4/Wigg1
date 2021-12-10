package Model;

import java.sql.Date;

public class Produto {

    private String nome;
    private double preco;
    private int quantidade;
    private String destribuidor;
    private String data_validade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDestribuidor() {
        return destribuidor;
    }

    public void setDestribuidor(String destribuidor) {
        this.destribuidor = destribuidor;
    }

    public String getData_validade() {
        return data_validade;
    }

    public void setData_validade(String data_validade) {
        this.data_validade = data_validade;
    }

    
    
    

}

package Model;

public class Cliente {
private int cod_cliente;
    private String nome;
    private String telefone;
    private String email;

    public Cliente() {
    }

    public Cliente(int cod_cliente, String nome, String telefone, String email) {
        this.cod_cliente = cod_cliente;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

package Model;



public class Servico {

    private String nome;
    private String tipo;


    public Servico(String nome, String tipo, int cod_servico) {
        this.nome = nome;
        this.tipo = tipo;
        
    }

    public Servico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
    
    

}  

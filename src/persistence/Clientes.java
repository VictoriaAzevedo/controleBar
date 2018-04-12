package persistence;

public class Clientes
{
    private String nome;
    private String cpf;
    private int idade;
    private char genero;

    
    public Clientes(String nome, String cpf, int idade, char genero) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public char getGenero() {
        return genero;
    }


    
     public String toString(){
        return "Nome:\t" + nome + 
        "\nCPF:\t" + cpf + 
        "\nIdade:\t" + idade + 
        "\nGenero:\t" + genero;
    }
    
}

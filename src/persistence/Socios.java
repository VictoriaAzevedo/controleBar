package persistence;

import persistence.Clientes;

/**
 *
 * @author Mathias Elbern
 */
public class Socios extends Clientes {
    
    private int matricula;

    public Socios(Clientes cliente, int matricula) {
        super(cliente.getNome(), cliente.getCpf(), cliente.getIdade(), cliente.getGenero());
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    

    @Override
    public String toString() {
        return super.toString() + "\nMatricula: " + matricula;
    }
    
    
}
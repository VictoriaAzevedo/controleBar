package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.time.Instant.now;
import java.util.ArrayList;
import persistence.Clientes;
import persistence.Socios;

public class Business {

    private ArrayList<Clientes> listaClienteNoBar;
    private ArrayList<Clientes> listaClienteDoDia;

    public Business() {
        listaClienteNoBar = new ArrayList<>();
        listaClienteDoDia = new ArrayList<>();
    }

    public void addCliente(Clientes c) {
        listaClienteNoBar.add(c);
        listaClienteDoDia.add(c);
    }

    public void removeCliente(String cpf) {
        boolean removido = false;
        for (Clientes c : listaClienteNoBar) {
            if (c.getCpf().equals(cpf)) {
                listaClienteNoBar.remove(c);
                System.out.println("Cliente com o cpf " + cpf + " saiu do estabelecimento.");
                removido = true;
                break;
            }
        }
        if (removido = false) {
            System.out.println("CPF nao encontrado na lista de clientes que estao no bar.");
        }
    }

    public void imprimeTodosNoBar() {
        for (Clientes c : listaClienteNoBar) {
            System.out.println(c.toString() + "\n");
            System.out.println("----------------------------------\n");
        }
    }

    public Clientes pesquisaPorNome(String nome) {
        for (Clientes c : listaClienteNoBar) {
            if (c.getNome() == nome) {
                return c;
            }
        }
        return null;
    }

    public Clientes pesquisaPorCpf(String cpf) {
        for (Clientes c : listaClienteNoBar) {
            if (c.getCpf().equals(cpf)) {
                System.out.println("Cliente encontrado: \n" + c.toString());
                return c;
            } 
        }
        System.out.println("Cliente nao encontrado.");
        
		return null;
    }

    public int numeroClientes() {
        return  listaClienteNoBar.size();
    }

    public void porcentagemClientes() {
        double contHomem = 0;
        double percentHomem = 0;
        for (Clientes c : listaClienteNoBar) {
            if (c.getGenero() == 'M') {
                contHomem = contHomem + 1;
            }
        }
        if (listaClienteNoBar.size() == 0) {
             System.out.println("Bar vazio");
        } else {
            percentHomem = contHomem * (100 / listaClienteNoBar.size());
            System.out.println("Percentual de Homens:" + percentHomem + "\n"
                    + "Percentual de Mulheres:" + (100 - percentHomem)+"\n"
            		+ "Numero de Homens: "+contHomem +"\n"+
                    "Numero de Mulheres: " + (listaClienteNoBar.size()-contHomem));
        }
    }

    public void quantidadeSociosClientes() {
        int contSocio = 0;
        int contComum = 0;
        for (Clientes c : listaClienteNoBar) {
            if (c instanceof Socios) {
                contSocio++;
            } else {
                contComum++;
            }
        }
        System.out.println("Nº Socios: " + contSocio + "\nNº Nao-Socios: " + contComum);
    }

    public void arquivoTxt() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("clientes.txt"));
            out.write("Data: " + now());
            out.newLine();
            for (Clientes c : listaClienteDoDia) {
                out.write(c.toString());
                out.newLine();
                out.write("---------------------------------------------");
                out.newLine();
            }
            out.close();
            System.out.println("Os dados dos clientes foram salvos.");
        } catch (IOException ex) {

        }
    }
    
    public ArrayList<Clientes> getListaDia(){
    	return listaClienteDoDia;
    }
    
    public ArrayList<Clientes> getListaBar(){
    	return listaClienteNoBar;
    }
}
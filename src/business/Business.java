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
                System.out.println(c.getNome() + " saiu do estabelecimento.");
                removido = true;
                break;
            }
        }
        if (removido = false) {
            System.out.println("CPF nao encontrado na base de dados");
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

    public void pesquisaPorCpf(String cpf) {
        for (Clientes c : listaClienteNoBar) {
            if (c.getCpf().equals(cpf)) {
                System.out.println("Cliente encontrado: \n" + c.toString());
            } else {
                System.out.println("Cliente nao encontrado.");
            }
        }
    }

    public void NumeroClientes() {
        System.out.println("Numero de clientes que estao no bar no momento: " + listaClienteNoBar.size());
    }

    public void PorcentagemClientes(char genero) {
        double contGenero = 0;
        double percentGenero = 0;
        for (Clientes c : listaClienteNoBar) {
            if (c.getGenero() == genero) {
                contGenero = contGenero + 1;
            }
        }
        if (listaClienteNoBar.size() == 0) {
        	System.out.println("Nao ha clientes no bar.");
        } else {
            percentGenero = contGenero * (100 / listaClienteNoBar.size());
            System.out.println("Percentual de "+ genero + "no bar: " + percentGenero + "\n"
                    + "Numero de"+genero +" no bar: "+contGenero);
        }
    }

    public void QuantidadeSociosClientes() {
        int contSocio = 0;
        int contCliente = 0;
        for (Clientes c : listaClienteNoBar) {
            if (c instanceof Socios) {
                contSocio++;
            } else {
                contCliente++;
            }
        }
        System.out.println("Socios no bar: " + contSocio + "\nClientes nao-socios no bar: " + contCliente);
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
}
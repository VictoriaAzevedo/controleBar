package uinterface;

import java.util.Scanner;
import persistence.Clientes;
import business.Business;
import persistence.Socios;


public class Interface {


	    public static void main(String[] args) {
	        
	        Scanner in = new Scanner(System.in);
	        Business listaClientes = new Business();
	        int op = 0;
	        System.out.println("\f");
	        do {
	            System.out.println("------------------------Bar Controller 1.0-------------------------------");
	            System.out.println("1 <---- Cadastro");
	            System.out.println("2 <---- Clientes no bar");
	            System.out.println("3 <---- Pesquisa por CPF");
	            System.out.println("4 <---- Registra Saida");
	            System.out.println("5 <---- Quantidade Clientes");
	            System.out.println("6 <---- Estatisticas por Genero");
	            System.out.println("7 <---- Quantidade de Socios/Nao-Socios");
	            System.out.println("8 <---- Exportar dados");
	            System.out.println("0 <---- Sair");
	            op = in.nextInt();
	            switch (op) {
	                case 0:
	                    break;
	                case 1:
	                    listaClientes.addCliente(cadastro());
	                    break;
	                case 2:
	                    listaClientes.imprimeTodosNoBar();
	                    break;
	                case 3:
	                    System.out.print("Digite o CPF para pesquisar se cliente esta no bar: ");
	                    String cpfPesquisa = in.next();
	                    listaClientes.pesquisaPorCpf(cpfPesquisa);
	                    break;
	                case 4:
	                    System.out.print("Insira o CPF para registrar saida: ");
	                    String cpf = in.next();
	                    listaClientes.removeCliente(cpf);
	                    break;
	                case 5:
	                    System.out.println("Clientes presentes no bar: " + listaClientes.numeroClientes());
	                    break;
	                case 6:
	                    listaClientes.porcentagemClientes();
	                    break;
	                case 7:
	                    listaClientes.quantidadeSociosClientes();
	                    break;
	                case 8:
	                    listaClientes.arquivoTxt();
	                    break;
	                default:
	                    System.out.println("Opção inválida.");
	            }

	        } while (op != 0);

	    }

	    public static Clientes cadastro() throws IndexOutOfBoundsException{
	        Scanner in = new Scanner(System.in);
	        String nome, cpf;
	        int idade, matricula;
	        char genero, socio;

	        System.out.println("-\t Formulario de Cadastro \t-");
	        System.out.print("1-Nome: ");
	        nome = in.next();
	        System.out.print("2-CPF: ");
	        cpf = in.next();
	        System.out.print("3-Idade: ");
	        idade = in.nextInt();
	        System.out.print("4-Genero: ");
	        genero = in.next().charAt(0);
	        System.out.println("5-Socio?(S/N)");
	        socio = in.next().charAt(0);
	        if (socio == 'S') {
	            System.out.print("6-Digite o numero de socio:");
	            matricula = in.nextInt();
	            Socios s = new Socios(nome, cpf, idade, genero,matricula);
	            return s;
	        } else {
	            Clientes c = new Clientes(nome, cpf, idade, genero);
	            return c;
	        }
	    }
	}
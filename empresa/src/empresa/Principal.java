package empresa;

import java.util.Scanner;

public class Principal {
	
	public static void cadastrarFuncionario(Scanner teclado, Empresa empresa) {

		Funcionario funcionario = new Funcionario();
		
		System.out.println("\nInserir um funcion�rio");
		System.out.println("Id: ");
		int id = Integer.parseInt(teclado.nextLine());
		funcionario.setId(id);
		
		System.out.println("Nome: ");
		funcionario.setNome(teclado.nextLine());
		
		System.out.println("Sal�rio: ");
		double salario = Double.parseDouble(teclado.nextLine());
		funcionario.setSalario(salario);
		
		System.out.println("Cargo: ");
		funcionario.setCargo(teclado.nextLine());
		
		empresa.cadastrarFuncionario(funcionario);
	}
	
	
	public static void atualizarFuncionario(Scanner teclado, Empresa empresa) {
		
		
		System.out.println("\nDigite o ID do funcionario desejado:");
		int id = Integer.parseInt(teclado.nextLine());
	
		
		if (empresa.pesquisarFuncionarioID(id) == true) {
			
			Funcionario funcionario = new Funcionario();
			
			funcionario.setId(id);
			
			System.out.println("Nome: ");
			funcionario.setNome(teclado.nextLine());
		
			System.out.println("Sal�rio: ");
			double salario = Double.parseDouble(teclado.nextLine());
			funcionario.setSalario(salario);
		
			System.out.println("Cargo: ");
			funcionario.setCargo(teclado.nextLine());
		
			empresa.atualizarFuncionario(funcionario);
			
			System.out.println("Operação realizada com sucesso");
		}
	
		else {
			System.out.println("Falha na operação, tente novamente!");
		}
	}
	
	public static void pesquisarFuncionario(Scanner teclado, Empresa empresa) {
		System.out.println("Digite o nome:");
		String nome = teclado.nextLine();
		
		empresa.pesquisarFuncionario(nome);
		
		
	}
	
	public static void removeFuncionario(Scanner teclado, Empresa empresa) {
		
		System.out.println("\nDigite o ID do funcionario desejado:");
		int id = Integer.parseInt(teclado.nextLine());
		
		if(empresa.RemoveFuncionario(id) == true) {
			System.out.println("Funcionario removido com sucesso!");
		}
		else {
			System.out.println("Funcionario não removido!");
		}
	}
	
	
	public static void main(String[] args) {
		String aux;
		int op;
		Scanner teclado = new Scanner(System.in);
		Empresa empresa = new Empresa();
		
		
		do {
		System.out.println("1. Cadastrar Funcionario\n2. Listar Funcionarios\n3. Atualizar Cadastro\n4. Pesquisar Funcionario\n5. Remover Funcionario\n6. Sair");
		
		aux = teclado.nextLine();
		op = Integer.parseInt(aux);
		
		switch(op) {
			
			case 1: 
				cadastrarFuncionario(teclado, empresa);
			break;
		
			case 2: 
				empresa.listarFuncionarios();
			break;
	
			case 3:
				atualizarFuncionario(teclado, empresa);
			break;
		
			case 4:
				pesquisarFuncionario(teclado, empresa);
			break;
			
			case 5:
				removeFuncionario(teclado, empresa);
			break;
			
			case 6:
				
			break;
			}
		
		}while (op != 6);
		
		
		
		// Fechando o teclado
		teclado.close();
		
package empresa;

import java.util.Iterator;
import java.util.List;

public class Empresa {
	
	public FuncionarioDAO funcionarioDAO;
	
	public Empresa() {
		funcionarioDAO = new FuncionarioDAO();
	}
	
	
	public void cadastrarFuncionario(Funcionario funcionario) {
		funcionarioDAO.inserir(funcionario);
	}
	
	public void atualizarFuncionario(Funcionario funcionario) {
		
		funcionarioDAO.atualizar(funcionario);
	}
	
	public boolean pesquisarFuncionarioID(int id) {
		
		List<Funcionario> lista = funcionarioDAO.pesquisarID(id);
		
		if (lista == null) {
			
			return false;
		}
		return true;
	}
	
	public void listarFuncionarios() {
		
		System.out.println("\nFuncion�rios cadastrados:");
		
		List<Funcionario> lista = funcionarioDAO.listar();
		
		Iterator<Funcionario> iterator = lista.iterator();
				
		while (iterator.hasNext()) {
			Funcionario funcionario = iterator.next();
					
			System.out.println(funcionario.getId() + " | " +
							   funcionario.getNome()  + " | " +
							   funcionario.getSalario()  + " | " +
							   funcionario.getCargo());
			System.out.println();
		}
	}
	
	public boolean pesquisarFuncionario(String nome) {
		
		List<Funcionario> lista = funcionarioDAO.pesquisar(nome);
		
		if (lista == null) {
			return false;
		}
		
		Iterator<Funcionario> iterator = lista.iterator();
				
		while (iterator.hasNext()) {
			Funcionario funcionario = iterator.next();
					
			System.out.println(funcionario.getId() + " | " +
							   funcionario.getNome()  + " | " +
							   funcionario.getSalario()  + " | " +
							   funcionario.getCargo());
			System.out.println();
		}
		
		return true;
		
	}
	
	public boolean RemoveFuncionario(int id) {
		
		boolean status = funcionarioDAO.remover(id);
		
		return status;
		
	}
	
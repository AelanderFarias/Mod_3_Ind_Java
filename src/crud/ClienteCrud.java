package crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDAO;
import modelo.cliente;

public class ClienteCrud {

	public static void main(String[] args) {
		
		ClienteDAO clientesDAO = new ClienteDAO();
		
		Scanner input = new Scanner(System.in);
		
		int opcao = 0;
		int posicao = 0;
		
		int id = 0;
		String nome = "";
		
		List<cliente> cliente = new ArrayList<cliente>();
		
		//Menu
		
		do {
			System.out.println("---- CRUD CLIENTES ----");
			System.out.println("1 - Cadastrar Cliente ");
			System.out.println("2 - Consultar Cliente");
			System.out.println("3 - Deletar Cliente");
			System.out.println("4 - Atualizar Cliente");
			System.out.println("0 - Sair");
			
			opcao = input.nextInt();
			
			switch (opcao) {
			case 1:
				System.out.println("**Cadastrar Cliente**");
				System.out.println("Digite o nome:");
				nome = input.nextLine();
				nome = input.nextLine();
				
				cliente clientes = new cliente();
				
				clientes.setNome_cliente(nome);
				ClienteDAO.save(clientes);
				
				System.out.println("\n**Cliente Cadastrado**\n");
				break;
			case 2:
				for (cliente a : clientesDAO.getCliente()) {
					System.out.println("Id: " + a.getId_cliente() + " Nome: " + a.getNome_cliente());
				}
				
				System.out.println("*Consulta Finalizada*");
				break;
			case 3:
				System.out.println("ID para exclusão: ");
				posicao = input.nextInt();
				
				clientesDAO.deleteById(posicao);
				System.out.println("Cliente Excluído");
				break;
			case 4:
				System.out.println("Atualizando cadastro Cliente");
				System.out.println("Digite o Id do cliente:");
				id = input.nextInt();
				System.out.println("Digite o novo nome do Cliente:");
				nome = input.nextLine();
				nome = input.nextLine();
				
				cliente clientes1 = new cliente(id, nome);
				clientesDAO.update(clientes1);
				
			
			default:
				System.out.println(opcao != 0 ? "\n Opção inválida, tente novamente. \n" : "");	
				break;
			}
		} while (opcao != 0);
		input.close();
		System.out.println("*Finalizado");
	}

}

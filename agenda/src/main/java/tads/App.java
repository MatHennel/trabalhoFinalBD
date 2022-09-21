package tads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tads.DAO.AgendaDAO;
import tads.DAO.Conexao;
import tads.DAO.EmailDAO;
import tads.DAO.TelefoneDAO;
import tads.MODELS.Agenda;
import tads.MODELS.Email;
import tads.MODELS.Telefone;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        AgendaDAO agendaDao = new AgendaDAO();
        TelefoneDAO telefoneDAO = new TelefoneDAO();
        EmailDAO emailDAO = new EmailDAO();
        Scanner ler = new Scanner(System.in);
        int opcao;
        Conexao c = new Conexao();
        List<Agenda> listaAgenda = new ArrayList<>();
        agendaDao.returnListaAgenda(listaAgenda);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            c.conectaBd();

            System.out.println("OK");

        } catch (Exception e) {
            System.out.println("Driver do banco de dados localizado");
        }

        do {
            System.out.println("1> Adicionar contato");
            System.out.println("2> Excluir contato");
            System.out.println("3> Buscar contato");
            System.out.println("4> Alterar contato");
            System.out.println("5> Sair");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    String nome;
                    int codigo = 0;
                    double telefone;
                    String email;

                    

                    System.out.println("Digite o nome: ");
                    nome = ler.next();

                    

                    Agenda agenda = new Agenda(nome);

                    agendaDao.cadastrarAgenda(agenda);

                    codigo = agendaDao.returnCodigo();
                    System.out.println(codigo);

                    System.out.println("Digite o telefone: ");
                    telefone = ler.nextLong();

                    Telefone telefone2 = new Telefone(telefone, codigo);

                    telefoneDAO.cadastrarTelefone(telefone2);

                    System.out.println("Digite o email: ");
                    email = ler.next();

                    Email email2 = new Email(email, codigo);

                    emailDAO.cadastrarEmail(email2);

                    agenda.adicionarEmail(email2);
                    agenda.adicionarTelefone(telefone2);

                    listaAgenda = new ArrayList<>();
                    agendaDao.returnListaAgenda(listaAgenda);

                    break;

                case 2:

                    int codigo1;

                    System.out.println("Lista de Agendas Cadastradas");

                    System.out.println(listaAgenda);

                    System.out.println("Digite o codigo da agenda que deseja excluir");
                    System.out.println("Digite -1 para cancelar");

                    codigo1 = ler.nextInt();

                    if (codigo1 == -1) {
                        break;
                    }

                    agendaDao.excluirAgenda(codigo1);

                    listaAgenda = new ArrayList<>();
                    agendaDao.returnListaAgenda(listaAgenda);

                    break;

                case 3:

                    break;

                case 4:

                    System.out.println("Lista de Agendas Cadastradas");

                    System.out.println(listaAgenda);

                    System.out.println("Digite o código da agenda que deseja alterar");
                    System.out.println("Digite -1 para cancelar");

                    codigo1 = ler.nextInt();

                    if(codigo1 == -1){
                        break;
                    }

                    System.out.println("1> Alterar nome");
                    System.out.println("2> Alterar email");
                    System.out.println("3> Alterar telefone");
                    System.out.println("4> Adicionar email");
                    System.out.println("5> Adicionar telefone");

                    opcao = ler.nextInt();

                    switch (opcao) {
                        case 1:
                            String nome1;
                            System.out.println("Digite o nome que deseja alterar: ");
                            nome1 = ler.next();
                            agendaDao.alterarNome(codigo1, nome1);

                            listaAgenda = new ArrayList<>();
                            agendaDao.returnListaAgenda(listaAgenda);

                            break;

                        case 2:
                            String email1;
                            System.out.println("Digite o email que deseja alterar");
                            email1 = ler.next();

                            emailDAO.alterarEmail(codigo1, email1);

                            listaAgenda = new ArrayList<>();
                            agendaDao.returnListaAgenda(listaAgenda);

                            break;

                        case 3:
                            int telefone1;
                            int codT;
                            System.out.println("Digite o numero do telefone que deseja alterar");
                            codT = ler.nextInt();
                            System.out.println("Digite o telefone que deseja alterar: ");
                            telefone1 = ler.nextInt();
                            telefoneDAO.alterarTelefone(telefone1, codT);

                            listaAgenda = new ArrayList<>();
                            agendaDao.returnListaAgenda(listaAgenda);

                            break;

                        case 4:
                            System.out.println("Digite o email que deseja adicionar");
                            email1 = ler.next();

                            emailDAO.adicionarEmail(codigo1, email1);

                            listaAgenda = new ArrayList<>();
                            agendaDao.returnListaAgenda(listaAgenda);

                            break;

                        case 5:
                            System.out.println("Digite o telefone que deseja adicionar");
                            telefone1 = ler.nextInt();

                            telefoneDAO.adicionarTelefone(codigo1, telefone1);

                            listaAgenda = new ArrayList<>();
                            agendaDao.returnListaAgenda(listaAgenda);

                            break;
                    }

                    
            }

        } while (opcao != 5);
    }

}

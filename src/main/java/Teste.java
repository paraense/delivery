
import entidade.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author john
 */
public class Teste {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Session session = HibernateUtil.getSessionFactory().openSession();

//        cliente.getPessoa().setNome("John Gomes");
//        cliente.getPessoa().setCpf("0008877777777");
//        cliente.getPessoa().setTelefone("912345678");
//        //endereço
//        cliente.getEndereco().setLugradouro("Pass. Carpano");
//        cliente.getEndereco().setBairro("Brasilia");

        try {
            
            List<Cliente> clientes = new ArrayList<>();
            clientes = session.createCriteria(Cliente.class).list();
            
            for (Cliente cliente1 : clientes) {
                System.out.println(cliente1.getPessoa().getNome());
                System.out.println(cliente1.getEndereco().getLugradouro());
            }

//            Transaction t = session.getTransaction();

//            t.begin();
//            session.save(cliente);
//            t.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

    }

}

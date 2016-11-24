/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidade.Cliente;
import entidade.Pessoa;
import entidade.Produto;
import util.HibernateUtil;

import java.math.BigDecimal;

import org.hibernate.Session;

/**
 *
 * @author johngomes
 */
public class ServicosTeste {
    
    public static void main(String[] args) {
        System.out.println("aqui");
        PedidoService ps = new PedidoService();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cliente cliente = (Cliente) session.createCriteria(Cliente.class).list().get(0);
        Produto produto = (Produto) session.createCriteria(Produto.class).list().get(0);
        session.close();
     
        ps.adcionarProduto(produto);
        ps.selecionarCliente(cliente);
        ps.calcularValorPedido();
        System.out.println(ps.finalizarPedido());
        
    }
    
}

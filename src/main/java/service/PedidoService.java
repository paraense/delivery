/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GenericDAO;
import entidade.Cliente;
import entidade.Pedido;
import entidade.Pessoa;
import entidade.Produto;
import entidade.StatusPedido;
import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author john
 */
@ManagedBean
public class PedidoService extends GenericDAO<Pedido>{
    
     private Pedido pedido = new Pedido();
     
     public PedidoService(){
       super.entidade = pedido;
     }
     
    
    public void adcionarProduto(Produto produto){
        pedido.getProdutos().add(produto);
    }
    
    public void selecionarCliente(Cliente cliente){
        pedido.setCliente(cliente);
    }
    
    public void calcularValorPedido(){
        BigDecimal valorPedido = new BigDecimal(0);
        for (Produto p :pedido.getProdutos()){
          valorPedido = valorPedido.add(p.getValor());          
      }
        pedido.setValor(valorPedido);
    }
    
    public boolean finalizarPedido(){
      pedido.setStatus(StatusPedido.ABERTO);
      return salvar();
    }
    
}

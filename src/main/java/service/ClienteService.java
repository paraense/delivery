/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GenericDAO;
import entidade.Cliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author john
 */
@ManagedBean
@SessionScoped
public class ClienteService extends GenericDAO<Cliente> {

    private Cliente cliente = new Cliente();

    private boolean atualiza = false;

    public ClienteService() {
        super.entidade = cliente;
    }

    public String salvaCliente() {
        if (salvar()) {
            return "clienteList";
        }
        return "erro";
    }

    public String atualizaCliente() {
        if (atualizar()) {
            return "clienteList";
        }
        return "erro";
    }

    public String captura(Cliente c) {
        atualiza = true;
        cliente = c;
        super.entidade = cliente;
        return "formCliente";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isAtualiza() {
        return atualiza;
    }

    public void setAtualiza(boolean atualiza) {
        this.atualiza = atualiza;
    }

}

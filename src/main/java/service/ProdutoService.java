/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entidade.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author john
 */
@ManagedBean
@SessionScoped
public class ProdutoService {

    private boolean atualiza = false;

    private String filtro;

    public ProdutoService() {
        listarProdutos();
    }

    private Produto produto = new Produto();
    private List<Produto> produtos = new ArrayList<>();

    public String salvaProduto() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction t = session.getTransaction();

            t.begin();
            session.save(produto);
            t.commit();
            listarProdutos();
            return "index";
        } catch (Exception e) {

        } finally {
            session.close();
        }
        return null;
    }

    public void listarProdutos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        produtos = session.createCriteria(Produto.class).list();
    }

    public void buscarProduto() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        produtos = session.createCriteria(Produto.class).add(Restrictions.eq("nome", filtro)).list();
        if (produtos.isEmpty()) {
            listarProdutos();
        }
    }

    public void excluir(Produto p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction t = session.getTransaction();
            t.begin();
            session.delete(p);
            t.commit();
            listarProdutos();

        } catch (Exception e) {
        } finally {
            session.close();
        }
    }

    public String atualizar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction t = session.getTransaction();
            t.begin();
            session.update(produto);
            t.commit();
            produto = new Produto();
            atualiza = false;
            return "index";
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return null;
    }

    public String capturaProduto(Produto p) {
        atualiza = true;
        produto = p;
        return "formProduto";
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean isAtualiza() {
        return atualiza;
    }

    public void setAtualiza(boolean atualiza) {
        this.atualiza = atualiza;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

}

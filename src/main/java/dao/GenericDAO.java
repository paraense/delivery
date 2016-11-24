/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author john
 */
public abstract class GenericDAO<T> {

    private Session session;
    private Transaction transaction;

    protected T entidade;

    public boolean salvar() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(entidade);
            transaction.commit();

            return true;
        } catch (Exception e) {
            return false;
        } finally {
            session.close();
        }

    }

    public List<T> listar() {
        session = HibernateUtil.getSessionFactory().openSession();
        return session.createCriteria(entidade.getClass()).list();
    }

    public void excluir(T entidade) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            session.delete(entidade);
            transaction.commit();
        } catch (Exception e) {
        } finally {
            session.close();
        }
    }

    public boolean atualizar() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        try {
            session.update(entidade);
            transaction.commit();
            return true;
        } catch (Exception e) {

            return false;
        } finally {
            session.close();
        }
    }

}

package dao;

import model.chuong13ex2_User;
import util.chuong13ex2_DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class chuong13ex2_UserDB {

    public static void insert(chuong13ex2_User user) {
        EntityManager em = chuong13ex2_DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(chuong13ex2_User user) {
        EntityManager em = chuong13ex2_DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(chuong13ex2_User user) {
        EntityManager em = chuong13ex2_DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }

    public static chuong13ex2_User selectUser(String email) {
        EntityManager em = chuong13ex2_DBUtil.getEmFactory().createEntityManager();
        // Entity class simple name is chuong13ex2_User
        String qString = "SELECT u FROM chuong13ex2_User u WHERE u.email = :email";
        TypedQuery<chuong13ex2_User> q = em.createQuery(qString, chuong13ex2_User.class);
        q.setParameter("email", email);
        try {
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean emailExists(String email) {
        chuong13ex2_User u = selectUser(email);
        return u != null;
    }
    
    public static List<chuong13ex2_User> selectUsers() {
        EntityManager em = chuong13ex2_DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM chuong13ex2_User u ORDER BY u.lastName, u.firstName";
        TypedQuery<chuong13ex2_User> q = em.createQuery(qString, chuong13ex2_User.class);
        List<chuong13ex2_User> results = q.getResultList();
        em.close();
        return results;
    }
}
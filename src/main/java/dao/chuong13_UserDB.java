package dao;

import model.chuong13_User;
import util.chuong13_DBUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class chuong13_UserDB {

    public static void insert(chuong13_User user) {
        EntityManager em = chuong13_DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            if (trans.isActive()) trans.rollback();
        } finally {
            em.close();
        }
    }

    public static chuong13_User selectUser(String email) {
        EntityManager em = chuong13_DBUtil.getEmFactory().createEntityManager();
    String qString = "SELECT u FROM chuong13_User u WHERE u.email = :email";
        TypedQuery<chuong13_User> q = em.createQuery(qString, chuong13_User.class);
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
        return selectUser(email) != null;
    }
}
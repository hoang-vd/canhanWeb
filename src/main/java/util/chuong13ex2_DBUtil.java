package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class chuong13ex2_DBUtil {
    private static final EntityManagerFactory emf;

    static {
        EntityManagerFactory tmp = null;
        try {
            System.out.println("[userAdminPU] Initializing EntityManagerFactory...");
            tmp = Persistence.createEntityManagerFactory("userAdminPU");
            System.out.println("[userAdminPU] EMF initialized successfully");
        } catch (Exception e) {
            System.err.println("[userAdminPU] Failed to initialize EMF: " + e.getMessage());
            e.printStackTrace();
        }
        emf = tmp;
    }

    public static EntityManagerFactory getEmFactory() {
        if (emf == null) {
            throw new IllegalStateException("EntityManagerFactory for userAdminPU not initialized.");
        }
        return emf;
    }
}
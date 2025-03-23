package fpt.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaUtils {
		public static EntityManager getenEntityManager() {
			return Persistence.createEntityManagerFactory("Asm").createEntityManager();
		}
}

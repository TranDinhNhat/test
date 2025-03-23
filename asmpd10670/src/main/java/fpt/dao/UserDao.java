package fpt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fpt.entity.Favorite;
import fpt.entity.User;
import fpt.utils.JpaUtils;

public class UserDao extends AbstractEntityDao<User> {
	public UserDao() {
		super(User.class);
	}
	public User findByIdOrEmail(String id , String email) {
		EntityManager eManager = JpaUtils.getenEntityManager();
		String jpql = "select u from User u where u.id = :id or u.emai; = :email";
		try {
			TypedQuery<User> query = eManager.createQuery(jpql, User.class);
			query.setParameter("id", id);
			query.setParameter("email",	email);
			
			User user = null;
			try {
				user = query.getSingleResult();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (user == null) {
				return null;
			}
			return user;
		} finally{
			// TODO: handle exception
			eManager.close();
		}
		
		
	}
	public User findByEmail(String email) {
		EntityManager eManger = JpaUtils.getenEntityManager();
		String jpql = "select u from User u where u.email = :email";
		try {
			TypedQuery<User> query = eManger.createQuery(jpql, User.class);
			
			query.setParameter("email", email);
			
			return query.getSingleResult();
		} finally {
			// TODO: handle finally clause
			eManger.close();
			
		}
	}
	public List<User> searchByKeyWord(String keyword) {
		 EntityManager entityManager = JpaUtils.getenEntityManager();
		    List<User> resultList = null;
		    String jpql = "SELECT u FROM User u WHERE u.id LIKE :keyword OR u.email LIKE :keyword";

		    try {
		        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
		        query.setParameter("keyword", "%" + keyword + "%");
		        resultList = query.getResultList();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		        throw new RuntimeException("Lỗi khi tìm kiếm bản tin: " + ex.getMessage(), ex);
		    } finally {
		        entityManager.close();
		    }
		    return resultList;
}
	public List<User> findId(String Userid) {
		 EntityManager entityManager = JpaUtils.getenEntityManager();
		    String jpql = "SELECT u FROM User u WHERE u.id  = :Userid";

		    try {
		        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
		        query.setParameter("Userid", Userid);
		        return query.getResultList(); 
		    } finally {
		        entityManager.close();
		    }
		
}
	 public boolean updatePassword(String userId, String newPassword) {
	        EntityManager entityManager = JpaUtils.getenEntityManager();
	        try {
	            User user = entityManager.find(User.class, userId);
	            if (user != null) {
	                user.setPassword(newPassword);
	                entityManager.getTransaction().begin();
	                entityManager.merge(user);
	                entityManager.getTransaction().commit();
	                return true;
	            }
	            return false;
	        } catch (Exception e) {
	        	entityManager.getTransaction().rollback();
	            throw new RuntimeException("Lỗi khi cập nhật mật khẩu: " + e.getMessage(), e);
	        } finally {
	        	entityManager.close();
	        }
	    }
	 
	 public boolean isEmailExists(String email) {
		    EntityManager eManager = JpaUtils.getenEntityManager();
		    try {
		        String jpql = "SELECT COUNT(u) FROM User u WHERE u.email = :email";
		        Long count = eManager.createQuery(jpql, Long.class)
		                             .setParameter("email", email)
		                             .getSingleResult();
		        return count > 0;
		    } finally {
		        eManager.close();
		    }
		}
	 public boolean isUserlExists(String id) {
		    EntityManager eManager = JpaUtils.getenEntityManager();
		    try {
		        String jpql = "SELECT COUNT(u) FROM User u WHERE u.id = :id";
		        Long count = eManager.createQuery(jpql, Long.class)
		                             .setParameter("id", id)
		                             .getSingleResult();
		        return count > 0;
		    } finally {
		        eManager.close();
		    }
		}

}
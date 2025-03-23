package fpt.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import javax.persistence.Query;

import fpt.entity.Favorite;
import fpt.entity.User;
import fpt.entity.Video;
import fpt.utils.JpaUtils;

public class FavoriteDao extends AbstractEntityDao<Favorite> {
	public FavoriteDao() {
		super(Favorite.class);
	}
	public List<Favorite> searchByKeyWord(String keyword) {
		 EntityManager entityManager = JpaUtils.getenEntityManager();
		    List<Favorite> resultList = null;
		    
		    String jpql = "SELECT f FROM Favorite f JOIN f.user u inner JOIN f.video v WHERE u.fullname LIKE :keyword";

		    try {
		        TypedQuery<Favorite> query = entityManager.createQuery(jpql, Favorite.class);
		        query.setParameter("keyword", "%" + keyword + "%");
		        resultList = query.getResultList();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		        throw new RuntimeException("Lỗi khi tìm kiếm : " + ex.getMessage(), ex);
		    } finally {
		        entityManager.close();
		    }
		    return resultList;
}
	public List<Favorite> findId(String Userid) {
		 EntityManager entityManager = JpaUtils.getenEntityManager();
		    String jpql = "SELECT f FROM Favorite f WHERE f.user.id  = :Userid";

		    try {
		        TypedQuery<Favorite> query = entityManager.createQuery(jpql, Favorite.class);
		        query.setParameter("Userid", Userid);
		        return query.getResultList();
		    } finally {
		        entityManager.close();
		    }
		   
}
	 
	 
}
 


 
 

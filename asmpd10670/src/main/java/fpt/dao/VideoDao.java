package fpt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fpt.entity.Favorite;
import fpt.entity.User;
import fpt.entity.Video;
import fpt.utils.JpaUtils;

public class VideoDao extends AbstractEntityDao<Video> {
	public VideoDao() {
		super(Video.class);
	}
	public List<Video> searchByKeyWord(String keyword) {
		 EntityManager entityManager = JpaUtils.getenEntityManager();
		    List<Video> resultList = null;
		    
		    String jpql = "SELECT v FROM Video v WHERE v.title LIKE :keyword";

		    try {
		        TypedQuery<Video> query = entityManager.createQuery(jpql, Video.class);
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
	public List<Video> findId(String Userid) {
		 EntityManager entityManager = JpaUtils.getenEntityManager();
		    String jpql = "SELECT v FROM Video v WHERE v.user.id  = :Userid";

		    try {
		        TypedQuery<Video> query = entityManager.createQuery(jpql, Video.class);
		        query.setParameter("Userid", Userid);
		        return query.getResultList();
		    } finally {
		        entityManager.close();
		    }
		   
}
	public void update(Video video) {
	    EntityManager em = JpaUtils.getenEntityManager();
	    try {
	        em.getTransaction().begin();
	        em.merge(video); // Cập nhật video
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        throw e;
	    } finally {
	        em.close();
	    }
	}
}

package fpt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fpt.entity.Favorite;
import fpt.entity.Share;
import fpt.utils.JpaUtils;

public class ShareDao extends AbstractEntityDao<Share> {
	public ShareDao() {
		super(Share.class);
	}
	public List<Share> findId(String Userid) {
		 EntityManager entityManager = JpaUtils.getenEntityManager();
		    String jpql = "SELECT s FROM Share  s WHERE s.user.id  = :Userid";

		    try {
		        TypedQuery<Share> query = entityManager.createQuery(jpql, Share.class);
		        query.setParameter("Userid", Userid);
		        return query.getResultList();
		    } finally {
		        entityManager.close();
		    }
		   
}
}

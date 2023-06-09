package kr.or.ddit.buyer.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.PagingVO;
@Repository
public class BuyerDAOImpl implements BuyerDAO {

	@Inject
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public int selectTotalRecord(PagingVO<BuyerVO> pagingVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			BuyerDAO mapperProxy = sqlSession.getMapper(BuyerDAO.class);
			return mapperProxy.selectTotalRecord(pagingVO);
		}
	}

	@Override
	public List<BuyerVO> selectBuyerList(PagingVO<BuyerVO> pagingVO) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			BuyerDAO mapperProxy = sqlSession.getMapper(BuyerDAO.class);
			return mapperProxy.selectBuyerList(pagingVO);
		}
	}

	@Override
	public BuyerVO selectBuyer(String buyerId) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			BuyerDAO mapperProxy = sqlSession.getMapper(BuyerDAO.class);
			return mapperProxy.selectBuyer(buyerId);
		}
	}

	@Override
	public int insertBuyer(BuyerVO buyer) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			BuyerDAO mapperProxy = sqlSession.getMapper(BuyerDAO.class);
			int rowcnt = mapperProxy.insertBuyer(buyer);
			sqlSession.commit();
			return rowcnt;
		}
	}

	@Override
	public int updateBuyer(BuyerVO buyer) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			BuyerDAO mapperProxy = sqlSession.getMapper(BuyerDAO.class);
			int rowcnt = mapperProxy.updateBuyer(buyer);
			sqlSession.commit();
			return rowcnt;
		}
	}

}

package kr.or.iei.photo.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.photo.dao.PhotoDao;
import kr.or.iei.photo.vo.Photo;

public class PhotoService {
	private PhotoDao dao;
	
	
	public PhotoService() {
		super();
		dao = new PhotoDao();
	}


	public int totalCount() {
		Connection conn = JDBCTemplate.getConnection();
		int totalCount = dao.totalCount(conn);
		JDBCTemplate.close(conn);
		return totalCount;
	}


	public int insertPhoto(Photo p) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertPhoto(conn,p);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}


	public ArrayList<Photo> morePhoto(int start, int amount) {
		Connection conn = JDBCTemplate.getConnection();
		//start :1, amount : 5
		int end = start+amount-1;
		ArrayList<Photo> list = dao.morePhoto(conn,start,end);
		JDBCTemplate.close(conn);
		return list;
	}

}

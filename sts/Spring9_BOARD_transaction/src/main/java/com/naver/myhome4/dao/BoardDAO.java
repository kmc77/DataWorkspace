package com.naver.myhome4.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.myhome4.domain.Board;

@Repository
public class BoardDAO {

	private SqlSessionTemplate sqlSession;

	@Autowired
	public BoardDAO(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int getListCount() {
		return sqlSession.selectOne("Boards.count");
	} // xml에 int형이여서 int

	public List<Board> getBoardList(HashMap<String, Integer> map) {
		return sqlSession.selectList("Boards.list", map);
	}

	public void insertBoard(Board board) {
		sqlSession.insert("Boards.insert", board);
	}

	public int setReadCountUpdate(int num) {
		return sqlSession.update("Boards.readCountUpdate", num);
	}

	public Board getDetail(int num) {
		return sqlSession.selectOne("Boards.detail", num);
	}

	public Board isBoardWriter(Map<String, Object> map) {
		return sqlSession.selectOne("Boards.boardWriter", map);
	}

	public int boardModify(Board modifyboard) {
		return sqlSession.update("Boards.modify", modifyboard);
	}

	public int boardReply(Board board) {
		return sqlSession.insert("Boards.reply_insert", board);
	}

	public int boardReplyUpdate(Board board) {
		return sqlSession.update("Boards.reply_update", board);
	}

	public int boardDelete(Board board) {
		return sqlSession.delete("Boards.delete", board);
	}
	
	public List<String> getDeleteFileList() {
		return sqlSession.selectList("Boards.getDeleteFileList");
	}
	
	public void deleteFileList(String filename) {
		sqlSession.delete("Boards.deleteFileList", filename);
	}
}

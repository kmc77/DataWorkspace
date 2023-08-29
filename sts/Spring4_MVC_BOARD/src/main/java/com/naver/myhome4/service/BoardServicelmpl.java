package com.naver.myhome4.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.myhome4.dao.BoardDAO;
import com.naver.myhome4.domain.Board;

@Service
public class BoardServicelmpl implements BoardService{
   
   private BoardDAO dao;

   @Autowired
   public BoardServicelmpl(BoardDAO dao) {
      this.dao = dao;
   }
      
   @Override
   public int getListCount() {
      return dao.getListCount();
   }

   @Override
   public List<Board> getBoardList(int page, int limit) {
      
      HashMap<String, Integer> map = new HashMap<String, Integer>();
      
      int startrow = (page-1) * limit + 1;
      int endrow = startrow + limit - 1;
      
      map.put("start", startrow);
      map.put("end", endrow);
      
      return dao.getBoardList(map);
      
   }

   @Override
   public Board getDetail(int num) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public int boardReply(Board board) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int boardModify(Board modifyboard) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int boardDelete(int num) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public int setReadCountUpdate(int num) {
      // TODO Auto-generated method stub
      return 0;
   }

   @Override
   public boolean isBoardWriter(int num, String pass) {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public void insertBoard(Board board) {
      dao.insertBoard(board);
   }

   @Override
   public int boardReplyUpdate(Board board) {
      // TODO Auto-generated method stub
      return 0;
   }
   
   

}
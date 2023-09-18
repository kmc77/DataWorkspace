package com.naver.myhome.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.myhome.domain.Board;
import com.naver.myhome.mybatis.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	private BoardMapper dao;
	
	@Autowired
	public BoardServiceImpl(BoardMapper dao) {
		this.dao = dao;
	}

	
}

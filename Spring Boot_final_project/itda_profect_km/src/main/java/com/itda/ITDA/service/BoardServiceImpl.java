package com.itda.ITDA.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itda.ITDA.domain.Board;
import com.itda.ITDA.mybatis.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	private BoardMapper dao;
	
	@Autowired
	public BoardServiceImpl(BoardMapper dao) {
		this.dao = dao;
	}

	
}

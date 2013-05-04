package com.mycompany.smarteditor.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.smarteditor.domain.Contents;
import com.mycompany.smarteditor.persistence.ContentsMapper;
import com.mycompany.smarteditor.service.ContentsService;


@Service("ContentsService")
@Repository
@Transactional
public class ContentsServiceImpl implements ContentsService {
private Log log = LogFactory.getLog(ContentsServiceImpl.class);	
	
	@Autowired
	private ContentsMapper contentsMapper;
	
	@Transactional(readOnly=true)
	@Override
	public List<Contents> findAll() {
		List<Contents> contents = contentsMapper.findAll();
		return contents;
	}

	@Transactional(readOnly=true)
	@Override
	public void insertContents(Contents contents) {
		contentsMapper.insertContents(contents);
	}

}

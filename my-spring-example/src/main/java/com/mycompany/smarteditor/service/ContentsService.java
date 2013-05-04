package com.mycompany.smarteditor.service;

import java.util.List;

import com.mycompany.smarteditor.domain.Contents;

public interface ContentsService {
	public List<Contents> findAll();
	
	public void insertContents(Contents contents);
}

package com.mycompany.smarteditor.persistence;

import java.util.List;

import com.mycompany.smarteditor.domain.Contents;

public interface ContentsMapper {
	public List<Contents> findAll();
	
	public void insertContents(Contents contents);
}

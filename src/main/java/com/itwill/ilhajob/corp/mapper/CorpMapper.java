package com.itwill.ilhajob.corp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.corp.Corp;

public interface CorpMapper {
	/*
	 * 메쏘드이름은 	GuestMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 GuestMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 GuestMapper.xml 파일의 resultType 와일치
	 */
	public Corp selectById(String corp_id);
	public List<Corp> selectAll();
	public int insertCorp(Corp corp);
	public int deleteCorp(String corp_id);
	public int updateCorp(Corp corp);
}

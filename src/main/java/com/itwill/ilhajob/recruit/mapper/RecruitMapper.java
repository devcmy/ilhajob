package com.itwill.ilhajob.recruit.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.recruit.Recruit;

@Mapper
public interface RecruitMapper {
	
	public int insertRecruit(Recruit recruit);
	
	public List<Recruit> findByCorpId(String corpId);
	
	public List<Recruit> findByJob(String job);
	
	public Recruit findBySeq(int rcSeq);
	
	public int updateBySeq(Recruit recruit);
	
	public int deleteBySeq(Map<String, Object> map);
}

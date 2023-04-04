package com.itwill.ilhajob.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.app.App;

@Mapper
public interface AppMapper {
	
	int insertApp(App app);
	
	int deleteApp(int appSeq);
	
	//List<App> findAppByUserSeq(int userSeq); -> 유저가함(usermapper.xml 작성완료되어있는거 확인완료 04.04 18:12)
	
	//List<App> findAppByCorpId(String coprId); -> 회사가 함
}

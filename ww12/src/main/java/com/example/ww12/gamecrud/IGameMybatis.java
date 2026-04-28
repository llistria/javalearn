package com.example.ww12.gamecrud;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGameMybatis {
	void insertData(GameDto newGame);
	void updateData(GameDto gameData);
	void deleteData(Integer id);
	GameDto findById(Integer id);
	Integer countList(SearchRequestDto searchRequestDto);
	List<GameDto> searchList(SearchRequestDto searchRequestDto);
}

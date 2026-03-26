package com.example.ww12.gamecrud;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IGameMybatis {
	void insertData(GameDto newGame);
	void updateData(GameDto gameData);
	void deleteData(Integer id);

}

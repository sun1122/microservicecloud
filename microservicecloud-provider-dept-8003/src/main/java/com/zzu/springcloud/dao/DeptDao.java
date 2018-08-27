package com.zzu.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zzu.springcloud.entities.Dept;

@Mapper
public interface DeptDao {
	
   public boolean add(Dept dept);
   
   public Dept findById(Long id);
   
   public List<Dept> findAll();
}

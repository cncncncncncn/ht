package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Grade;
import com.example.demo.pojo.Student;

public interface IGradeDao {
	/**
	 * 查询所有的班级
	 * @return
	 */
	List<Grade> queryGradeList();
	/**
	 * 查询所有班级下的学生
	 * @param gid
	 * @return
	 */
	List<Student> queryStudentAll(@Param("gid") int gid);
	/**
	 * 删除单个学生
	 * @param uid
	 */
	void delStudent(@Param("uid")int uid);
	
	/**
	 * 删除年级和所有学生
	 * @param gid
	 */
	void delGrade(@Param("gid")int gid);
	/**
	 * 计数，所有学生
	 * @return
	 */
	int countStudent(@Param("gid")int gid);
	
	void delStudentAll(@Param("gid")int gid);
}

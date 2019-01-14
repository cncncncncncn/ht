package com.example.demo.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IGradeDao;
import com.example.demo.pojo.Grade;
import com.example.demo.pojo.Student;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class GradeBiz {
	@Autowired
	private IGradeDao dao;
	/**
	 * 查询所有的班级
	 * @return
	 */
	public List<Grade> queryGradeList(){
		return dao.queryGradeList();
	}
	/**
	 * 查询所有班级下的学生
	 * @param gid
	 * @return
	 */
	public List<Student> queryStudentAll(int gid){
		return dao.queryStudentAll(gid);
		
	}
	
	/**
	 * 删除单个学生
	 * @param uid
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void delStudent(int uid) {
		 dao.delStudent(uid);
	}
	
	/**
	 * 删除年级和所有学生
	 * @param gid
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void delGrade(int gid) {	
		dao.delGrade(gid);
	}
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void delStudentAll(int gid) {
		dao.delStudentAll(gid);
	}
	/**
	 * 计数
	 * @param gid
	 * @return
	 */
	public int countStudent(int gid) {
		return dao.countStudent(gid);
	}
}

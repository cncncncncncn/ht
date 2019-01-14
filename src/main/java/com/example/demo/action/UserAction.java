package com.example.demo.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.biz.GradeBiz;
import com.example.demo.pojo.Grade;
import com.example.demo.pojo.Student;



@RestController
@RequestMapping("/api")
public class UserAction {
	@Autowired
	private GradeBiz biz;
	
	@GetMapping("grades")
	public List<Grade> queryGradeList(){
		return biz.queryGradeList();
	}
	@DeleteMapping("grades/grade/{gid}")
	public Map<String,String> delGrade(@PathVariable int gid){
		biz.delGrade(gid);
		biz.delStudentAll(gid);
		Map<String, String> map=new HashMap<String,String>();
		map.put("code", "200");
		map.put("msg", "删除成功");
		return map;
	}
	@GetMapping("grades/grade/studentcount/{gid}")
	public int countStudent(@PathVariable int gid) {
		return biz.countStudent(gid);
	}
	
	/**
	 * 查询所有班级下的学生
	 * @param gid
	 * @return
	 */
	@GetMapping("grades/grade/student/{gid}")
	public List<Student> queryStudentAll(@PathVariable int gid){
		return biz.queryStudentAll(gid);
		
	}
	
	/**
	 * 删除单个学生
	 * @param uid
	 */
	@DeleteMapping("grades/grade/delstudent/{uid}")
	public  Map<String,String> delStudent(@PathVariable int uid) {
		 biz.delStudent(uid);
		 Map<String, String> map=new HashMap<String,String>();
			map.put("code", "200");
			map.put("msg", "删除成功");
			return map;
	}
}

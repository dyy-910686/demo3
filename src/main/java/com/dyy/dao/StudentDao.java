package com.dyy.dao;

import com.dyy.entities.Student;

import java.util.List;

/**
 * @author 邓育永
 * @date 2020/12/8 20:35
 */
public interface StudentDao {
    public List<Student> selectStudents();
}

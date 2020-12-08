package com.dyy;


import com.dyy.entities.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 邓育永
 * @date 2020/12/8 21:23
 */
public class MyApp {
    public static void main(String[] args) throws IOException {
        //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称，从类路径的根开始（target/classes)
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        //5.【重要的】获取SqlSession对象,从SqlSessionFactory中获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //6.指定要执行的sql语句的标识。sql映射文件中的namespace + "." + 标签的id值
        String sqlId = "com.dyy.dao.StudentDao" + "." + "selectStudents";
        //7.执行sql语句，通过sqlId找到语句
        List<Student> studentlist = sqlSession.selectList(sqlId);
        //8.输出结果
        studentlist.forEach( student -> System.out.println(student));
        //9.关闭SqlSession对象
        sqlSession.close();


    }


}

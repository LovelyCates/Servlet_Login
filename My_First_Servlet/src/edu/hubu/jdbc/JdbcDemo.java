package edu.hubu.jdbc;

import edu.hubu.model.Users;
import edu.hubu.util.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class JdbcDemo {

	public static void main(String[] args) throws Exception {


	}

	// 查询
	public List<Users> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet res = null;
		Users user = null;
		List<Users> list = null;
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select * from users";

			stmt = conn.createStatement();

			res = stmt.executeQuery(sql);

			Users users  = null;

			list = new ArrayList<Users>();

			while(res.next()){
				// 获取数据
				Integer id = res.getInt("id");
				String name = res.getString("name");
				String nickName = res.getString("nickName");
				String pwd = res.getString("pwd");
				String gender = res.getString("gender");
				Date birthday = res.getDate("birthday");
				String hobby = res.getString("hobby");
				String tel = res.getString("tel");
				String email = res.getString("email");
				Integer grade = res.getInt("grade");
				String description = res.getString("description");
				// 创建 Users对象，并且赋值
				user = new Users();
				user.setId(id);
				user.setName(name);
				user.setNickName(nickName);
				user.setPwd(pwd);
				user.setGender(gender);
				user.setBirthday(birthday);
				user.setHobby(hobby);
				user.setTel(tel);
				user.setEmail(email);
				user.setGrade(grade);
				user.setDescription(description);
				// 装载集合
				list.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.close(res, stmt, conn);
		}
		return list;
	}
}

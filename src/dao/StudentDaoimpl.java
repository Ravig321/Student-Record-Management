package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Student;
import util.jdbcUtil;

public class StudentDaoimpl  implements StudentDao{

	Connection connection = null;
	PreparedStatement ps = null;
	String status ="Error...";

	

	@Override
	public String save(Student student) {
		try {
			
			
			connection = jdbcUtil.getJdbcConnection();
			if(connection !=null){
			ps = connection.prepareStatement("Insert into student (name , email , city , country) values(?,?,?,?)");
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getCity());
			ps.setString(4, student.getCountry());
			}
			if(ps!=null) {
			int a = ps.executeUpdate();
			
				if(a ==1) {
					status ="Success";
			}else {
				status ="failure";
			}
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			status ="failure";
		}
		return status;
	}

	@Override
	public Student findById(Integer sid) {
		Student st = null;
		try {
			connection = jdbcUtil.getJdbcConnection();
			ps = connection.prepareStatement("Select * from student where sid = ?");
			ps.setInt(1, sid);
			ResultSet rs = ps.executeQuery();
				if(rs.next()) {
				st = new Student();
				st.setSid(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setCity(rs.getString(4));
				st.setCountry(rs.getString(5));
				}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return st;
		} 

		
		return st ;
	}

	@Override
	public String updateById(Student student) {
		
try {
			
			int sid = student.getSid();
			connection = jdbcUtil.getJdbcConnection();
			if(connection !=null){
			ps = connection.prepareStatement("update student set name = ?, email= ? , city = ? , country = ?  where sid = ?");
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getCity());
			ps.setString(4, student.getCountry());
			ps.setInt(5, sid);
			}
			if(ps!=null) {
			int a = ps.executeUpdate();
			
				if(a ==1) {
					status ="Success";
			}else {
				status ="failure";
			}
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			status ="failure";
		}
		return status;
	}

	@Override
	public String deleteById(Integer sid) {
		int a=0;
		try {
			connection = jdbcUtil.getJdbcConnection();
			if(connection!=null) {
				ps = connection.prepareStatement("delete from student where sid = ?");
				ps.setInt(1, sid);
			}
			if(ps!=null) {
			 a =	ps.executeUpdate();
			}
			if(a==1) {
				return status="Success";
			}else {
				return status="Failure";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return status;
	}

}

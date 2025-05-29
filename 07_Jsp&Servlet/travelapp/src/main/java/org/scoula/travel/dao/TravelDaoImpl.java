package org.scoula.travel.dao;

import org.scoula.database.JDBCUtil;
import org.scoula.travel.domain.TravelVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TravelDaoImpl implements TravelDao {
    Connection conn= JDBCUtil.getConnection();

    @Override
    public void insert(TravelVO travel) {
        String sql="insert into tbl_travel(no,district,title, description, address,phone) values(?,?,?,?,?,?)";
        try(PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setLong(1,travel.getNo());
            ps.setString(2,travel.getDistrict());
            ps.setString(3,travel.getTitle());
            ps.setString(4,travel.getDescription());
            ps.setString(5,travel.getAddress());
            ps.setString(6,travel.getPhone());

            int count=ps.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}

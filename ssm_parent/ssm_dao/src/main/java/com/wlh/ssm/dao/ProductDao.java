package com.wlh.ssm.dao;

import com.wlh.ssm.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ProductDao
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/4 20:01
 **/



@Repository
public interface ProductDao {

    @Select("select * from product")
    List<Product> findAll();

    @Select("select * from product where id=#{id}")
    Product findById(Long id);

    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            " values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Delete("delete from product where id = #{id}")
    void deleteProduct(Long id);


    @Update("update product set productNum = #{productNum},productName = #{productName}" +
            ",cityName = #{cityName},departureTime = #{departureTime}" +
            ",productPrice = #{productPrice},productDesc = #{productDesc},productStatus = #{productStatus} " +
            "where id = #{id}")
    void updateProduct(Product product);

    @Select("select count(1) from product")
    Long findTotal();

    @Select("select * from product limit #{param1},#{param2}")
    List<Product> findPageList(Integer index, Integer pageSize);
}

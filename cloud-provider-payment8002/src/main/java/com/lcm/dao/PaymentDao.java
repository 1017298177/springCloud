package com.lcm.dao;

import com.lcm.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentDao {

    Payment queryById(Long id);

    List<Payment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Payment> queryAll(Payment payment);

    int insert(Payment payment);


    int update(Payment payment);


    int deleteById(Long id);

}
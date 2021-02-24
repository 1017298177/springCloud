package com.lcm.service.impl;

import com.lcm.dao.PaymentDao;
import com.lcm.entity.Payment;
import com.lcm.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public Payment queryById(Long id) {
        return paymentDao.queryById(id);
    }

    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }
}

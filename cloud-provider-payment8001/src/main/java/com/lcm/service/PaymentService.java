package com.lcm.service;

import com.lcm.entity.Payment;

public interface PaymentService {

    Payment queryById(Long id);

    int insert(Payment payment);

}

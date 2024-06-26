package com.ticket.payment.repositories;

import com.ticket.payment.entitties.PaymentInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends MongoRepository<PaymentInfo, String> {
    List<PaymentInfo> findAllByStatus(String status);
}

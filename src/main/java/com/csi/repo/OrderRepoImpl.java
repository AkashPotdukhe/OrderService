package com.csi.repo;

import com.csi.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepoImpl extends JpaRepository<OrderDetails,Long> {

    List<OrderDetails> findByOrderName(String orderName);
}

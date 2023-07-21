package com.onlineshop.repository;

import com.onlineshop.model.Bill;
import com.onlineshop.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBillDetailRepository extends JpaRepository<BillDetail, Integer> {
    @Query("select bd from BillDetail bd where bd.bill.Id = :id ")
    List<BillDetail> findByBillId(@Param("id") int id);

    @Query("select bd from BillDetail bd where bd.product.id = :productId and bd.bill.user.id = :userId")
    List<BillDetail> findByProductIdAndUserId(@Param("productId") int productId, @Param("userId") int userId);

}

package com.example.demo.Repository;


import com.example.demo.Model.Voucher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepo extends CrudRepository<Voucher,Long> {
    Voucher findFirstByIdVoucher(Long id);
}

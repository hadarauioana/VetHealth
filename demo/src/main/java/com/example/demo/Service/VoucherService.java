package com.example.demo.Service;


import com.example.demo.Model.Voucher;

public interface VoucherService {
    void insert(Voucher voucher);
    void update(Voucher voucher);
    void delete(Voucher voucher);
    Voucher findFirstByIdVoucher(Long id);
}

package com.example.demo.Service.Implementation;

import com.example.demo.Model.Voucher;
import com.example.demo.Repository.AnimalRepo;
import com.example.demo.Repository.UtilizatorRepo;
import com.example.demo.Repository.VoucherRepo;
import com.example.demo.Service.VoucherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoucherServiceImplementation implements VoucherService {
    private final VoucherRepo voucherRepo;
    private final AnimalRepo animalRepo;
    @Override
    public void insert(Voucher voucher) {
        //animalRepo.save(voucher.getAnimal());
        voucherRepo.save(voucher);
    }

    @Override
    public void update(Voucher voucher) {
        //animalRepo.save(voucher.getAnimal());
        voucherRepo.save(voucher);
    }

    @Override
    public void delete(Voucher voucher) {
        voucherRepo.delete(voucher);
    }

    @Override
    public Voucher findFirstByIdVoucher(Long id) {
        return voucherRepo.findFirstByIdVoucher(id);
    }
}
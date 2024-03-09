package com.example.demo.Controller;

import com.example.demo.DTO.InserareVoucher;
import com.example.demo.Model.Animal;
import com.example.demo.Model.Voucher;
import com.example.demo.Service.Implementation.AnimalServiceImplementation;
import com.example.demo.Service.Implementation.VoucherServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/Voucher")
public class VoucherController {
    private final VoucherServiceImplementation voucherServiceImplementation;
    private final AnimalServiceImplementation animalServiceImplementation;
    @PostMapping("/Insert")
    public ResponseEntity insert(@RequestBody Voucher voucher){
        voucherServiceImplementation.insert(voucher);
        Voucher d=voucherServiceImplementation.findFirstByIdVoucher(voucher.getIdVoucher());
        return ResponseEntity.status(HttpStatus.OK).body(d);
    }
    @PostMapping("/Update")
    public void update(@RequestBody Voucher voucher){
        voucherServiceImplementation.update(voucher);
    }
    @PostMapping("/Delete")
    public void delete(@RequestBody Long id){
        Voucher v=voucherServiceImplementation.findFirstByIdVoucher(id);
        voucherServiceImplementation.delete(v);
    }
    @PostMapping("/InsertVoucher")
    public ResponseEntity insertVoucher(@RequestBody InserareVoucher inserareVoucher) {
        Animal a = animalServiceImplementation.findFirstByIdAnimal(inserareVoucher.getIdAnimal());
        Voucher v = new Voucher(inserareVoucher.getNumeVoucher(), inserareVoucher.getNumeBeneficiar(), inserareVoucher.getValoare());
        if (a != null) {
            a.getVouchers().add(v);
            animalServiceImplementation.update(a);
            voucherServiceImplementation.insert(v);
            return ResponseEntity.status(HttpStatus.OK).body(v);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("select an valid id");
        }
    }
}

package com.raex.master.Controller;

import com.raex.master.Entity.AddressDelHelp;
import com.raex.master.Service.Implementation.AddressDelHelpIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address-delhelp")
public class AddressDelHelpController {

    @Autowired
    private AddressDelHelpIMPL addressDelHelpIMPL;

    @GetMapping( "/")
    public ResponseEntity<?> getAllAddress(){
        List<AddressDelHelp> addressDelHelpList = this.addressDelHelpIMPL.getAllAdress();
        return ResponseEntity.ok(addressDelHelpList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddress(@PathVariable int id){
        AddressDelHelp addressDelHelp = this.addressDelHelpIMPL.getAdress(id);
        return ResponseEntity.ok(addressDelHelp);
    }

    @PostMapping("/saveAddress")
    public ResponseEntity<?> saveAddress(@RequestBody AddressDelHelp addressDelHelp){
        AddressDelHelp AddressCreated = this.addressDelHelpIMPL.saveAdress(addressDelHelp);
        return ResponseEntity.status(HttpStatus.CREATED).body(AddressCreated);
    }

    @PutMapping("/updateAddress/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable int id, @RequestBody AddressDelHelp addressDelHelp){
        AddressDelHelp addressUpdate = this.addressDelHelpIMPL.updateAdress(id,addressDelHelp);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressUpdate);
    }

    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable int id){
        this.addressDelHelpIMPL.deleteAdress(id);
        return ResponseEntity.ok().build();
    }
}

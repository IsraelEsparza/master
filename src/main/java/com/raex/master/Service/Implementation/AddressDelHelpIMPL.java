package com.raex.master.Service.Implementation;

import com.raex.master.Entity.AddressDelHelp;
import com.raex.master.Repository.AddressDelHelpRepo;
import com.raex.master.Service.AddressDelHelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddressDelHelpIMPL implements AddressDelHelpService {

    @Autowired
    private AddressDelHelpRepo addressDelHelpRepo;

    @Override
    public List<AddressDelHelp> getAllAdress() {
        return (List<AddressDelHelp>) this.addressDelHelpRepo.findAll();
    }

    @Override
    public AddressDelHelp getAdress(int id) {
        return this.addressDelHelpRepo.findById(id).get();
    }

    @Override
    public AddressDelHelp saveAdress(AddressDelHelp user) {
        user.setCreationDate(saveDate());
        return this.addressDelHelpRepo.save(user);
    }

    @Override
    public AddressDelHelp updateAdress(int id, AddressDelHelp user) {
        AddressDelHelp existingAddress = addressDelHelpRepo.findById(id).get();
        existingAddress.setIdUser(user.getIdUser());
        existingAddress.setNumberAddress(user.getNumberAddress());
        existingAddress.setNameAddress(user.getNameAddress());
        existingAddress.setObservations(user.getObservations());
        existingAddress.setUpdateDate(saveDate());
        return addressDelHelpRepo.save(existingAddress);
    }

    @Override
    public void deleteAdress(int id) {
        this.addressDelHelpRepo.deleteById(id);
    }

    public Date saveDate(){
        java.util.Date currentDate = new java.util.Date();
        java.sql.Date currentDateForSQL = new java.sql.Date(currentDate.getTime());
        return currentDateForSQL;
    }
}

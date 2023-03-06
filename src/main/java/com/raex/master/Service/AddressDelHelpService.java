package com.raex.master.Service;

import com.raex.master.Entity.AddressDelHelp;

import java.util.List;

public interface AddressDelHelpService {

    public List<AddressDelHelp> getAllAdress();
    public AddressDelHelp getAdress(int id);
    public AddressDelHelp saveAdress(AddressDelHelp user);
    public AddressDelHelp updateAdress(int id, AddressDelHelp user);
    public void deleteAdress(int id);
}

package com.anna.storage;

import com.anna.Voucher;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class XmlStorage extends BaseStorage {
    private static final String DEFAULT_FILE_NAME = "vouchers.xml";

    public XmlStorage() {
    }

    @Override
    public ArrayList<Voucher> readAll() throws FileNotFoundException {
        ArrayList<Voucher> result = null;
        try(XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(DEFAULT_FILE_NAME))) {
            result = (ArrayList<Voucher>)xmlDecoder.readObject();
        }
        return result;
    }

    public void writeAll(ArrayList<Voucher> vouchers) throws FileNotFoundException {
        try(XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(DEFAULT_FILE_NAME))) {
            xmlEncoder.writeObject(vouchers);
        }
    }
}

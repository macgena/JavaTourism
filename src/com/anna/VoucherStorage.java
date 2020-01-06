package com.anna;

import java.io.*;
import java.util.ArrayList;

public class VoucherStorage {
    private static final String DEFAULT_FILE_NAME = "vouchers.data";

    public ArrayList<Voucher> readFromFile() throws FileNotFoundException {
        return readFromFile(DEFAULT_FILE_NAME);
    }

    public ArrayList<Voucher> readFromFile(String fileName) throws FileNotFoundException {
        ArrayList<Voucher> result = null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            result = (ArrayList<Voucher>)objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public void writeToFile(ArrayList<Voucher> vouchers) throws FileNotFoundException {
        writeToFile(vouchers, DEFAULT_FILE_NAME);
    }

    public void writeToFile(ArrayList<Voucher> vouchers, String fileName) throws FileNotFoundException {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(vouchers);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } ;
    }
}

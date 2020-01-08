package com.anna.storage;

import com.anna.Voucher;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public abstract class BaseStorage {
    public abstract ArrayList<Voucher> readAll() throws FileNotFoundException;
}

package com.example.covidmanagementapp.Ashraf;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream extends ObjectOutputStream {
    // ✅ THIS CONSTRUCTOR IS REQUIRED
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    // ✅ PREVENT HEADER DUPLICATION
    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }

}

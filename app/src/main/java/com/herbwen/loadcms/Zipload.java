package com.herbwen.loadcms;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.ZipFile;

public class Zipload {
    public static void a(Closeable closeable) {
        if (closeable != null){
            try{
                closeable.close();
            } catch (IOException unused){
            }
        }
    }

    public static void a(ZipFile zipFile){
        if (zipFile!=null){
            try{
                zipFile.close();
            }catch (IOException unused){
            }
        }
    }
}

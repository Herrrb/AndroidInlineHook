package com.herbwen.loadcms;

import android.content.Context;
import android.net.Uri;
import android.os.Build;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LoadTes {

    private static List<String> a = new ArrayList();

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052 A:{SYNTHETIC, Splitter:B:29:0x0052} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0050 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052 A:{SYNTHETIC, Splitter:B:29:0x0052} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x001a */
    /* JADX WARNING: Missing block: B:40:0x0070, code skipped:
            return true;
     */
    public static synchronized boolean a(android.content.Context r8, java.lang.String r9) {
        /*
        r0 = com.ss.sys.ces.h.e.class;
        monitor-enter(r0);
        r1 = a;	 Catch:{ all -> 0x0073 }
        r1 = r1.contains(r9);	 Catch:{ all -> 0x0073 }
        r2 = 1;
        if (r1 == 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r0);
        return r2;
    L_0x000e:
        r1 = 0;
        java.lang.System.loadLibrary(r9);	 Catch:{ UnsatisfiedLinkError -> 0x001a, Throwable -> 0x0018 }
        r3 = a;	 Catch:{ UnsatisfiedLinkError -> 0x001a, Throwable -> 0x0018 }
        r3.add(r9);	 Catch:{ UnsatisfiedLinkError -> 0x001a, Throwable -> 0x0018 }
        goto L_0x006f;
    L_0x0018:
        monitor-exit(r0);
        return r1;
    L_0x001a:
        r3 = java.lang.System.mapLibraryName(r9);	 Catch:{ all -> 0x0073 }
        r4 = 0;
        if (r8 == 0) goto L_0x0046;
    L_0x0021:
        r5 = r8.getFilesDir();	 Catch:{ all -> 0x0073 }
        if (r5 != 0) goto L_0x0028;
    L_0x0027:
        goto L_0x0046;
    L_0x0028:
        r5 = new java.io.File;	 Catch:{ all -> 0x0073 }
        r6 = r8.getFilesDir();	 Catch:{ all -> 0x0073 }
        r7 = "libso";
        r5.<init>(r6, r7);	 Catch:{ all -> 0x0073 }
        r6 = r5.exists();	 Catch:{ all -> 0x0073 }
        if (r6 != 0) goto L_0x0047;
    L_0x0039:
        r6 = r5.getAbsolutePath();	 Catch:{ all -> 0x0073 }
        r7 = new java.io.File;	 Catch:{ all -> 0x0073 }
        r7.<init>(r6);	 Catch:{ all -> 0x0073 }
        r7.mkdirs();	 Catch:{ all -> 0x0073 }
        goto L_0x0047;
    L_0x0046:
        r5 = r4;
    L_0x0047:
        if (r5 == 0) goto L_0x004e;
    L_0x0049:
        r4 = new java.io.File;	 Catch:{ all -> 0x0073 }
        r4.<init>(r5, r3);	 Catch:{ all -> 0x0073 }
    L_0x004e:
        if (r4 != 0) goto L_0x0052;
    L_0x0050:
        monitor-exit(r0);
        return r1;
    L_0x0052:
        r3 = r4.exists();	 Catch:{ all -> 0x0073 }
        if (r3 == 0) goto L_0x005b;
    L_0x0058:
        r4.delete();	 Catch:{ all -> 0x0073 }
    L_0x005b:
        r8 = a(r8, r9, r4);	 Catch:{ all -> 0x0073 }
        if (r8 == 0) goto L_0x0063;
    L_0x0061:
        monitor-exit(r0);
        return r1;
    L_0x0063:
        r8 = r4.getAbsolutePath();	 Catch:{ Throwable -> 0x0071 }
        java.lang.System.load(r8);	 Catch:{ Throwable -> 0x0071 }
        r8 = a;	 Catch:{ Throwable -> 0x0071 }
        r8.add(r9);	 Catch:{ Throwable -> 0x0071 }
    L_0x006f:
        monitor-exit(r0);
        return r2;
    L_0x0071:
        monitor-exit(r0);
        return r1;
    L_0x0073:
        r8 = move-exception;
        monitor-exit(r0);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.sys.ces.h.e.a(android.content.Context, java.lang.String):boolean");
    }



    private static String a(Context context, String str, File file){
        Closeable inputStream;
        Throwable th;
        Closeable closeable = null;
        ZipFile zipFile;
        String stringBuilder;
        try {
            zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
            try {
                Closeable fileOutputStream;
                StringBuilder stringBuilder2 = new StringBuilder("lib/");
                stringBuilder2.append("armeabi-v7a");
                stringBuilder2.append("/");
                stringBuilder2.append(System.mapLibraryName(str));
                ZipEntry entry = zipFile.getEntry(stringBuilder2.toString());
                if (entry == null){
                    StringBuilder stringBuilder3 = new StringBuilder("lib/");
                    String str2 = Build.SUPPORTED_32_BIT_ABIS.toString();
                    int indexOf = Build.SUPPORTED_32_BIT_ABIS.length;
                    stringBuilder3.append(str2.substring(0, indexOf));
                    stringBuilder3.append("/");
                    stringBuilder3.append(System.mapLibraryName(str));
                    entry = zipFile.getEntry(str);
                    if (entry == null){
                        StringBuilder stringBuilder4 = new StringBuilder("Library entry not exit");
                        stringBuilder = stringBuilder4.toString();
                        Zipload.a(null);
                        Zipload.a(null);
                        Zipload.a(zipFile);
                        return stringBuilder;
                    }
                }
                file.createNewFile();
                inputStream = zipFile.getInputStream(entry);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th2){
                    th = th2;
                    try {
                        stringBuilder = th.getMessage();
                        Zipload.a(closeable);
                        Zipload.a(inputStream);
                        Zipload.a(zipFile);
                        return stringBuilder;
                    }catch (Throwable th3) {
                        th = th3;
                        Zipload.a(closeable);
                        Zipload.a(inputStream);
                        Zipload.a(zipFile);
                        throw th;
                    }
                }
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = ((InputStream) inputStream).read(bArr);
                        if (read > 0){
                            ((FileOutputStream) fileOutputStream).write(bArr, 0, read);
                        }else {
                            c.a("android.os.FileUtils", file.getAbsolutePath(), Integer.valueOf(493), Integer.valueOf(-1), Integer.valueOf(-1));
                            Zipload.a(fileOutputStream);
                            Zipload.a(inputStream);
                            Zipload.a(zipFile);
                            return null;
                        }
                    }
                }catch (Throwable th4){
                    th = th4;
                    closeable = fileOutputStream;
                    Zipload.a(closeable);
                    Zipload.a(inputStream);
                    Zipload.a(zipFile);
                    throw th;
                }
            }catch (Throwable th5){
                th = th5;
                inputStream = null;
                Zipload.a(closeable);
                Zipload.a(inputStream);
                Zipload.a(zipFile);
                throw th;
            }
        } catch (Throwable th6){
            th = th6;
            inputStream = null;
            zipFile = null;
            Zipload.a(closeable);
            Zipload.a(inputStream);
            Zipload.a(zipFile);
            return th.toString();
        }
    }
}

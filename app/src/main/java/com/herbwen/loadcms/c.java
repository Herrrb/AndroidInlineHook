package com.herbwen.loadcms;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class c {
    private static final Map<Class<?>, Class<?>> a;

    public static class a<T> {
        public Class<? extends T> a;
        public T b;
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(Boolean.class, Boolean.TYPE);
        a.put(Byte.class, Byte.TYPE);
        a.put(Character.class, Character.TYPE);
        a.put(Short.class, Short.TYPE);
        a.put(Integer.class, Integer.TYPE);
        a.put(Float.class, Float.TYPE);
        a.put(Long.class, Long.TYPE);
        a.put(Double.class, Double.TYPE);
        a.put(Boolean.TYPE, Boolean.TYPE);
        a.put(Byte.TYPE, Byte.TYPE);
        a.put(Character.TYPE, Character.TYPE);
        a.put(Short.TYPE, Short.TYPE);
        a.put(Integer.TYPE, Integer.TYPE);
        a.put(Float.TYPE, Float.TYPE);
        a.put(Long.TYPE, Long.TYPE);
        a.put(Double.TYPE, Double.TYPE);
    }
    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        } else {
            if (clsArr2 == null) {
                return clsArr.length == 0;
            } else {
                if (clsArr.length != clsArr2.length) {
                    return false;
                }
                int i = 0;
                while (i < clsArr.length) {
                    if (!clsArr[i].isAssignableFrom(clsArr2[i]) && (!a.containsKey(clsArr[i]) || !((Class) a.get(clsArr[i])).equals(a.get(clsArr2[i])))) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        try {
            Class cls = Class.forName(str);
            Class[] clsArr = new Class[3];
            int i = 0;
            while (true) {
                Class cls2 = null;
                if (i >= 3) {
                    break;
                }
                Object obj = objArr[i];
                if (obj != null && (obj instanceof a)) {
                    cls2 = ((a) obj).a;
                } else if (obj != null) {
                    cls2 = obj.getClass();
                }
                clsArr[i] = cls2;
                i++;
            }
            while (true) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                if (str2 == null) {
                    throw new NullPointerException("Method name must not be null.");
                }
                for (Method method : declaredMethods) {
                    if (method.getName().equals(str2) && a(method.getParameterTypes(), clsArr)) {
                        break;
                    }
                }
                Method method2 = null;
                if (method2 != null) {
                    method2.setAccessible(true);
                    Object[] objArr2 = new Object[3];
                    for (int i2 = 0; i2 < 3; i2++) {
                        Object obj2 = objArr[i2];
                        if (obj2 == null || !(obj2 instanceof a)) {
                            objArr2[i2] = obj2;
                        } else {
                            objArr2[i2] = ((a) obj2).b;
                        }
                    }
                    method2.invoke(null, objArr2);
                    return;
                } else if (cls.getSuperclass() != null) {
                    cls = cls.getSuperclass();
                } else {
                    throw new NoSuchMethodException();
                }
            }
        } catch (Exception unused) {
        }
    }


}

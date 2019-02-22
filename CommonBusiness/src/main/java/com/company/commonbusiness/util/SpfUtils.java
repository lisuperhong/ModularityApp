package com.company.commonbusiness.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author 李昭鸿
 * @desc: SharedPreferences工具类
 * @date Created on 2017/7/26 11:26
 */

public final class SpfUtils {

    /**
     * 保存在手机里面的文件名
     */
    private static final String FILE_NAME = "share_data";

    /**
     * 保存数据
     *
     * @param key 关键字
     * @param object 保存的值
     */
    public static void put(String key, Object object) {
        SharedPreferences sp = Utils.Companion.getContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        put(sp, key, object);
    }

    /**
     * 保存数据
     *
     * @param spfName 保存的文件名
     * @param key 关键字
     * @param object 保存的值
     */
    public static void put(String spfName, String key, Object object) {
        SharedPreferences sp = Utils.Companion.getContext().getSharedPreferences(spfName,
                Context.MODE_PRIVATE);
        put(sp, key, object);
    }

    private static void put(SharedPreferences sp, String key, Object object) {
        SharedPreferences.Editor editor = sp.edit();

        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }

        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 根据关键字获取数据
     *
     * @param key 关键字
     * @param defaultObject 默认值
     * @return 值
     */
    public static Object get(String key, Object defaultObject) {
        SharedPreferences sp = Utils.Companion.getContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return get(sp, key, defaultObject);
    }

    /**
     * 根据关键字获取数据
     *
     * @param spfName 保存的文件名
     * @param key 关键字
     * @param defaultObject 默认值
     * @return 值
     */
    public static Object get(String spfName, String key, Object defaultObject) {
        SharedPreferences sp = Utils.Companion.getContext().getSharedPreferences(spfName,
                Context.MODE_PRIVATE);
        return get(sp, key, defaultObject);
    }

    private static Object get(SharedPreferences sp, String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param key 关键字
     */
    public static void remove(String key) {
        SharedPreferences sp = Utils.Companion.getContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        remove(sp, key);
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param spfName 保存的文件名
     * @param key 关键字
     */
    public static void remove(String spfName, String key) {
        SharedPreferences sp = Utils.Companion.getContext().getSharedPreferences(spfName,
                Context.MODE_PRIVATE);
        remove(sp, key);
    }

    private static void remove(SharedPreferences sp, String key) {
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 清除所有数据
     */
    public static void clearAll() {
        SharedPreferences sp = Utils.Companion.getContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        clearAll(sp);
    }

    /**
     * 清除所有数据
     *
     * @param spfName 保存的文件名
     */
    public static void clearAll(String spfName) {
        SharedPreferences sp = Utils.Companion.getContext().getSharedPreferences(spfName,
                Context.MODE_PRIVATE);
        clearAll(sp);
    }

    private static void clearAll(SharedPreferences sp) {
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param key 关键字
     * @return {@code true}: Key存在<br>{@code false}: key不存在
     */
    public static boolean contains(String key) {
        SharedPreferences sp = Utils.Companion.getContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return contains(sp, key);
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param spfName
     * @param key 关键字
     * @return {@code true}: Key存在<br>{@code false}: key不存在
     */
    public static boolean contains(String spfName, String key) {
        SharedPreferences sp = Utils.Companion.getContext().getSharedPreferences(spfName,
                Context.MODE_PRIVATE);
        return contains(sp, key);
    }

    private static boolean contains(SharedPreferences sp, String key) {
        return sp.contains(key);
    }

    /**
     * 返回所有的键值对
     */
    public static Map<String, ?> getAll() {
        SharedPreferences sp = Utils.Companion.getContext().getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return getAll(sp);
    }

    /**
     * 返回所有的键值对
     *
     * @param spfName 保存文件名
     */
    public static Map<String, ?> getAll(String spfName) {
        SharedPreferences sp = Utils.Companion.getContext().getSharedPreferences(spfName,
                Context.MODE_PRIVATE);
        return getAll(sp);
    }

    private static Map<String, ?> getAll(SharedPreferences sp) {
        return sp.getAll();
    }

    /**
     * 保存图片到SharedPreferences
     *
     * @param key 关键字
     * @param drawable 保存的图片
     */
    public static void putImage(String key, BitmapDrawable drawable) {
        Bitmap bitmap = drawable.getBitmap();
        // 将Bitmap压缩成字节数组输出流
        ByteArrayOutputStream byStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byStream);
        // 利用Base64将我们的字节数组输出流转换成String
        byte[] byteArray = byStream.toByteArray();
        String imgString = Base64.encodeToString(byteArray, Base64.DEFAULT);
        // 将String保存shareUtils
        SpfUtils.put(key, imgString);
    }

    /**
     * 保存图片到SharedPreferences
     *
     * @param spfName 保存文件名
     * @param key 关键字
     * @param drawable 保存的图片
     */
    public static void putImage(String spfName, String key, BitmapDrawable drawable) {
        Bitmap bitmap = drawable.getBitmap();
        // 将Bitmap压缩成字节数组输出流
        ByteArrayOutputStream byStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byStream);
        // 利用Base64将我们的字节数组输出流转换成String
        byte[] byteArray = byStream.toByteArray();
        String imgString = Base64.encodeToString(byteArray, Base64.DEFAULT);
        // 将String保存shareUtils
        SpfUtils.put(spfName, key, imgString);
    }

    /**
     * 从SharedPreferences读取图片
     *
     * @param key 关键字
     * @return 图片Bitmap
     */
    public static Bitmap getImage(String key) {
        String imgString = (String) SpfUtils.get(key, "");
        if (!imgString.equals("")) {
            // 利用Base64将我们string转换
            byte[] byteArray = Base64.decode(imgString, Base64.DEFAULT);
            ByteArrayInputStream byStream = new ByteArrayInputStream(byteArray);
            // 生成bitmap
            return BitmapFactory.decodeStream(byStream);
        }
        return null;
    }

    /**
     * 从SharedPreferences读取图片
     *
     * @param spfName 保存文件名
     * @param key 关键字
     * @return 图片Bitmap
     */
    public static Bitmap getImage(String spfName, String key) {
        String imgString = (String) SpfUtils.get(spfName, key, "");
        if (!imgString.equals("")) {
            // 利用Base64将我们string转换
            byte[] byteArray = Base64.decode(imgString, Base64.DEFAULT);
            ByteArrayInputStream byStream = new ByteArrayInputStream(byteArray);
            // 生成bitmap
            return BitmapFactory.decodeStream(byStream);
        }
        return null;
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         */
        @SuppressWarnings({ "unchecked", "rawtypes" })
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         */
        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e) {

            } catch (IllegalAccessException e) {

            } catch (InvocationTargetException e) {

            }
            editor.commit();
        }
    }
}

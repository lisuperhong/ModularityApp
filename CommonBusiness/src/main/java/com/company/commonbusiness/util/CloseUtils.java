package com.company.commonbusiness.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author 李昭鸿
 * @desc: 关闭相关工具类
 * @date Created on 2017/7/26 11:02
 */

public final class CloseUtils {

     private CloseUtils() {
         throw new UnsupportedOperationException("u can't instantiate me...");
     }

     /**
      * 关闭IO
      *
      * @param closeables closeables
      */
     public static void closeIO(final Closeable... closeables) {
         if (closeables == null) return;
         for (Closeable closeable : closeables) {
             if (closeable != null) {
                 try {
                     closeable.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
     }

     /**
      * 安静关闭IO
      *
      * @param closeables closeables
      */
     public static void closeIOQuietly(final Closeable... closeables) {
         if (closeables == null) return;
         for (Closeable closeable : closeables) {
             if (closeable != null) {
                 try {
                     closeable.close();
                 } catch (IOException ignored) {
                 }
             }
         }
     }
}

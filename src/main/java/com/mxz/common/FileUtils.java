package com.mxz.common;

import java.util.Objects;
import java.util.Optional;

/**
 * @Description
 * @Date 2019/11/2 13:00
 * @Author mxz
 */
public class FileUtils {

    public static String getFileSuffix(String fileName) {
        int suffixIndex;
        if (Objects.isNull(fileName)) {
            return null;
        } else if (fileName.lastIndexOf(".") > 0){
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}

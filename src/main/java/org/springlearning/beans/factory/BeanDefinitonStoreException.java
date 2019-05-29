package org.springlearning.beans.factory;

import org.springlearning.beans.BeansException;

//读取XML文件出错时抛出异常
public class BeanDefinitonStoreException extends BeansException {
    public BeanDefinitonStoreException(String msg) {
        super(msg);
    }

    public BeanDefinitonStoreException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

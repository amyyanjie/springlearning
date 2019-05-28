package org.springlearning.beans.factory;

import org.springlearning.beans.BeansException;

public class BeanDefinitonStoreException extends BeansException {
    public BeanDefinitonStoreException(String msg) {
        super(msg);
    }

    public BeanDefinitonStoreException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

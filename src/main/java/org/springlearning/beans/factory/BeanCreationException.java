package org.springlearning.beans.factory;

import org.springlearning.beans.BeansException;

//创建Bean出错时抛出异常
public class BeanCreationException extends BeansException {
    private String beanName;

    public BeanCreationException(String msg) {
        super(msg);
    }

    public BeanCreationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BeanCreationException(String msg, String beanName) {
        super("Error creating bean with name'" + beanName + "':" + msg);
        this.beanName = beanName;
    }

    public BeanCreationException(String msg, String beanName, Throwable cause) {
        this(beanName, msg);
        initCause(cause);
    }

    public String getBeanName() {
        return this.beanName;
    }
}

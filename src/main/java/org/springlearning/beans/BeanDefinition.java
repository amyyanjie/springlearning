package org.springlearning.beans;

public interface BeanDefinition {
    String SCOPE_SINGLETON="singleton";
    String SCOPE_PROTOTYPE="prototype";
    String SCOPE_DEFAULT="";
    boolean isSingleton();
    boolean isPrototype();
    void setScope(String scope);
    String getScope();
    String getBeanClassName();
}

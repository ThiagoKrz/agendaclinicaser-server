package com.nexcodelab.uniforum.core.config.exceptionhandler.exceptions;


public abstract class CustomRestException extends RuntimeException{

    public String getTitle(){
        return separaNomeDeClasses(getClass().getSimpleName()) + ", Check Details.";
    }

    public String getDevelopersMessage(){
        return this.getClass().getSimpleName() +": " + getDevMessage();
    }

    protected abstract String getDevMessage();

    public CustomRestException(String message) {
        super(message);
    }

    private String separaNomeDeClasses(String simpleName){
        return simpleName.replaceAll("([a-z])([A-Z])", "$1 $2");
    }
}

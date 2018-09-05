package com.chandler.exp.interview;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface FruitName {
    String value() default "";
}

/**
 * Annotation and reflection
 * @author chand
 *
 */
public class AppleAnnotation {
    
    @FruitName("Apple")
    public String appleName;//only public field can be found
        
    
    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }
    public String getAppleName() {
        return appleName;
    }
    
    @FruitName("Apple1")
    public void displayName(){
        System.out.println("This is a/an: "+this.appleName);
    }
    
    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException, NoSuchFieldException{
    	Class <?> c = null ;  
        c = Class.forName("com.chandler.exp.interview.AppleAnnotation") ;
        Method toM = c.getMethod("displayName") ;  // find method by name: displayName()
        if(toM.isAnnotationPresent(FruitName.class)){  //check if annotation is present
        	FruitName fn = toM.getAnnotation(FruitName.class) ; // get Annotation              
            String value = fn.value() ;    // get value  
            System.out.println("value = " + value) ;  
        }  
        
        Field toF = c.getField("appleName");  // 
        if(toF.isAnnotationPresent(FruitName.class)){  //check if annotation is present
        	FruitName fn = toF.getAnnotation(FruitName.class) ; // get Annotation              
            String value = fn.value() ;    // get value  
            System.out.println("value = " + value) ;  
        }  
    }
}

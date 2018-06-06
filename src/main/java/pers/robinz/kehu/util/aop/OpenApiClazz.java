package pers.robinz.kehu.util.aop;

import java.lang.annotation.*;

/**
 * Created by Robinz on 2018-06-05.
 * 标注这是一个提供对外接口的类
 * 类中所有方法会被pers.robinz.kehu.util.aop.ControllerAop4Api这个Aop拦截
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OpenApiClazz {

    String value() default "";
}
package com.yy.lib_navigation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 作者：addison on 2020-02-18 13:27
 * 邮箱：gengxin@tech.youyuan.com
 */
@Target(ElementType.TYPE)
public @interface FragmentDestination {
    String pageUrl();
    /**是否需要登录拦截*/
    boolean needLogin() default false;
    /**是否作为默认启动页面*/
    boolean asStarter() default false;
}

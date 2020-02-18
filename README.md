# AnnotationBottomNavigationView
本Demo主要功能实现两点:

1、主要利用注解形式生成Destination所需数据，通过注解解析器将自定义属性以JSON字符串的形式写入到assets目录下，通过读取该文件并解析JSON数据，生成Navigator所需要的Destination，并交个对应的navigator进行分发，替代在xml中配置navGraph属性，并且可以扩展自定义字段。

2、自定义BottomNavigationView，通过json配置解析的方式动态的向BottomNavigationView中添加MenuItem，并且可以灵活扩展字段，这种方式有助于场景拓展，譬如权限拦截等，次demo中还实现了未读消息等效果



##  效果图

<img src="(https://user-images.githubusercontent.com/30682550/74759818-5876e800-52b4-11ea-9bd4-41ab2c1c45b7.png" width="70%" height="70%">


##  FixFragmentNavigator
定制的Navigator，替换ft.replace(mContainerId, frag);为 hide()/show(),原生的FragmentNavigator  使用的replace方法会重走fragment的生命周期

##  自定义注解
```java
public @interface FragmentDestination {
    String pageUrl();   //deepLink标识 相当于隐式意图

    boolean needLogin() default false;  //是否需要登录拦截

    boolean asStarter() default false;  //默认展示页面
}
```
自定义两种Destination注解`ActivityDestination`和`FragmentDestination` 并扩展自定义属性，举个例子是否需要登录拦截`needLogin`,`pageUrl`相当于隐式意图，主要用户deepLink赋值


##  NavProcessor

注解解析器，将注解自定义属性解析 并封装成JavaBean，以JSON形式写入到assets中


## AppConfig

将生成的JSON文件进行读取解析，并生成对应的javabean


##NavGraphBuilder

顾名思义将解析的Destination数据交给NavController处理 动态生成对应的Destination	

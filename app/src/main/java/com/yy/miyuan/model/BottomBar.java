package com.yy.miyuan.model;

import java.util.List;

/**
 * 作者：addison on 2020-02-18 21:40
 * 邮箱：gengxin@tech.youyuan.com
 */
public class BottomBar  {

    /**
     * activeColor : #9B71FE
     * inActiveColor : #383838
     * selectTab : 0
     * tabs : [{"size":24,"enable":true,"index":0,"countDot":-1,"redDot":false,"pageUrl":"main/tabs/home","title":"首页"},{"size":24,"enable":true,"index":1,"countDot":-1,"redDot":false,"pageUrl":"main/tabs/blind","title":"相亲"},{"size":24,"enable":true,"index":2,"countDot":-1,"redDot":false,"tintColor":"#9B71FE","pageUrl":"main/tabs/dynamic","title":"动态"},{"size":24,"enable":true,"index":3,"countDot":0,"redDot":false,"pageUrl":"main/tabs/msg","title":"消息"},{"size":24,"enable":true,"countDot":-1,"redDot":true,"index":4,"pageUrl":"main/tabs/mine","title":"我的"}]
     */

    public String activeColor;
    public String inActiveColor;
    public int selectTab;
    public List<Tabs> tabs;


}

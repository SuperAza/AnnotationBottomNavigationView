package com.yy.miyuan.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.yy.miyuan.R;
import com.yy.miyuan.model.BottomBar;
import com.yy.miyuan.model.Destination;
import com.yy.miyuan.model.Tabs;
import com.yy.miyuan.utils.AppConfig;

import java.util.List;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * 作者：addison on 2020-02-18 21:49
 * 邮箱：gengxin@tech.youyuan.com
 * 未读消息可拖拽
 */
public class AppBottomBar extends BottomNavigationView {
    private static int[] sIcons = new int[]{
            R.drawable.bottombar_home_selector,
            R.drawable.bottombar_blind_selector,
            R.drawable.bottombar_dynamic_selector,
            R.drawable.bottombar_msg_selector,
            R.drawable.bottombar_mine_selector,};
    private BottomBar config;

    public AppBottomBar(Context context) {
        this(context, null);
    }

    public AppBottomBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressLint("RestrictedApi")
    public AppBottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        config = AppConfig.getBottomBarConfig();

        int[][] state = new int[2][];
        state[0] = new int[]{android.R.attr.state_selected};
        state[1] = new int[]{};
        int[] colors = new int[]{Color.parseColor(config.activeColor), Color.parseColor(config.inActiveColor)};
        ColorStateList stateList = new ColorStateList(state, colors);
        setItemTextColor(stateList);
        //如果不适用颜色作为selector必须使用下面语句，否则无效
        setItemIconTintList(null);
        /**
         * 如果想要禁止掉所有按钮的点击浮动效果。
         * 那么还需要给选中和未选中的按钮配置一样大小的字号。
         *
         *  在MainActivity布局的AppBottomBar标签增加如下配置，
         *  @style/active，@style/inActive 在style.xml中
         *  app:itemTextAppearanceActive="@style/active"
         *  app:itemTextAppearanceInactive="@style/inActive"
         */
        setItemTextAppearanceActive(R.style.active);
        setItemTextAppearanceInactive(R.style.inActive);
        //LABEL_VISIBILITY_LABELED:设置按钮的文本为一直显示模式
        //LABEL_VISIBILITY_AUTO:当按钮个数小于三个时一直显示，或者当按钮个数大于3个且小于5个时，被选中的那个按钮文本才会显示
        //LABEL_VISIBILITY_SELECTED：只有被选中的那个按钮的文本才会显示
        //LABEL_VISIBILITY_UNLABELED:所有的按钮文本都不显示
        setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        List<Tabs> tabs = config.tabs;
        for (Tabs tab : tabs) {
            if (!tab.enable) {
                continue;
            }
            int itemId = getItemId(tab.pageUrl);
            if (itemId < 0) {
                continue;
            }
            MenuItem menuItem = getMenu().add(0, itemId, tab.index, tab.title);
            menuItem.setIcon(sIcons[tab.index]);

        }

        //此处给按钮icon设置大小
        int index = 0;
        for (Tabs tab : config.tabs) {
            if (!tab.enable) {
                continue;
            }

            int itemId = getItemId(tab.pageUrl);
            if (itemId < 0) {
                continue;
            }

            int iconSize = dp2Px(tab.size);
            BottomNavigationMenuView menuView = (BottomNavigationMenuView) getChildAt(0);
            BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(index);
            itemView.setIconSize(iconSize);
            itemView.setShifting(false);
            //需要展示红点并展示数字
            if(tab.countDot > -1){
                new QBadgeView(getContext())
                        .bindTarget(itemView)
                        .setBadgeGravity(Gravity.TOP|Gravity.END)
                        .setBadgeBackgroundColor(0xffff0000)
                        .setBadgeNumber(6)
                        .setShowShadow(true)
                        //offset可以根据控件的宽高 进行比例计算
                        .setGravityOffset(10,5,true)
                        .setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                    @Override
                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                        Toast.makeText(getContext(),"拖拽了",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            if(tab.redDot){
                new QBadgeView(getContext())
                        .bindTarget(itemView)
                        .setBadgeGravity(Gravity.TOP|Gravity.END)
                        .setBadgeBackgroundColor(0xffff0000)
                        .setShowShadow(true)
                        .setBadgeTextSize(2,true)
                        .setBadgeText("")
                        .setGravityOffset(15,10,true)
                        .setOnDragStateChangedListener(null);
            }


            /**此处是为了掩饰效果做了字符串判断，并不规范，可以根据需求自定义字段*/
            if(tab.title.equals("相亲")){
                new QBadgeView(getContext())
                        .bindTarget(itemView)
                        .setBadgeTextSize(13, true)
                        .setBadgeBackgroundColor(0xffffeb3b).setBadgeTextColor(0xff000000)
                        .stroke(0xff000000, 1, true)
                        .setShowShadow(true)
                        .setBadgeText("热")

                        //offset可以根据控件的宽高 进行比例计算
                        .setGravityOffset(8,4,true)
                        .setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                            @Override
                            public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                                Toast.makeText(getContext(),"拖拽了",Toast.LENGTH_SHORT).show();
                            }
                        });
            }

            index++;
        }

        //底部导航栏默认选中项
        if (config.selectTab != 0) {
            Tabs selectTab = config.tabs.get(config.selectTab);
            if (selectTab.enable) {
                int itemId = getItemId(selectTab.pageUrl);
                //这里需要延迟一下 再定位到默认选中的tab
                //因为 咱们需要等待内容区域,也就NavGraphBuilder解析数据并初始化完成，
                //否则会出现 底部按钮切换过去了，但内容区域还没切换过去
                post(() -> setSelectedItemId(itemId));
            }
        }
    }

    private int dp2Px(int dpValue) {
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        return (int) (metrics.density * dpValue + 0.5f);
    }

    private int getItemId(String pageUrl) {
        Destination destination = AppConfig.getDestConfig().get(pageUrl);
        if (destination == null)
            return -1;
        return destination.id;
    }
}
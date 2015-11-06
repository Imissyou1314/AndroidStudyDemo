package com.cheng.animationstudy.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.cheng.animationstudy.R;
import com.cheng.utils.Logger;

import java.util.Random;

public class UiActivityJump extends AppCompatActivity {

    private static int randomInt = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_activityjump);
    }

    public void showHorizontalSlideTransition(View v) {
        overlay();
        randomInt++;
        Logger.e(randomInt);
        switch ((randomInt)%3) {
            case 0:
                // 设置切换动画，从右边进入，左边退出
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case 1:
                // 设置切换动画，从右边进入，左边退出,带动态效果
                overridePendingTransition(R.anim.dync_in_from_right, R.anim.dync_out_to_left);
                break;
            case 2:
                // 设置切换动画，从右边进入，左边退出,带动态效果
                overridePendingTransition(R.anim.new_dync_in_from_right, R.anim.new_dync_out_to_left);
                break;
        }
    }

    public void showVerticleTransition(View v) {
        overlay();
        // 设置动画，从下进入，从上退出
        overridePendingTransition(R.anim.in_from_down, R.anim.out_to_up);
    }

    public void showScaleUpTrans(View v) {

    }

    public void showThumbnailTrans(View v) {

    }

    public void showSceneTrans(View v) {

    }

    public void showVerticalTransfer(View v) {

    }

    public void showFadeInFadeOutTrans(View v) {

    }

    private void overlay() {
        overlay(UiActivityJumpAim.class);
    }

    private void overlay(Class clazz) {
        Intent intent = new Intent(UiActivityJump.this, clazz);
        startActivity(intent);
    }

    // android转场动画windowAnimation和ActivityAnimation的区别
    /*
    android转场动画windowAnimation和ActivityAnimation的区别
    显而易见，window与Activity本身从名字上就知道不同，但对于项目开发中
    windowAnimation和ActivityAnimation的区别必须心领神会。
    区别主要如下
    1.windowAnimation包括 windowEnterAnimation 和 windowExitAnimation ；
    ActivityAnimation包含 android:activityOpenEnterAnimation ，
    android:activityOpenExitAnimation ， android:activityCloseEnterAnimation
    和 android:activityCloseExitAnimation
    2.在项目中WindowAnimation的控制权大于Activity的控制权，
    即在Activity转场过程中，如果同时设置了WindowAnimation和ActivityAnimation,
    那么可能（因为这种情况非常多）只会执行WindowAnimation
    3.对于WindowAnimation的定义很简单，在style.xml文件中只需要继承Animation Style即可
    <style name="Animation" parent="@android:style/Animation">
        <!--窗体进入动画-->
        <item name="android:windowEnterAnimation">@anim/slide_left_enter</item>
        <!--窗体退出动画-->
        <item name="android:windowExitAnimation">@anim/slide_right_exit</item>
    </style>
    对于Activity,需要继承Animation Activity Style
    <style name="FeelyouWindowAnimTheme" parent="@android:style/Animation.Activity">
          <item name="android:activityOpenEnterAnimation">@android:anim/slide_in_left</item>
          <item name="android:activityOpenExitAnimation">@android:anim/slide_out_right</item>
          <item name="android:activityCloseEnterAnimation">@anim/push_right_in</item>
          <item name="android:activityCloseExitAnimation">@anim/push_left_out</item>
    </style>
    当我们从 A1 启动 A2 时，A1 从屏幕上消失，这个动画叫做 android:activityOpenExitAnimation
    当我们从 A1 启动 A2 时，A2 出现在屏幕上，这个动画叫做 android:activityOpenEnterAnimation
    当我们从 A2 退出回到 A1 时，A2 从屏幕上消失，这个叫做 android:activityCloseExitAnimation
    当我们从 A2 退出回到 A1 时，A1 出现在屏幕上，这个叫做 android:activityCloseEnterAnimation
    从上述2中动画的定义上来看，显然ActivityAnimation更为复杂，但这种复杂带来的转场效果非常好，
    可以同时控制2个Activity的动画，而不像WindowAnimation只能控制下一个Activity的窗体动画。
    5.在开发中，窗体动画也可以使用 Activity. overridePendingTransition来设置,也可以定义在主题中，
    但Activity只能使用在主题中
    <application
        android:name="test.view.weitop.BaseApplication"
        android:allowBackup="false"
        android:hardwareAccelerated="false"
        android:icon="@drawable/app_logo"
        android:label="@string/app_name"
        android:largeHeap="true"
        android:theme="@style/Theme.App" >
    </application>
    6.对于比较追求界面美感的动画，使用ActivityAnimation要好得多，
    因此对于一般开发使用windowAnimation即可，但对于追求用户体验，那么直接使用Activity Animation
     */

}

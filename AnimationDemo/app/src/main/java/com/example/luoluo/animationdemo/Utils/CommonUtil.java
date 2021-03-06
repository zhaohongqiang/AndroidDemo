package com.example.luoluo.animationdemo.Utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class CommonUtil {

    /* dp转换成px
     */
    public static int dpTopx(Context context, float dpValue){
        float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale+0.5f);
    }

    /**
     * px转换成dp
     */
    public static int pxTodp(Context context,float pxValue){
        float scale=context.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f);
    }

    //获取控件的尺寸---目前测试仅对xml中wrap_content有效
    public static Size getWidgetSize(View view){

        //通过先执行一次测量方法 获取控件的宽高
        int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);//开始测量
        int  height =view.getMeasuredHeight();
        int width =view.getMeasuredWidth();

        Size size  = new Size(width,height);
        return size;
    }

    //设置控件的宽
    public  static  void  setWidth(View view,int width){
        ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(view.getLayoutParams());
        params.width = width;
        view.setLayoutParams(params);
    }
    //获取屏幕像素的宽
    public static int getScreenWidth(Context context){
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;//获取的为像素
        return width;
    }
    //获取屏幕的高
    public  static  int getScreenHeight(Context context){
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int height = outMetrics.heightPixels;
        return height;
    }

    public static double  angleToRadians(double angle){
        return angle*Math.PI/180;
    }

}

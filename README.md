pinned
======

Android实现 某一个区域 的 Pin效果

实现原理：
![image](https://github.com/syupo/pinned/raw/master/sketch/pinned_sketch.png)

1.定义布局文件
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:orientation="vertical" >
    
    <your.company.ScrollViewWithPinnedView
        android:id="@+id/main_scroll"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent" >
        ...
        
        <LinearLayout
            android:id="@+id/pinned"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:background="#ffacacac" >

            <Button
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="pinned view here" />

            <TextView
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="awesome" />

            <Button
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="pinned view here" />
        </LinearLayout>
        
        ...
        
    </your.company.ScrollViewWithPinnedView>

</LinearLayout>

2.在Activity onCreate方法中启用Pin
((ScrollViewWithPinnedView)findViewById(R.id.yourscrollid)).setPinnedView(this.findViewById(R.id.pinned));

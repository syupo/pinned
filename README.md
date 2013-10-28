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

License
======

Copyright 2013 syupo.lee

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.


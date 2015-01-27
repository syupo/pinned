pinned
======

Android实现 某一个区域 的 Pin效果

<del>原理图解：</del>
-------------
<del>https://github.com/syupo/pinned/raw/master/sketch/pinned_sketch.png</del>

代码集成：
-------------
+ git clone https://github.com/syupo/pinned.git
+ import maven project in Eclipse. &lt;your git repository path&gt;/pinned/share.pinned
+ reference this project as a android lib project.
+ make sure a frame layout is your first child of scroll view. 

示例：
-------------

* 布局文件example_layout.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:orientation="vertical" >
    
    <fnly.share.pinned.ScrollViewPinnedImpl
        android:id="@+id/main_scroll"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent" >
        
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
        
    </fnly.share.pinned.ScrollViewPinnedImpl>

 </LinearLayout>
```

* Activity Class ExampleActivity.java
```android
onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.example_layout);
    
    mScrollWithPinnedView = (ScrollViewWithPinnedView)findViewById(R.id.yourscrollid))
    mScrollWithPinnedView.setPinnedView(this.findViewById(R.id.pinned));
}
```

License
======

Copyright 2014 Syupo

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.


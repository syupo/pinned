pinned
======

Android实现 某一个区域 的 Pinned效果

![image](https://github.com/syupo/pinned/raw/master/sketch/pinned_picture.png)

功能说明：
-------------
实现向上滚动屏幕到一定位置时让某个视图固定在此处，而向下滚动屏幕到此处时再恢复到原来的视图。

<font style="color:#f00">注意：</font> 布局文件中 ScrollView 的第一个子View必须使用FrameLayout

代码集成：
-------------
+ git clone https://github.com/syupo/pinned.git
+ import maven project in Eclipse. &lt;your git repository path&gt;/pinned/share.pinned
+ reference this project as a android lib project.
+ make sure a frame layout is your first child of scroll view. 

示例：
-------------
请参看share.pinned.simple



License
======

Copyright 2014-2015 Syupo

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.


    题目：Github 用户搜索**

    Github 提供了获取用户数据的RESTful API：

    1. 查询用户：https://api.github.com/search/users?q=test

    2. 查询用户的Repos：https://api.github.com/users/test/repos

    请编写一个Android App，在输入查询关键字后，能够实时显示出结果列表，
    列表每一项对应用户的信息，
    包括：用户名，用户头像，用户的编程语言偏好（需要统计使用最多的一种语言，可以从用户Repos中获取到）。


    如遇鉴权问题等请查阅GitHub文档解决。

    **要求：**
    * 功能完整正确，符合题目要求
    * 程序架构清晰，体现分层思想，建议使用MVP架构
    * 代码尽量整洁，
    不包含无用代码，可以使用github上的开源代码
    * 代码必须使用github托管
    * 请使用Android Studio开发

# Github Application

### 项目所用开源库

        compile 'com.github.bumptech.glide:glide:3.7.0'
        compile 'com.android.support:appcompat-v7:25.2.0'
        compile 'com.jakewharton:butterknife:8.5.1'
        compile 'io.reactivex.rxjava2:rxjava:2.0.6'
        compile 'io.reactivex.rxjava2:rxandroid:2.0.1'
        compile 'com.squareup.retrofit2:adapter-rxjava2:2.2.0'
        compile 'com.squareup.retrofit2:retrofit:2.2.0'
        compile 'com.squareup.retrofit2:converter-gson:2.2.0'
        compile 'com.google.code.gson:gson:2.8.0'
        compile 'com.orhanobut:logger:1.15'
        compile 'com.android.support:design:25.2.0'
        compile 'com.android.support.constraint:constraint-layout:1.0.0-alpha8'
        testCompile 'junit:junit:4.12'
        annotationProcessor 'com.jakewharton:butterknife-compiler:8.5.1'

### 描述

项目采用MVP架构

* View层UI布局，数据渲染，点击按钮交互等等
* Presenter层负责M和V层的对接
* Model层负责数据的存取

### 作者

* Email:13060393903@163.com
* QQ:979433196

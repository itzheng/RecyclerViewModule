# RecyclerViewModule
对RecyclerView的一些基本封装，后期会继续完善
# 使用说明：
## 第一步：
### 在 Project 的 build.gradle 文件中 添加仓库支持
```groovy
allprojects {
    repositories {
        
        maven { url 'https://jitpack.io' }
    }
} 
```
## 第二步：
### 在需要引用的项目的 build.gradle 添加依赖
[see javadoc](https://javadoc.jitpack.io/com/github/itzheng/RecyclerViewModule/latest/javadoc/index.html)
[![](https://jitpack.io/v/itzheng/RecyclerViewModule.svg)](https://jitpack.io/#itzheng/RecyclerViewModule)
```groovy
dependencies {
        
       implementation 'com.github.itzheng:RecyclerViewModule:0.0.3'
}
```

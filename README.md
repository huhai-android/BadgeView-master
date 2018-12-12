# BadgeView
简化消息红点显示。


## 使用步骤

*添加依赖
<pre>
 <code>
allprojects {
   repositories {
               ...
           maven { url 'https://jitpack.io' }
     }
}
</code>
</pre>

<pre>
 <code>
dependencies {
          implementation 'com.github.huhaiAndroid:BadgeView-master:1.0'
	}
	</code>
    </pre>
*参数设定

  app:isShowAllNumber //当数量大于99时候，是否显示99+或者显示完整数字
       app:bgcolor        //背景颜色


      <com.example.huhai.badgeredview.BadgeView
          android:background="@color/yellow"
          android:id="@+id/text2"
          android:layout_marginLeft="10dp"
          android:paddingLeft="4dp"
          android:paddingRight="4dp"
          android:paddingBottom="1dp"
          android:paddingTop="1dp"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="1"
          android:textColor="@color/white"
          app:isShowAllNumber="true"
          app:bgcolor="@color/red"
          />





    
  
  
  
  
  














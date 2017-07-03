package com.example.kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * kotlin定义的原则  需要先定义名称 然后在定义类型
 * kotlin控件的属性都要在.前面加上!!两个冒号
 */
class MainActivity : AppCompatActivity() {
    var tv: TextView? = null
    var btn:Button?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv= findViewById(R.id.text) as TextView?//获取控件
        tv!!.text="Hello World!"//给控件赋值
        btn= findViewById(R.id.button) as Button?
        /**
         * TextView的点击事件
         */
        tv!!.setOnClickListener(View.OnClickListener {
            toast("点击了Hello World!")
        })
        /**
         * button的点击事件
         */
        btn!!.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            //获取intent对象
            intent.setClass(this,Main2Activity::class.java)
            // 获取class是使用::反射
            startActivity(intent)
        })

    }

    /**
     * 函数（我们Java中的方法）可以使用fun关键字就可以定义:
     * 带有返回参数的构造方法
     * Kotlin中的参数与Java中有些不同。如你所见，我们先写参数的名字再写它的类型
     */
    fun add(x:Int,y:Int):Int{
        return x+y
    }

    /**
     * 我们可以给参数指定一个默认值使得它们变得可选，这是非常有帮助的！；例如length我们给他默认赋值了
     * 一个Toast.LENGTH_SHORT，在调用这儿方法的时候  你可以toast("message"),
     * 也可以toast("message",Toast.LENGTH_SHORT)
     */
    fun toast(message:String ,length:Int=Toast.LENGTH_SHORT){
        Toast.makeText(this,message+""+add(10,20),length).show()
    }

}




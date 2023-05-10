package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public int getAllChildViewCount(View view) {
        //广度优先实现——使用队列
        int value = 0;
        LinkedList<View> linkedList = new LinkedList<View>();
        View v = view;
        linkedList.push(v);
        while(!linkedList.isEmpty()){
            v = linkedList.poll();
            value++;
            if(v instanceof ViewGroup){
                for(int len=((ViewGroup) v).getChildCount(),i=0;i<len;i++){
                    View childView = ((ViewGroup) v).getChildAt(i);
                    linkedList.addLast(childView);
                }
            }
        }
        return value;
    }

    public int getAllChildViewCount2(View view){
        //深度优先实现——使用栈
        int value = 0;
        LinkedList<View> linkedList = new LinkedList<>();
        View v = view;
        linkedList.push(v);
        while(!linkedList.isEmpty()){
            v = linkedList.pop();
            value++;
            if(v instanceof ViewGroup){
                for(int len=((ViewGroup) v).getChildCount(),i=0;i<len;i++){
                    View childView = ((ViewGroup) v).getChildAt(i);
                    linkedList.push(childView);
                }
            }
        }
        return value;
    }
}

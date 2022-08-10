package com.ming.hashMap;

import java.util.HashMap;

public class HashMapLearning {
    public static void main(String[] args) {
        HashMap hashMap=new HashMap();
        for (Integer i=0;i<200;i++){
            //创建一个对象是因为想要使得hashCode一致
            Bean bean=new Bean(i);
            System.out.println(bean.hashCode());
            hashMap.put(bean,i);
        }
    }
}

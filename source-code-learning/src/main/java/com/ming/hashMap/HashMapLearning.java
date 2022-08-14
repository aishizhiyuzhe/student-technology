package com.ming.hashMap;

import java.util.HashMap;

public class HashMapLearning {
    public static void main(String[] args) {
        HashMap<Bean,Integer> hashMap=new HashMap();
        Bean[] beans=new Bean[400];
        for (Integer i=0;i<400;i++){
            //创建一个对象是因为想要使得hashCode一致
            beans[i]=new Bean(i);
            System.out.println(i+"-----------------"+beans[i].hashCode());
            hashMap.put(beans[i],i);
        }

        hashMap.remove(beans[100]);

    }
}

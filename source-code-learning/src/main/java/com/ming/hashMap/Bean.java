package com.ming.hashMap;

public class Bean {
    private int i;

    private int hashCode=-1;
    public Bean(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        if (hashCode==-1){
            hashCode=(int)(Math.random()*64+1);
        }
        return hashCode;
    }
}

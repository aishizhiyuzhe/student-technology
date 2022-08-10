package com.ming.hashMap;

public class Bean {
    private int i;

    public Bean(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return (int)(Math.random()*100+1);
    }
}

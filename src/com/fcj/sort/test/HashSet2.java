package com.fcj.sort.test;

import java.util.HashSet;

/**
 * Created by dormi on 2017/3/18.
 */
public class HashSet2
{
    public static void main(String[] args)
    {
        HashSet hashSet = new HashSet();
        People p1 = new People("zhangsan");
        People p2 = new People("zhangsan");
        //重写hashcode（）以及equals方法，实现：
        // 无所谓是不是相同的对象，只根据对对象具体的数值是否相同来进行add的增加
        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println(hashSet);
    }
}
class People
{
    String name;
    People(String name)
    {
        this.name=name;
    }
    public int hashCode()
    {
        return this.name.hashCode();
    }
    public boolean equals(Object obj)
    {
        if(this==obj)
        {
            return true;
        }
        if(obj!=null&&obj instanceof People)
        {
            People p = (People)obj;
            if(name.equals(p.name))
            {
                return true;
            }
        }
        return false;
    }

}
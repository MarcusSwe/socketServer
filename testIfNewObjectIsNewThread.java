package me.code;

public class testIfNewObjectIsNewThread
{

    public testIfNewObjectIsNewThread() {

    }

    public void start(){
        System.out.println("hej från nytt objekt");
        Thread current = Thread.currentThread();
        System.out.println("current thread: " + current.getId());
    }


}

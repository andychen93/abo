package com.cl.common.bean;

import java.util.concurrent.atomic.AtomicInteger;

import com.cl.common.enums.DBEnum;

public class DBHandler {
	private static final ThreadLocal<DBEnum> dbHandler = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBEnum dbType) {
        dbHandler.set(dbType);
    }

    public static DBEnum get() {
        return dbHandler.get();
    }

    public static void master() {
        set(DBEnum.MASTER);
        System.out.println("切换到master");
    }

    public static void slave() {
        //  轮询
        int index = counter.getAndIncrement() % 2;
        if (counter.get() > 9999) {
            counter.set(-1);
        }
        if (index == 0) {
            set(DBEnum.SLAVE1);
            System.out.println("切换到slave1");
        }
    }
}

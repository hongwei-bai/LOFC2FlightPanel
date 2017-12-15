package model;

import java.io.IOException;

import socket.server.SocketServerHelper;

public class Dispatcher implements Runnable {
    private static Dispatcher mSingleton = null;
    private static SocketServerHelper mSocketServerHelper = new SocketServerHelper(8044);

    public static Dispatcher getInstance() {
        if (null == mSingleton) {
            synchronized (Dispatcher.class) {
                if (null == mSingleton) {
                    mSingleton = new Dispatcher();
                }
            }
        }
        return mSingleton;
    }

    private Dispatcher() {

    }

    @Override
    public void run() {
        try {
            mSocketServerHelper.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SocketServerHelper getSocketServerHelper() {
        return mSocketServerHelper;
    }
}

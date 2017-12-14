package socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import utils.Log;

public class SocketServerHelper {
    private final String TAG = "SocketServerHelper";
    private int mListeningPort = -1;

    // Callback interface
    private SocketServerHelperListener mCallbackListener = null;

    public interface SocketServerHelperListener {
        public void onClientAccepted(String clientAddr);

        public void onClientQuit();

        public void onInfoReceived(String info);
    }

    public void setSocketServerHelperListener(SocketServerHelperListener l) {
        this.mCallbackListener = l;
    }

    public SocketServerHelper(int listeningPort) {
        this.mListeningPort = listeningPort;
    }

    public void listen() throws IOException {
        ServerSocket servSock = new ServerSocket(mListeningPort);
        Log.d(TAG, "ServerSocket initialized.");
        try {
            while (true) {
                Log.d(TAG, "new while loop:");
                // Accepting
                Socket clntSock = servSock.accept();
                SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
                Log.i(TAG, "Handling client at " + clientAddress);
                mCallbackListener.onClientAccepted(clientAddress.toString());
                try {
                    BufferedReader input = new BufferedReader(new InputStreamReader(clntSock.getInputStream()));
                    boolean flag = true;
                    int count = 1;
                    while (flag) {
                        String line = input.readLine();

                        if (line.equals("quit")) {
                            flag = false;
                            Log.i(TAG, "client quit!");
                            mCallbackListener.onClientQuit();
                        } else {
//                            Log.d(TAG, "msg[" + count++ + "] " + line);
                            mCallbackListener.onInfoReceived(line);
                        }
                    }
                } finally {
                    Log.d(TAG, "clntSock.close()");
                    clntSock.close();
                }
            }
        } finally {
            Log.d(TAG, "servSock.close()");
            servSock.close();
        }
    }

}

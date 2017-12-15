package ui.FlightPanel.Conn;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConnectionPanel extends JPanel {
    private static final long serialVersionUID = -1971522834860745333L;
    private final JLabel mConnStatus = new JLabel();

    public ConnectionPanel() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        mConnStatus.setText("Disconnected");
        add(mConnStatus);
    }

    public void setConnected(String client) {
        mConnStatus.setText("Connected to client: " + client);
    }

    public void setDisconnected() {
        mConnStatus.setText("Disconnected");
    }

}

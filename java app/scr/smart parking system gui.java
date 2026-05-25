import com.fazecast.jSerialComm.SerialPort;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.Scanner;
public class Main extends JFrame {
JLabel occupied = new JLabel("Occupied: 0");
JLabel available = new JLabel("Available: 10");
JLabel status = new JLabel("Status: READY");
JTextArea log = new JTextArea();
SerialPort port;
public Main() {
setTitle("Smart Parking (1 LED System)");
setSize(600, 450);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLayout(new BorderLayout());
JPanel top = new JPanel(new GridLayout(3,1));
Font f = new Font("Arial", Font.BOLD, 22);
occupied.setFont(f);
available.setFont(f);
status.setFont(f);
occupied.setHorizontalAlignment(SwingConstants.CENTER);
available.setHorizontalAlignment(SwingConstants.CENTER);
status.setHorizontalAlignment(SwingConstants.CENTER);
top.add(occupied);
top.add(available);
top.add(status);
add(top, BorderLayout.NORTH);
add(new JScrollPane(log), BorderLayout.CENTER);
JButton connect = new JButton("Connect Arduino");
connect.addActionListener(e -> connectArduino());
add(connect, BorderLayout.SOUTH);
}
void connectArduino() {
SerialPort[] ports = SerialPort.getCommPorts();
if (ports.length == 0) {
JOptionPane.showMessageDialog(this, "No Arduino found");
return;
}
port = ports[0];
port.setBaudRate(9600);
if (port.openPort()) {
JOptionPane.showMessageDialog(this, "Connected");
new Thread(this::readData).start();
}
}
void readData() {
Scanner sc = new Scanner(port.getInputStream());
while (sc.hasNextLine()) {
String line = sc.nextLine();
SwingUtilities.invokeLater(() -> handle(line));
}
}
void handle(String line) {
log.append(line + "\n");
if (line.startsWith("OCCUPIED:")) {
occupied.setText("Occupied: " + line.split(":")[1]);
}
else if (line.startsWith("AVAILABLE:")) {
available.setText("Available: " + line.split(":")[1]);
}
else if (line.startsWith("STATUS:")) {
status.setText("Status: " + line.split(":")[1]);
}
else if (line.startsWith("MOTION:DETECTED")) {
JOptionPane.showMessageDialog(this, "Motion Detected!");
}
}
public static void main(String[] args) {
SwingUtilities.invokeLater(() -> new Main().setVisible(true));
}
}

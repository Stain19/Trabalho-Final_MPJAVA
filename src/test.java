import javax.swing.*;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Scrollable JTextArea");
        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea(5, 20); // 5 rows and 20 columns
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
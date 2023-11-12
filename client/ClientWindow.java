package javadevkithw01.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class ClientWindow {
    private JFrame frame; // окно 
    private JTextArea chatTextArea; // отображение чата
    private JTextField messageTextField; // сообщение
    private JButton sendButton; // кнопка отправки

    private Client client;

    public ClientWindow() {
        frame = new JFrame("Chat Client"); //  окна "Chat Client"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие приложения
        frame.setSize(400, 300); // размеры
        frame.setLayout(new BorderLayout()); // компоновка BorderLayout

        chatTextArea = new JTextArea(); //   отображение чата
        chatTextArea.setEditable(false); // запрет редактирования
        JScrollPane scrollPane = new JScrollPane(chatTextArea); //  панель прокрутки
        frame.add(scrollPane, BorderLayout.CENTER); // в центр

        JPanel inputPanel = new JPanel(new BorderLayout()); // панель для ввода
        messageTextField = new JTextField(); // поле ввода
        inputPanel.add(messageTextField, BorderLayout.CENTER); // поле в центр
        sendButton = new JButton("Send"); // кнопка отправки
        inputPanel.add(sendButton, BorderLayout.EAST); // кнопка вправо
        frame.add(inputPanel, BorderLayout.SOUTH); // панель вниз

        frame.setVisible(true); // видимость
    }

    public void setClient(Client client) {
        this.client = client; 
    }

    public String getMessage() {
        return messageTextField.getText(); // получение текста 
    }

    public void clearMessageField() {
        messageTextField.setText(""); // очистка
    }

    public void addSendMessageListener(ActionListener listener) {
        sendButton.addActionListener(listener); // слушатель отправки
    }

    public void addEnterKeyListener(KeyListener listener) {
        messageTextField.addKeyListener(listener); // слушатель Enter
    }

    public void appendMessageToChat(String message) {
        chatTextArea.append(message + "\n"); // сообщение
        chatTextArea.setCaretPosition(chatTextArea.getDocument().getLength()); // прокрутка
}
}
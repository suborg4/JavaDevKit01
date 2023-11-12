package javadevkithw01.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Client {
    private ClientWindow clientWindow;
    private Server server;

    public Client(ClientWindow clientWindow) {
        this.clientWindow = clientWindow;
        this.clientWindow.addSendMessageListener(new SendMessageListener());
        this.clientWindow.addEnterKeyListener(new EnterKeyListener());
        server = new Server();
        loadChatHistoryFromFile();
    }

private void loadChatHistoryFromFile() {
    try {
        // путь к файлу chat_history.txt в resources
        String filePath = getClass().getResource("/chat_history.txt").getPath();

        //  FileInputStream для чтения 
        FileInputStream fis = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        String line;
        while ((line = reader.readLine()) != null) {
            // Добавляем  историю чата в окно
            clientWindow.addMessageToChat(line);
        }

        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private class SendMessageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = clientWindow.getMessage();
            server.addMessageToHistory(message);
            // отправка сообщения на сервер 
            clientWindow.clearMessageField();
        }
    }

    private class EnterKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String message = clientWindow.getMessage();
                server.addMessageToHistory(message);
                // отправка сообщения на сервер
                clientWindow.clearMessageField();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }
}
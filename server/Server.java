package javadevkithw01.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<String> chatHistory; // список истории

    public Server() {
        chatHistory = new ArrayList<>(); // инициализация списка
        loadChatHistoryFromFile(); // загрузка истории чата из файла
    }

    public void addMessageToHistory(String message) {
        chatHistory.add(message); // добавление в историю чата
        saveChatHistoryToFile(); // сохранение чата в файл
    }

    private void saveChatHistoryToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("chat_history.txt"))) {
            for (String message : chatHistory) {
                writer.write(message); // запись в файл
                writer.newLine(); // добавление строки
            }
        } catch (IOException e) {
            e.printStackTrace(); // обработка исключения ввода-вывода
        }
    }

    private void loadChatHistoryFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("chat_history.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                chatHistory.add(line); // добавление строки из файла в историю чата
            }
        } catch (IOException e) {
            e.printStackTrace(); // обработка исключения ввода-вывода
        }
    }
}
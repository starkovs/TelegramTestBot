
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Андрей
 */
public class Bot extends TelegramLongPollingBot{

    @Override
    public String getBotToken() {
        return "1248209264:AAEFthUkXg2Eg3wVOrq21giM7k3MzZGxgbY";
    }

    @Override
    public void onUpdateReceived(Update update) {
	String message = update.getMessage().getText();
	sendMsg(update.getMessage().getChatId().toString(), message);    }

    @Override
    public String getBotUsername() {
        return "TheBestInTheWorldWeatherBot";
    }
    
       public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    
}

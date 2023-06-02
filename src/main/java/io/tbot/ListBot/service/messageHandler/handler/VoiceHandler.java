package io.tbot.ListBot.service.messageHandler.handler;

import io.tbot.ListBot.processing.CorrectionOfErrorsInTheText;
import io.tbot.ListBot.processing.CreateList;
import io.tbot.ListBot.service.UserService;
import io.tbot.ListBot.service.audioProcessing.VoiceDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
@Component
public class VoiceHandler implements MessageHandler {

    private final VoiceDecoder voiceDecoder;
    private final UserService userService;


    @Override
    public SendMessage send(Update update) {
        return sendVoiceMessage(update.getMessage().getChatId());
    }

    private SendMessage sendVoiceMessage(long chatId) {
        SendMessage message = new SendMessage();
        String textToSend = voiceDecoder.speechToText();
        String result = "";
        if(userService.getCommandOfRecognized(chatId).equals("LIST")){
            CreateList createList = new CreateList();
            result = createList.processText(textToSend);
        }else if(userService.getCommandOfRecognized(chatId).equals("CORRECT")){
            CorrectionOfErrorsInTheText correction = new CorrectionOfErrorsInTheText();
            result = correction.processText(textToSend);
        }
        message.setChatId(chatId);
        message.setText(result);
        return message;
    }

}

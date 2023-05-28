package io.tbot.ListBot.command;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

public interface BotCommands {
    String START_COMMAND = "/start";
    String SETTING_COMMAND = "/settings";
    String HELP_COMMAND = "/help";
    List<BotCommand> LIST_OF_COMMANDS = List.of(
            new BotCommand(START_COMMAND, "Запустить бота"),
            new BotCommand(SETTING_COMMAND, "Изменить настройки"),
            new BotCommand(HELP_COMMAND, "Информация о боте"));
    String HELP_TEXT = "Я создан, чтобы разгрузить ваши ручки и уменьшить затраты времени, на создание списков и текста\n\n" +
            "<b>Список команд бота:</b>\n" +
            "\n" +
            "/start - перезапустить бота\n" +
            "/help - список всех доступных команд\n" +
            "/settings - выбор параметра распознавания";
}

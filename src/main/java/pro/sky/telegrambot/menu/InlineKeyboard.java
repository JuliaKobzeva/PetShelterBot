package pro.sky.telegrambot.menu;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

import static pro.sky.telegrambot.enums.CallbackDataEnum.*;

public class InlineKeyboard {
    private final TelegramBot telegramBot;

    public InlineKeyboard(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    //приветственное сообщение и выбор приюта
    public void showShelterType(Long chatId) {
        String text = "Привет," +
                " Вас приветствует помощник приложения Help-Pets," +
                " пожалуйста выберите приют о котором вы хотите получить информацию";
        InlineKeyboardButton firstButton = new InlineKeyboardButton("Приют для собак");
        firstButton.callbackData(buttonDog);
        InlineKeyboardButton secondButton = new InlineKeyboardButton("Приют для кошек");
        secondButton.callbackData(buttonCat);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(firstButton, secondButton);
        SendMessage sendMessage = new SendMessage(chatId, text).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

    //метод показывает стартовое меню приюта СОБАК
    public void showStartMenu(Long chatId) {
        String text = "На связи приют для собак." +
                " Пожалуйста выберите пункт из представленного меню ";
        InlineKeyboardButton firstButton = new InlineKeyboardButton("Узнать информацию о приюте");
        firstButton.callbackData(buttonMainMenu1);
        InlineKeyboardButton secondButton = new InlineKeyboardButton("Как взять собаку из приюта");
        secondButton.callbackData(buttonMainMenu2);
        InlineKeyboardButton thirdButton = new InlineKeyboardButton("Прислать отчет о питомце");
        thirdButton.callbackData(buttonMainMenu3);
        InlineKeyboardButton fourthButton = new InlineKeyboardButton("Позвать волонтера");
        fourthButton.callbackData(buttonCallVolunteer);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(firstButton, secondButton);
        inlineKeyboardMarkup.addRow(thirdButton, fourthButton);
        SendMessage sendMessage = new SendMessage(chatId, text).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

    //метод показывает стартовое меню приюта КОШЕК
    public void showStartMenuCats(Long chatId) {
        String text = "На связи приют для кошек." +
                " Пожалуйста выберите пункт из представленного меню ";
        InlineKeyboardButton firstButton = new InlineKeyboardButton("Узнать информацию о приюте");
        firstButton.callbackData(buttonMainMenuCat1);
        InlineKeyboardButton secondButton = new InlineKeyboardButton("Как взять кошку из приюта");
        secondButton.callbackData(buttonMainMenuCat2);
        InlineKeyboardButton thirdButton = new InlineKeyboardButton("Прислать отчет о питомце");
        thirdButton.callbackData(buttonMainMenu3);
        InlineKeyboardButton fourthButton = new InlineKeyboardButton("Позвать волонтера");
        fourthButton.callbackData(buttonCallVolunteer);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(firstButton, secondButton);
        inlineKeyboardMarkup.addRow(thirdButton, fourthButton);
        SendMessage sendMessage = new SendMessage(chatId, text).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);

    }

    /*метод показывает меню информации о приюте СОБАК*/
    public void showInfoShelterMenu(Long chatId) {
        String text = " Вы зашли в раздел  информации о приюте собак," +
                " пожалуйста выберите пункт из представленного меню ";
        InlineKeyboardButton firstButton = new InlineKeyboardButton("Подробная информация о приюте");
        firstButton.callbackData(buttonShelter1);
        InlineKeyboardButton secondButton = new InlineKeyboardButton("Контактая информация");
        secondButton.callbackData(buttonShelter2);
        InlineKeyboardButton thirdButton = new InlineKeyboardButton("Рекомендации" +
                " о технике безопасности на территории приюта");
        thirdButton.callbackData(buttonShelter3);
        InlineKeyboardButton fourthButton = new InlineKeyboardButton("Записать " +
                "контактные данные для связи");
        fourthButton.callbackData(buttonSaveContactDetails);
        InlineKeyboardButton fifthButton = new InlineKeyboardButton("Позвать волонтера");
        fifthButton.callbackData(buttonCallVolunteer);
        InlineKeyboardButton sixthButton = new InlineKeyboardButton("Вернуться на главное меню");
        sixthButton.callbackData(buttonMainMenu);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(firstButton, secondButton);
        inlineKeyboardMarkup.addRow(thirdButton, fourthButton);
        inlineKeyboardMarkup.addRow(fifthButton, sixthButton);
        SendMessage sendMessage = new SendMessage(chatId, text).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

    // метод показывает меню информации о приюте КОШЕК
    public void showInfoShelterCatMenu(Long chatId) {
        String text = " Вы зашли в раздел  информации о приюте кошек," +
                " пожалуйста выберите пункт из представленного меню ";
        InlineKeyboardButton firstButton = new InlineKeyboardButton("Подробная информация о приюте");
        firstButton.callbackData(buttonShelterCat1);
        InlineKeyboardButton secondButton = new InlineKeyboardButton("Контактая информация");
        secondButton.callbackData(buttonShelterCat2);
        InlineKeyboardButton thirdButton = new InlineKeyboardButton("Рекомендации" +
                " о технике безопасности на территории приюта");
        thirdButton.callbackData(buttonShelter3);
        InlineKeyboardButton fourthButton = new InlineKeyboardButton("Записать " +
                "контактные данные для связи");
        fourthButton.callbackData(buttonSaveContactDetails);
        InlineKeyboardButton fifthButton = new InlineKeyboardButton("Позвать волонтера");
        fifthButton.callbackData(buttonCallVolunteer);
        InlineKeyboardButton sixthButton = new InlineKeyboardButton("Вернуться на главное меню");
        sixthButton.callbackData(buttonMainMenu);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(firstButton, secondButton);
        inlineKeyboardMarkup.addRow(thirdButton, fourthButton);
        inlineKeyboardMarkup.addRow(fifthButton, sixthButton);
        SendMessage sendMessage = new SendMessage(chatId, text).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

    /*метод показывает меню бюрократических вопросов по приюту собак*/
    public void showBureaucraticMenu(Long chatId) {
        String text = " Вы зашли в раздел бюрократической информации," +
                " и бытовых вопросов. Данный раздел поможет Вам получить полную информацию" +
                " о том, как предстоит подготовиться человеку ко встрече с новым членом семьи.";
        InlineKeyboardButton firstButton = new InlineKeyboardButton("Правила знакомства с собакой");
        firstButton.callbackData(buttonBureaucraticMenu1);
        InlineKeyboardButton secondButton = new InlineKeyboardButton("Список документов, чтобы взять собаку");
        secondButton.callbackData(buttonBureaucraticMenu2);
        InlineKeyboardButton thirdButton = new InlineKeyboardButton("Рекомендации по транспортировке");
        thirdButton.callbackData(buttonBureaucraticMenu3);
        InlineKeyboardButton fourthButton = new InlineKeyboardButton("Рекомендации по обустройству дома" +
                " для щенка");
        fourthButton.callbackData(buttonBureaucraticMenu3);
        InlineKeyboardButton fifthButton = new InlineKeyboardButton("Рекомендации по обустройству дома" +
                " для взрослой собаки");
        fifthButton.callbackData(buttonBureaucraticMenu5);
        InlineKeyboardButton sixthButton = new InlineKeyboardButton("Рекомендации по обустройству дома" +
                " для собаки с ограниченными возможностями");
        sixthButton.callbackData(buttonBureaucraticMenu6);
        InlineKeyboardButton seventhButton = new InlineKeyboardButton("Советы кинолога по первичному " +
                "общению с собакой");
        seventhButton.callbackData(buttonBureaucraticMenu7);
        InlineKeyboardButton eightButton = new InlineKeyboardButton("Рекомендации по проверенным кинологам " +
                "для дальнейшего обращения к ним");
        eightButton.callbackData(buttonBureaucraticMenu8);
        InlineKeyboardButton ninthButton = new InlineKeyboardButton("Причины согласно которым могут " +
                "отказать забрать собаку из приюта");
        ninthButton.callbackData(buttonBureaucraticMenu9);
        InlineKeyboardButton tenthButton = new InlineKeyboardButton("Записать " +
                "контактные данные для связи");
        tenthButton.callbackData(buttonSaveContactDetails);
        InlineKeyboardButton eleventhButton = new InlineKeyboardButton("Позвать волонтера");
        eleventhButton.callbackData(buttonCallVolunteer);
        InlineKeyboardButton twelfthButton = new InlineKeyboardButton("Вернуться на главное меню");
        twelfthButton.callbackData(buttonMainMenu);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(firstButton, secondButton);
        inlineKeyboardMarkup.addRow(thirdButton, fourthButton);
        inlineKeyboardMarkup.addRow(fifthButton, sixthButton);
        inlineKeyboardMarkup.addRow(seventhButton, eightButton);
        inlineKeyboardMarkup.addRow(ninthButton, tenthButton);
        inlineKeyboardMarkup.addRow(eleventhButton, twelfthButton);
        SendMessage sendMessage = new SendMessage(chatId, text).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

    /*метод показывает меню бюрократических вопросов по приюту кошек*/
    public void showBureaucraticMenuCat(Long chatId) {
        String text = " Вы зашли в раздел бюрократической информации," +
                " и бытовых вопросов. Данный раздел поможет Вам получить полную информацию" +
                " о том, как предстоит подготовиться человеку ко встрече с новым членом семьи.";
        InlineKeyboardButton firstButton = new InlineKeyboardButton("Правила знакомства с котом");
        firstButton.callbackData(buttonBureaucraticMenuCat1);
        InlineKeyboardButton secondButton = new InlineKeyboardButton("Список документов, чтобы взять кота");
        secondButton.callbackData(buttonBureaucraticMenu2);
        InlineKeyboardButton thirdButton = new InlineKeyboardButton("Рекомендации по транспортировке");
        thirdButton.callbackData(buttonBureaucraticMenuCat3);
        InlineKeyboardButton fourthButton = new InlineKeyboardButton("Рекомендации по обустройству дома" +
                " для котенка");
        fourthButton.callbackData(buttonBureaucraticMenuCat4);
        InlineKeyboardButton fifthButton = new InlineKeyboardButton("Рекомендации по обустройству дома" +
                " для взрослой кошки");
        fifthButton.callbackData(buttonBureaucraticMenuCat5);
        InlineKeyboardButton sixthButton = new InlineKeyboardButton("Рекомендации по обустройству дома" +
                " для кота с ограниченными возможностями");
        sixthButton.callbackData(buttonBureaucraticMenuCat6);
        InlineKeyboardButton seventhButton = new InlineKeyboardButton("Причины согласно которым могут " +
                "отказать забрать животное из приюта");
        seventhButton.callbackData(buttonBureaucraticMenu9);
        InlineKeyboardButton eightButton = new InlineKeyboardButton("Записать контактные данные для связи");
        eightButton.callbackData(buttonSaveContactDetails);
        InlineKeyboardButton ninthButton = new InlineKeyboardButton("Позвать волонтера");
        ninthButton.callbackData(buttonCallVolunteer);
        InlineKeyboardButton tenthButton = new InlineKeyboardButton("Вернуться на главное меню");
        tenthButton.callbackData(buttonMainMenu);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(firstButton, secondButton);
        inlineKeyboardMarkup.addRow(thirdButton, fourthButton);
        inlineKeyboardMarkup.addRow(fifthButton, sixthButton);
        inlineKeyboardMarkup.addRow(seventhButton, eightButton);
        inlineKeyboardMarkup.addRow(ninthButton, tenthButton);
        SendMessage sendMessage = new SendMessage(chatId, text).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

    /*метод показывает меню для отправки отчетов*/
    public void showReportMenu(Long chatId) {
        String text = " Вы зашли в раздел предоставления отчетов. ";
        InlineKeyboardButton firstButton = new InlineKeyboardButton("Прислать форму ежедневного отчета");
        firstButton.callbackData(buttonReportMenu1);
        InlineKeyboardButton secondButton = new InlineKeyboardButton("Отправить отчет");
        secondButton.callbackData(buttonReportMenu2);
        InlineKeyboardButton thirdButton = new InlineKeyboardButton("Вернуться на главное меню");
        thirdButton.callbackData(buttonMainMenu);
        InlineKeyboardButton fourthButton = new InlineKeyboardButton("Позвать волонтера");
        fourthButton.callbackData(buttonCallVolunteer);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(firstButton, secondButton);
        inlineKeyboardMarkup.addRow(thirdButton, fourthButton);
        SendMessage sendMessage = new SendMessage(chatId, text).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }

    /*данные метод необходим для имитации работы волонтера, после того как пользователь отправляет
     команду /saveDogOwner, из message берется его chatId, name, и пользователь записывается в бд
     как owner*/
    public void showVolunteerMenu(Long chatId) {
        String text = "Добрый день, меня зовут волонтер Гриша. Я могу помочь вам со следующими функциями." +
                "\n1.Если вы хотите отправить отчет о пребывании животного на новом месте, для этого мне" +
                " сначала необходимо вас зарегистрировать, пожалуйста " +
                " напишите в чат команду: \n/saveOwner";
        InlineKeyboardButton firstButton = new InlineKeyboardButton("Вернуться на главное меню");
        firstButton.callbackData(buttonMainMenu);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(firstButton);
        SendMessage sendMessage = new SendMessage(chatId, text).replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
    }
}
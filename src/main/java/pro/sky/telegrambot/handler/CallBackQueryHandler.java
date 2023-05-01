package pro.sky.telegrambot.handler;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import pro.sky.telegrambot.menu.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static pro.sky.telegrambot.enums.CallbackDataEnum.*;

/**
 * "Перехватчик" updates типа CallBackQuery
 */

public class CallBackQueryHandler implements Handler {
    private final TelegramBot telegramBot;

    public CallBackQueryHandler(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @Override
    public void handle(Update update) {
        Long chatId = update.callbackQuery().message().chat().id();
        CallbackQuery callbackQuery = update.callbackQuery();
        String data = callbackQuery.data();
        InlineKeyboard infoKeyboard = new InlineKeyboard(telegramBot);
        switch (data) {
            case buttonDog: {
                infoKeyboard.showStartMenu(chatId);
                break;
            }
            case buttonCat: {
                infoKeyboard.showStartMenuCats(chatId);
                break;
            }
            case buttonMainMenu1: {
                infoKeyboard.showInfoShelterMenu(chatId);
                break;
            }
            case buttonMainMenu2: {
                infoKeyboard.showBureaucraticMenu(chatId);
                break;
            }
            case buttonMainMenu3: {
                infoKeyboard.showReportMenu(chatId);
                break;
            }
            case buttonCallVolunteer: {
                infoKeyboard.showVolunteerMenu(chatId);
                break;
            }
            case buttonMainMenuCat1: {
                infoKeyboard.showInfoShelterCatMenu(chatId);
                break;
            }
            case buttonMainMenuCat2: {
                infoKeyboard.showBureaucraticMenuCat(chatId);
                break;
            }
            case buttonShelter1: {
                showInfoAboutShelter(chatId);
                break;
            }
            case buttonShelter2: {
                showContactInfoAboutShelter(chatId);
                break;
            }
            case buttonShelter3: {
                showSafetyAdvice(chatId);
                break;
            }
            case buttonSaveContactDetails: {
                saveContactDetails(chatId);
                break;
            }
            case buttonMainMenu: {
                infoKeyboard.showShelterType(chatId);
                break;
            }
            case buttonShelterCat1: {
                showInfoAboutShelterCat(chatId);
                break;
            }
            case buttonShelterCat2: {
                showContactInfoAboutShelterCat(chatId);
                break;
            }
            case buttonBureaucraticMenu1: {
                showDogDatingRules(chatId);
                break;
            }
            case buttonBureaucraticMenu2: {
                showListOfDocuments(chatId);
                break;
            }
            case buttonBureaucraticMenu3: {
                showTransportationAdvices(chatId);
                break;
            }
            case buttonBureaucraticMenu5: {
                showHomeImprovementTipsForDog(chatId);
                break;
            }
            case buttonBureaucraticMenu6: {
                showHomeImprovementTipsForDogWithDisability(chatId);
                break;
            }
            case buttonBureaucraticMenu7: {
                showDogHandlerAdvices(chatId);
                break;
            }
            case buttonBureaucraticMenu8: {
                showContactsOfDogHandlers(chatId);
                break;
            }
            case buttonBureaucraticMenu9: {
                showReasonsForRefusingToAdoptDog(chatId);
                break;
            }
            case  buttonBureaucraticMenuCat1: {
                showCatDatingRules(chatId);
                break;
            }
            case buttonBureaucraticMenuCat3: {
                showTransportationAdvicesCat(chatId);
                break;
            }
            case buttonBureaucraticMenuCat4: {
                showHomeImprovementTipsForSmallCat(chatId);
                break;
            }
            case buttonBureaucraticMenuCat5: {
                showHomeImprovementTipsForCat(chatId);
                break;
            }
            case buttonBureaucraticMenuCat6: {
                showHomeImprovementTipsForCatWithDisability(chatId);
                break;
            }
            case buttonReportMenu1: {
                showDailyReportForm(chatId);
                break;
            }
            case buttonReportMenu2: {
                showSendReport(chatId);
                break;
            }
        }
    }

    private void sendTextMessage(Long chatId, String text) {
        SendMessage sendMessage = new SendMessage(chatId, text);
        telegramBot.execute(sendMessage);
    }

    //вызов кнопку - показать информацию о приюте собак
    private void showInfoAboutShelter(Long chatId) {
        sendTextMessage(chatId, "Приют Help-Pets это место содержания бездомных, потерянных, брошенных и больных" +
                " животных. Тут находятся питомцы, от которых отказались хозяева, найденные на улице раненые собаки. Основаные функции приюта это:" +
                "\n- принимать животных от владельцев или найденных на улице;" +
                "\n- создать хорошие условия для проживания;" +
                "\n- проводить работу по поиску новых хозяев;" +
                "\n- временно принять животных, сданных владельцами;" +
                "\n- приютить больных или травмированных собак.");
    }

    //вызов кнопку - показать информацию о приюте кошек
    private void showInfoAboutShelterCat(Long chatId) {
        sendTextMessage(chatId, "Приют Help-Cats это место содержания бездомных, потерянных, брошенных и больных" +
                " животных. Тут находятся питомцы, от которых отказались хозяева, найденные на улице раненые кошки. Основаные функции приюта это:" +
                "\n- принимать животных от владельцев или найденных на улице;" +
                "\n- создать хорошие условия для проживания;" +
                "\n- проводить работу по поиску новых хозяев;" +
                "\n- временно принять животных, сданных владельцами;" +
                "\n- приютить больных или травмированных кошек.");
    }

    /*по запросу пользователя метод вытаскивает картинку из папки resources и отправляет пользователю*/
    private void showContactInfoAboutShelter(Long chatId) {
        try {
            byte[] drivingDirection = Files.readAllBytes(
                    Paths.get(CallBackQueryHandler.class.getResource("/drivingDirection.jpg").toURI()));
            SendPhoto sendPhoto = new SendPhoto(chatId, drivingDirection);
            sendTextMessage(chatId, "Часы работы приюта Help Pets с 9:00 до 19:00 без выходных," +
                    " приют расположен по адресу: Зубовский бульвар д.17 с.3");
            telegramBot.execute(sendPhoto);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    /*контактные данные приюта кошек*/
    private void showContactInfoAboutShelterCat(Long chatId) {
        sendTextMessage(chatId, "Часы работы приюта Help Cats с 9:00 до 19:00 без выходных," +
                " приют расположен по адресу: Московский проезд д.5");
    }

    //Вызов кнопки о правилах безопасности на территории приюта
    private void showSafetyAdvice(Long chatId) {
        sendTextMessage(chatId, "На территории Приюта для всех посетителей действуют правила и распорядок," +
                " установленные администрацией Приюта: " +
                "\nпроведение фото и видео фиксации без предварительного письменного согласования;" +
                "\nкормить животных кормами и продуктами, как на территории приюта;" +
                "\nпосещать блок карантина и изолятор;" +
                "\nбез необходимости находиться вблизи вольеров;" +
                "\nдавать животным самостоятельно какие-либо ветеринарные или медицинские препараты;" +
                "\nвыгуливать животных без поводка.");
    }

    // Вызов кнопки "Правила знакомства с собакой"
    private void showDogDatingRules(Long chatId) {
        sendTextMessage(chatId, "При первом контакте с собакой:\n" +
                "- Подождите проявление инициативы от самой собаки.\n" +
                "- Не подходите к собаке в лоб, она может расценить это как проявление плохих намерений.\n" +
                "- Не смотрите собаке в глаза, ею это расценивается как угроза, вы еще не знакомы.\n" +
                "- Позвольте себя обнюхать, собаки больше полагаются на них, чем на зрение.\n" +
                "- Если собака захочет уйти – пусть уходит. Дайте возможность животному самому принимать решение," +
                " желает ли оно дальнейшего общения.\n" +
                "- Если вы заметили, что собака провела с вами достаточно продолжительное время и готова продолжить " +
                "общение, то можете предложить ей поглаживание.");
    }

    // Вызов кнопки "Правила знакомства с котом"
    private void showCatDatingRules(Long chatId) {
        sendTextMessage(chatId, "Если вы выбрали кошку, не забирайте её в первый же день. " +
                "Сначала спросите у сотрудников о привычках и предпочтениях животного.\n" +
                "\n" +
                "Запаситесь тем же кормом, которым кормят в приюте. Пусть он не того качества, " +
                "который бы хотелось, но если перевести кота сразу на другой корм по приезду в ваш дом, " +
                "то это спровоцирует у него стресс.\n" +
                "В первый день вы можете угостить кота лакомством и поговорить с ним.\n" +
                "Во второй день, когда дома будет готово кошачье приданое, нужно снова подойти к " +
                "клетке с кошкой. Понаблюдайте для интереса, приблизится ли кошка к вам.");
    }


    // Вызов кнопки "Правила первозки собаки"
    private void showTransportationAdvices(Long chatId) {
        sendTextMessage(chatId, "\"1. Согласно пункту 23.3 ПДД РФ, собака или другой крупный питомец " +
                " приравнивается к грузу. Перед началом поездки водителю необходимо разместить и закрепить животное." +
                " Питомец не должен загораживать обзор водителю и препятствовать управлению транспортным средством.\n" +
                " 2. Советы по перевозке. Первые поездки совершайте на короткие расстояния." +
                " Дайте собаке привыкнуть к машине. Обязательно приучите животное забираться и вылезать" +
                " только по командене перемещаться по автомобилю. Перед поездками не кормите животное, " +
                " неподготовленного питомца может укачать. Если вы планируете перевозить четвероногого друга в" +
                " переноске (мелкие и средние породы), дайте ему привыкнуть к ней. Поставьте сумку дома, можно " +
                " постелить внутрь любимый плед или положить несколько игрушек, чтобы питомец  не воспринимал " +
                " переноску как что-то опасное. \n3. С правилами перевозки железнодорожным и воздушным транспором " +
                " вы можете ознакомиться на сайтах +соответствующих компаний, услугами которых вы планируете " +
                " воспользоваться.");
    }

    // Вызов кнопки "Правила перевозки кота"
    private void showTransportationAdvicesCat(Long chatId) {
        sendTextMessage(chatId, " Когда забираете котенка из приюта или с передержки, " +
                "помните о том, что это очередной сильный стресс для животного. " +
                "Сначала пообщайтесь со своим новым любимцем, дождитесь, пока он успокоится и " +
                "только потом аккуратно поместите его в переноску.");
    }

    // Вызов кнопки "Список документов для <<усыновления>>"
    public void showListOfDocuments(Long chatId) {
        sendTextMessage(chatId, " String docs = \"Для усыновления вам понадобится:\n" +
                "- Паспорт, или другой документ удостоверяющий личность.\n" +
                "- Также необходимо внести пожертвование (на содержание остальных животных центра. " +
                "Сумма пожертвования зависит от разных факторов (времени пребывания питомца в центре," +
                " затрат на ее лечение и т.п.)");
    }

    // Вызов кнопки "Обустройство дома для собаки"
    public void showHomeImprovementTipsForDog(Long chatId) {
        sendTextMessage(chatId, "У каждой собаки в доме должен быть свой уголок." +
                " Для этого необходимо установить в выбранном месте квартиры лежанку, постелить подстилку " +
                " или матрас. Личную зону питомца лучше расположить подальше от радиаторов, бытовой техники," +
                " окон, входных дверей и выхода на балкон. Спальное место должно соответствовать размерам собаки." +
                " Длина спального места должна примерно на 15 сантиметров превышать длину питомца, а ширина — быть " +
                " в два раза больше его высоты. Выбирая форму спального места, следует учитывать особенности " +
                " характера собаки и ее любимую позу для сна. Если у вас щенок, то на первое время можно купить" +
                " или обустроить спальное место меньших размеров, чтобы потом сменить его на «взрослую» кровать." +
                " Посуда. У питомца обязательно должна быть своя посуда для еды и воды. Обеденную зону лучше " +
                " организовать подальше от спального места, обычно для этого выделяют уголок на кухне." +
                " Размеры миски должны соответствовать аппетиту вашего любимца. Лучше выбрать посуду на штативе," +
                " что позволит регулировать высоту. Аксессуары. Для прогулок вам необходимо преобрести поводки или " +
                " ошейники,щенкам и маленьким собачкам подойдут шлейки, одевающиеся на туловище животного. Собакам" +
                " бойцовских пород можно приобрести строгие ошейники. Для путешествий, пригодится переноска. Щенкам" +
                " или маленьким собачкам будет комфортно в специальной сумке или рюкзаке. Для большого животного " +
                " понадобится специальный пластиковый разборный контейнер. Игушки. Собакам очень важно что-то грызть" +
                " так они массируют десна и очищают зубы от налета, делая их крепче и здоровее. Также позаботьтесь " +
                " об одежде для своих питомцев.");
    }
    // Вызов кнопки "Обустройство дома для кота"
    public void showHomeImprovementTipsForCat(Long chatId) {
        sendTextMessage(chatId, "Чтобы избежать непредвиденных неприятностей, следует обеспечить новому " +
                "жителю вашего дома максимально безопасные условия.\n" +
                "1. Подготовка жилья. Коту нужен специальный домик или игровой комплекс, миски для " +
                "еды и воды, игрушки, лоток.\n" +
                "2. Сетки на окнах. Важнейший элемент обустройства помещения, в котором будет проживать " +
                "пушистик. Обычные антимоскитные сетки не выдерживают повисшего на них кота и его когтей. " +
                "Существуют специальные сетки «антикошка», которые уберегут животное от падения или " +
                "застревания между окном и рамой (что может привести к гибели животного).");
    }

    // Вызов кнопки "Обустройство дома для  котенка"
    public void showHomeImprovementTipsForSmallCat(Long chatId) {
        sendTextMessage(chatId, "Во-первых, пройдите по всем комнатам и выявите потенциально " +
                "опасные места для кошек. Это могут быть окна без москитных сеток, " +
                "разбросанные на полу провода, в которых кошка может просто запутаться и т.д.\n" +
                "Во-вторых, приобретите в зоомагазине:\n" +
                "переноску (она вам пригодится не только при переезде кошки из приюта домой, " +
                "но и при транспортировке к ветеринару на очередной осмотр и вакцинацию);\n" +
                "две миски (для корма и для воды);\n" +
                "корм (при выборе готовых кормов остерегайтесь подделок, а если вы решили кормить " +
                "питомца «натуралкой», заранее составьте меню, приобретите крупы, субпродукты, овощи);\n" +
                "лоток и наполнитель (при их выборе лотка учитывайте размер и возраст животного);\n" +
                "когтеточку.\n" +
                "Не спешите покупать игровые комплексы, домики и прочие дорогостоящие атрибуты. " +
                "Они нужны и полезны, ваш питомец за них только спасибо скажет, но это, возможно, " +
                "будет нескоро. Кроме того, далеко не все кошки любят спать в домиках, а потому " +
                "первое время можно обойтись недорогой лежанкой или же вовсе сшить ее самостоятельно.");
    }

    // Вызов кнопки "Обустройство дома для собаки-инвалида"
    public void showHomeImprovementTipsForDogWithDisability(Long chatId) {
        sendTextMessage(chatId, "Общие рекомендации по обустройству жилья описаны в пункте <<Обустройство дома " +
                " для собак>>.Более конкретные рекомендации связанные с спецификой заболевания животного вам будут " +
                " даны от кинолога и ветеринара в момент процедуры <<усыновления>> питомца.");
    }

    // Вызов кнопки "Обустройство дома для кота-инвалида"
    public void showHomeImprovementTipsForCatWithDisability(Long chatId) {
        sendTextMessage(chatId, "Общие рекомендации по обустройству жилья описаны в пункте <<Обустройство дома " +
                " для кошек>>.Более конкретные рекомендации связанные с спецификой заболевания животного вам будут " +
                " даны от ветеринара и зоопсихолога в момент процедуры <<усыновления>> питомца.");
    }

    // Вызов кнопки "Советы кинолога"
    public void showDogHandlerAdvices(Long chatId) {
        sendTextMessage(chatId, "Кинологи советуют с первых дней знакомства питомца с его новым домом правильно " +
                " выстраить границы между вами. Основные правила общения:\nНеобходимо дать питомцу время освоиться" +
                " —питомец должен обойти дом, обнюхать новое место.Семья должна давать собаке безопасность, " +
                " любовь и позитив. Язык собаки — это телодвижение, мимика, голос. Собаки очень хорошо обучаются," +
                " глядя на нашу реакцию. Счастье одобряет и закрепляет поведение собаки, а равнодушие на какое-либо" +
                " действие сигнализирует о том, что так делать не стоит. Встречи и прощание:\nВстречи — один из самых" +
                " радостных и приятных моментов для собаки. как она будет проходить решаете только вы." +
                " Расставание - питомец должен понимать, что хозяин уходит на небольшой промежуток времени, " +
                " возвращается домой — и всё хорошо. Научилитесь правильно расставаться с животным." +
                " Наказание и примирение: Для экологичных отношений необязательно кричать или приказывать собаке." +
                " Важно гуманным способом запрещать питомцу те или иные действия — только в этом случае " +
                "поведение закрепится.");
    }

    // Вызов кнопки "Контакты кинологов"
    public void showContactsOfDogHandlers(Long chatId) {
        sendTextMessage(chatId, "За помощью в постороении связи с вашим новоиспеченным питомцем вы можете" +
                " обратиться к нашим кинологам: \n+79326762123 Весенников Алексей \n+79358945472 Старкина Алена");
    }

    //Вызов кнопки "Причина отказа в <<усыновлении>> собаки/кота"
    public void showReasonsForRefusingToAdoptDog(Long chatId) {
        sendTextMessage(chatId, "Взять питомца из приюта не так уж легко." +
                " Работники и волонтеры стараются сделать все, чтобы собаки не оказались на улице повторно," +
                " поэтому отдают животных только в надежные руки. Существует пять причин, по которым чаще всего" +
                " отказывают желающим «усыновить» домашнего любимца." +
                "\n1. Большое количество животных дома" +
                "\n2. Нестабильные отношения в семье" +
                "\n3. Наличие маленьких детей" +
                "\n4. Съемное жилье" +
                "\n5. Животное в подарок или для работы");
    }

    //Метод показывает пользователю форму ежедневного отчета
    public void showDailyReportForm(Long chatId) {
        sendTextMessage(chatId, "В ежедневный отчет входит следующая информация:" +
                "\n- Фото животного." +
                "\n- Рацион животного" +
                "\n- Общее самочувствие и привыкание к новому месту.n" +
                "\n- Изменение в поведении: отказ от старых привычек, приобретение новых.");
    }

    public void showSendReport(Long chatId) {
        sendTextMessage(chatId, "Отправьте отчет о вашем питомце согласно форме..");
    }

    /* метод зовет волонтора, в константе записан chatId волонтера, когда пользователь нажимает на кнопку
  позвать волонтера бот высылает волонтеру уведомление чтобы он связался с пользователем*/
    public void callVolunteer(Long chatId) {
        Long VOLUNTEER_CHAT_ID = 512213990L;
        sendTextMessage(VOLUNTEER_CHAT_ID, "Пользователь id: " + chatId +
                " просит связи с волантером, пожалуйста свяжитесь с ним");
    }

    /*Метод показывает шаблон, по которому пользователи могут оставить свои контактные данные*/
    private void saveContactDetails(Long chatId) {
        sendTextMessage(chatId, "Привет, отправь номер телефона и имя " +
                "в формате 71112223344 Михаил");
    }
}
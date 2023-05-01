package pro.sky.telegrambot.handler;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.PhotoSize;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import pro.sky.telegrambot.entity.Owner;
import pro.sky.telegrambot.entity.OwnerCat;
import pro.sky.telegrambot.entity.Report;
import pro.sky.telegrambot.entity.ReportCat;
import pro.sky.telegrambot.service.OwnerCatService;
import pro.sky.telegrambot.service.OwnerService;
import pro.sky.telegrambot.service.ReportCatService;
import pro.sky.telegrambot.service.ReportService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

/**
 * "Перехватчик" updates типа Image
 * Сохраняет фото в БД
 */
public class ImageHandlerCat implements Handler {

    private final TelegramBot telegramBot;

    private final OwnerCatService ownerCatService;

    private final ReportCatService reportCatService;

    public ImageHandlerCat(TelegramBot telegramBot, OwnerCatService ownerCatService, ReportCatService reportCatService) {
        this.telegramBot = telegramBot;
        this.ownerCatService = ownerCatService;
        this.reportCatService = reportCatService;
    }

    @Override
    public void handle(Update update) throws IOException {
        Long chatId = update.message().chat().id();
        OwnerCat ownerCat = ownerCatService.findOwnerCatByChatId(chatId);
        List<PhotoSize> photos = List.of(update.message().photo());
        PhotoSize photo = photos.stream().max(Comparator.comparing(PhotoSize::fileSize)).orElse(null);

        String imageStoredInDB = photo.fileId();
        LocalDateTime dateOfLastRepost = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        reportCatService.saveNewPhotoReportCat(chatId, imageStoredInDB, dateOfLastRepost);

        sendMessage(chatId, "Фото успешно загружено");

        ReportCat reportCat = reportCatService.findReportCatByChatId(chatId);
        if (reportCat.getStringReport() == null) {
            sendMessage(chatId, "Пожалуйста не забудьте предоставить текстовый отчет");
        }
    }

    private void sendMessage(Long chatId, String message) {
        SendMessage sendMessage = new SendMessage(chatId, message);
        telegramBot.execute(sendMessage);
    }

}

package pro.sky.telegrambot.handler;

import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;
import pro.sky.telegrambot.entity.Owner;
import pro.sky.telegrambot.entity.Report;
import pro.sky.telegrambot.service.OwnerService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.model.PhotoSize;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetFileResponse;
import pro.sky.telegrambot.service.ReportService;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

/**
 * "Перехватчик" updates типа Image
 * Сохраняет фото в БД
 */

public class ImageHandler implements Handler {
    private final TelegramBot telegramBot;
    private final OwnerService ownerService;

    private final ReportService reportService;

    public ImageHandler(TelegramBot telegramBot,
                        OwnerService ownerService,
                        ReportService reportService) {
        this.telegramBot = telegramBot;
        this.ownerService = ownerService;
        this.reportService = reportService;
    }

    @Override
    public void handle(Update update) throws IOException {
        Long chatId = update.message().chat().id();
        Owner owner = ownerService.findOwnerByChatId(chatId);
        List<PhotoSize> photos = List.of(update.message().photo());
        PhotoSize photo = photos.stream().max(Comparator.comparing(PhotoSize::fileSize)).orElse(null);

        String imageStoredInDB = photo.fileId();
        LocalDateTime dateOfLastRepost = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        reportService.saveNewPhotoReport(chatId, imageStoredInDB, dateOfLastRepost);

        sendMessage(chatId, "Фото успешно загружено");

        Report report = reportService.findReportByChatId(chatId);
        if (report.getStringReport() == null) {
            sendMessage(chatId, "Пожалуйста не забудьте предоставить текстовый отчет");
        }
    }

    private void sendMessage(Long chatId, String message) {
        SendMessage sendMessage = new SendMessage(chatId, message);
        telegramBot.execute(sendMessage);
    }
}

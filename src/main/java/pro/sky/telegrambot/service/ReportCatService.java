package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.entity.Report;
import pro.sky.telegrambot.entity.ReportCat;
import pro.sky.telegrambot.repository.OwnerCatRepository;
import pro.sky.telegrambot.repository.OwnerRepository;
import pro.sky.telegrambot.repository.ReportCatRepository;
import pro.sky.telegrambot.repository.ReportRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Методы для работы с репозиторием {@link ReportCatRepository}
 */
@Service
public class ReportCatService {
    private final ReportCatRepository reportCatRepository;

    private final OwnerCatRepository ownerCatRepository;

    public ReportCatService(ReportCatRepository reportCatRepository, OwnerCatRepository ownerCatRepository) {
        this.reportCatRepository = reportCatRepository;
        this.ownerCatRepository = ownerCatRepository;
    }

    public void saveNewPhotoReportCat(Long chatId,
                                   String photoId,
                                   LocalDateTime dateOfLastReport) {
        ReportCat reportCat = new ReportCat();
        reportCat.setChatId(chatId);
        reportCat.setPhotoId(photoId);
        reportCat.setDateOfLastReport(dateOfLastReport);
        reportCat.setOwnerCat(ownerCatRepository.getOwnerCatByChatId(chatId));
        reportCatRepository.save(reportCat);
    }

    public void saveNewStringReportCat(Long chatId,
                                    String stringReport,
                                    LocalDateTime dateOfLastReport) {
        ReportCat reportCat = new ReportCat();
        reportCat.setChatId(chatId);
        reportCat.setStringReport(stringReport);
        reportCat.setDateOfLastReport(dateOfLastReport);
        reportCat.setOwnerCat(ownerCatRepository.getOwnerCatByChatId(chatId));
        reportCatRepository.save(reportCat);
    }

    /**
     * Записываем reportCat в БД
     */
    public void saveReportCat(ReportCat reportCat) {
        reportCatRepository.save(reportCat);
    }

    public ReportCat findReportCatByChatId(Long chatId) {
        return reportCatRepository.getReportCatByChatId(chatId);
    }

    public List<ReportCat> findAllReports() {
        return reportCatRepository.findAll();
    }


}

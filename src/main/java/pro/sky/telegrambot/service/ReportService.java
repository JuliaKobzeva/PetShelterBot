package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.entity.Owner;
import pro.sky.telegrambot.entity.Report;
import pro.sky.telegrambot.enums.ProbationaryStatus;
import pro.sky.telegrambot.repository.OwnerRepository;
import pro.sky.telegrambot.repository.ReportRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Методы для работы с репозиторием {@link ReportRepository}
 */

@Service
public class ReportService {
    private final ReportRepository reportRepository;
    private final OwnerRepository ownerRepository;

    public ReportService(ReportRepository reportRepository,
                         OwnerRepository ownerRepository) {
        this.reportRepository = reportRepository;
        this.ownerRepository = ownerRepository;
    }

    public void saveNewPhotoReport(Long chatId,
                                   String photoId,
                                   LocalDateTime dateOfLastReport) {
        Report report = new Report();
        report.setChatId(chatId);
        report.setPhotoId(photoId);
        report.setDateOfLastReport(dateOfLastReport);
        report.setOwner(ownerRepository.getOwnerByChatId(chatId));
        saveReport(report);
    }

    public void saveNewStringReport(Long chatId,
                                    String stringReport,
                                    LocalDateTime dateOfLastReport) {
        Report report = new Report();
        report.setChatId(chatId);
        report.setStringReport(stringReport);
        report.setDateOfLastReport(dateOfLastReport);
        report.setOwner(ownerRepository.getOwnerByChatId(chatId));
        saveReport(report);
    }

    /**
     * Записываем report в БД
     */
    public void saveReport(Report report) {
        reportRepository.save(report);
    }

    public Report findReportByChatId(Long chatId) {
        return reportRepository.getReportByChatId(chatId);
    }

    public List<Report> findAllReports() {
        return reportRepository.findAll();
    }

}
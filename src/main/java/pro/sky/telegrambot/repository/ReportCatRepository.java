package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.entity.Report;
import pro.sky.telegrambot.entity.ReportCat;

import java.util.List;

@Repository
public interface ReportCatRepository extends JpaRepository<ReportCat, Long> {
    ReportCat getReportCatByChatId(Long chatId);
    List<ReportCat> findAll();
}

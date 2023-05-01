package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.entity.Owner;
import pro.sky.telegrambot.entity.OwnerCat;

import java.util.List;

@Repository
public interface OwnerCatRepository extends JpaRepository<OwnerCat, Long> {
    OwnerCat getOwnerCatByChatId(Long chatID);
    List<OwnerCat> findAll();
}

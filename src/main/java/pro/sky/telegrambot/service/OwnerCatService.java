package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.entity.Owner;
import pro.sky.telegrambot.entity.OwnerCat;
import pro.sky.telegrambot.enums.ProbationaryStatus;
import pro.sky.telegrambot.repository.OwnerCatRepository;
import pro.sky.telegrambot.repository.OwnerRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Методы для работы с репозиторием {@link OwnerCatRepository}
 */
@Service
public class OwnerCatService {
    private final OwnerCatRepository ownerCatRepository;

    public OwnerCatService(OwnerCatRepository ownerCatRepository) {
        this.ownerCatRepository = ownerCatRepository;
    }


    public void saveNewCatOwner(Long chatId,
                                String name,
                                LocalDateTime dateOfStartProbation,
                                LocalDateTime dateOfEndProbation,
                                ProbationaryStatus probationaryStatus) {
        OwnerCat ownerCat = new OwnerCat();
        ownerCat.setChatId(chatId);
        ownerCat.setName(name);
        ownerCat.setDateOfStartProbation(dateOfStartProbation);
        ownerCat.setDateOfEndProbation(dateOfEndProbation);
        ownerCat.setProbationaryStatus(ProbationaryStatus.ACTIVE);
        ownerCatRepository.save(ownerCat);
    }
    /**
     * Записываем ownerCat в БД
     */
    public void saveOwnerCat(OwnerCat ownerCat) {
        ownerCatRepository.save(ownerCat);
    }

    /**
     * Получаем информацию о владельце по идентификатору. <br>
     * Используется метод репозитория {@link OwnerCatRepository#getOwnerCatByChatId(Long)}
     *
     * @param chatId идентификатор владельца
     * @return OwnerCat
     */
    public OwnerCat findOwnerCatByChatId(Long chatId) {
        return ownerCatRepository.getOwnerCatByChatId(chatId);
    }

    /**
     * Получаем информацию о владельцах из БД. <br>
     * Используется метод репозитория {@link OwnerCatRepository#findAll()}
     *
     * @return List<OwnerCat>
     */
    public List<OwnerCat> findAllOwners() {
        return ownerCatRepository.findAll();
    }
}


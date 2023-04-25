package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.entity.Owner;
import pro.sky.telegrambot.enums.ProbationaryStatus;
import pro.sky.telegrambot.repository.OwnerRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Методы для работы с репозиторием {@link OwnerRepository}
 */
@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    public void saveNewDogOwner(Long chatId,
                                String name,
                                LocalDateTime dateOfStartProbation,
                                LocalDateTime dateOfEndProbation,
                                ProbationaryStatus probationaryStatus) {
        Owner owner = new Owner();
        owner.setChatId(chatId);
        owner.setName(name);
        owner.setDateOfStartProbation(dateOfStartProbation);
        owner.setDateOfEndProbation(dateOfEndProbation);
        owner.setProbationaryStatus(ProbationaryStatus.ACTIVE);
        ownerRepository.save(owner);
    }
    /**
     * Записываем owner в БД
     */
    public void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    /**
     * Получаем информацию о владельце по идентификатору. <br>
     * Используется метод репозитория {@link OwnerRepository#getOwnerByChatId(Long chatID)}
     *
     * @param chatId идентификатор владельца
     * @return Owner
     */
    public Owner findOwnerByChatId(Long chatId) {
        return ownerRepository.getOwnerByChatId(chatId);
    }

    /**
     * Получаем информацию о владельцах из БД. <br>
     * Используется метод репозитория {@link OwnerRepository#findAll()}
     *
     * @return List<Owner>
     */
    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }
}
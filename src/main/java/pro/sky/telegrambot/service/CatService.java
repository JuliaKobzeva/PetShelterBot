package pro.sky.telegrambot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.entity.Cat;
import pro.sky.telegrambot.entity.Dog;
import pro.sky.telegrambot.repository.CatRepository;
import pro.sky.telegrambot.repository.DogRepository;

import java.util.Optional;
/**
 * Методы для работы с репозиторием {@link CatRepository}
 */
@Service
public class CatService {
    private final CatRepository catRepository;
    Logger logger = LoggerFactory.getLogger(DogService.class);

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    /**
     * Сохраняем кота в БД. <br>
     * Используется метод репозитория {@link CatRepository#save(Object)}
     *
     * @param cat создается объект кот
     * @return созданная собака
     */
    public Cat addCat(Cat cat){
        logger.debug("Добавляем кота в БД.");
        return catRepository.save(cat);
    }

    /**
     * Получаем информацию о коте по идентификатору. <br>
     * Используется метод репозитория {@link CatRepository#findById(Object)}
     *
     * @param id идентификатор кота
     * @return Optional
     */

    public Optional<Cat> getCat(long id){
        logger.debug("Получаем данные о коте по id.");
        return catRepository.findById(id);
    }

    /**
     * Изменяем данные о коте в БД. <br>
     * Используется метод репозитория {@link CatRepository#save(Object)}
     *
     * @param cat создается объект кот
     * @return созданный кот
     */
    public Cat editCat(Cat cat){
        logger.debug("Изменяем данные кота в БД.");
        return catRepository.save(cat);
    }

    /**
     * Удаляет кота из БД. <br>
     * Используется метод репозитория {@link CatRepository#save(Object)}
     *
     * @param id идентификатор кота
     */
    public void deleteCat(long id){
        logger.debug("Удаляем кота по id");
        catRepository.deleteById(id);
    }
}

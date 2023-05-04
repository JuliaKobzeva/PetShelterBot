package pro.sky.telegrambot.entity;

import pro.sky.telegrambot.enums.ProbationaryStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "owner")
    private Collection<Dog> dogs;

    @OneToMany(mappedBy = "owner")
    private Collection<Report> reports;

    @Column(name = "start_probation")
    private LocalDateTime dateOfStartProbation;

    @Column(name = "end_probation")
    private LocalDateTime dateOfEndProbation;

    @Column(name = "probationary_status")
    @Enumerated(EnumType.STRING)
    private ProbationaryStatus probationaryStatus;
    @Column(name = "period_extend")
    private int periodExtend;

    public Owner(Long chatId, String name) {
        this.chatId = chatId;
        this.name = name;
    }

    public Owner(Long chatId, String name, Collection<Dog> dogs, Collection<Report> reports, LocalDateTime dateOfStartProbation, LocalDateTime dateOfEndProbation, ProbationaryStatus probationaryStatus, int periodExtend) {
        this.chatId = chatId;
        this.name = name;
        this.dogs = dogs;
        this.reports = reports;
        this.dateOfStartProbation = dateOfStartProbation;
        this.dateOfEndProbation = dateOfEndProbation;
        this.probationaryStatus = probationaryStatus;
        this.periodExtend = periodExtend;
    }

    public Owner() {

    }

    public int getPeriodExtend() {
        return periodExtend;
    }

    public void setPeriodExtend(int periodExtend) {
        if (periodExtend >= 0 && periodExtend < 15)
            this.periodExtend = periodExtend;
    }

    public LocalDateTime getDateOfStartProbation() {
        return dateOfStartProbation;
    }

    public void setDateOfStartProbation(LocalDateTime dateOfStartProbation) {
        this.dateOfStartProbation = dateOfStartProbation;
    }

    public LocalDateTime getDateOfEndProbation() {
        return dateOfEndProbation;
    }

    public void setDateOfEndProbation(LocalDateTime dateOfEndProbation) {
        this.dateOfEndProbation = dateOfEndProbation;
    }

    public ProbationaryStatus getProbationaryStatus() {
        return probationaryStatus;
    }

    public void setProbationaryStatus(ProbationaryStatus probationaryStatus) {
        this.probationaryStatus = probationaryStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(id, owner.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", name='" + name + '\'' +
                ", dogs=" + dogs +
                ", reports=" + reports +
                ", dateOfStartProbation=" + dateOfStartProbation +
                ", dateOfEndProbation=" + dateOfEndProbation +
                ", probationaryStatus=" + probationaryStatus +
                ", periodExtend=" + periodExtend +
                '}';
    }
}
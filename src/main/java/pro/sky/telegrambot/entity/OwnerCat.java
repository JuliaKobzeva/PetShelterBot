package pro.sky.telegrambot.entity;

import pro.sky.telegrambot.enums.ProbationaryStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ownersCat")
public class OwnerCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "ownerCat")
    private Collection<Cat> cats;

    @OneToMany(mappedBy = "ownerCat")
    private Collection<ReportCat> reports;

    @Column(name = "start_probation")
    private LocalDateTime dateOfStartProbation;

    @Column(name = "end_probation")
    private LocalDateTime dateOfEndProbation;

    @Column(name = "probationary_status")
    @Enumerated(EnumType.STRING)
    private ProbationaryStatus probationaryStatus;

    @Column(name = "period_extend")
    private int periodExtend;

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

    public Collection<Cat> getCats() {
        return cats;
    }

    public void setCats(Collection<Cat> cats) {
        this.cats = cats;
    }

    public Collection<ReportCat> getReports() {
        return reports;
    }

    public void setReports(Collection<ReportCat> reports) {
        this.reports = reports;
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

    public int getPeriodExtend() {
        return periodExtend;
    }

    public void setPeriodExtend(int periodExtend) {
        this.periodExtend = periodExtend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerCat ownerCat = (OwnerCat) o;
        return Objects.equals(id, ownerCat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OwnerCat{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", name='" + name + '\'' +
                ", cats=" + cats +
                ", reports=" + reports +
                ", dateOfStartProbation=" + dateOfStartProbation +
                ", dateOfEndProbation=" + dateOfEndProbation +
                ", probationaryStatus=" + probationaryStatus +
                ", periodExtend=" + periodExtend +
                '}';
    }
}

package pro.sky.telegrambot.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "photo_report")
    private String photoId;

    @Column(name = "string_report")
    private String stringReport;

    @Column(name = "last_report")
    private LocalDateTime dateOfLastReport;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Report(Long chatId, String photoId, String stringReport, LocalDateTime dateOfLastReport, Owner owner) {
        this.chatId = chatId;
        this.photoId = photoId;
        this.stringReport = stringReport;
        this.dateOfLastReport = dateOfLastReport;
        this.owner = owner;
    }

    public Report(Long chatId, String photoId, String stringReport, LocalDateTime dateOfLastReport) {
        this.chatId = chatId;
        this.photoId = photoId;
        this.stringReport = stringReport;
        this.dateOfLastReport = dateOfLastReport;
    }

    public Report() {
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getStringReport() {
        return stringReport;
    }

    public void setStringReport(String stringReport) {
        this.stringReport = stringReport;
    }

    public LocalDateTime getDateOfLastReport() {
        return dateOfLastReport;
    }

    public void setDateOfLastReport(LocalDateTime dateOfLastReport) {
        this.dateOfLastReport = dateOfLastReport;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return Objects.equals(id, report.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", photoId='" + photoId + '\'' +
                ", stringReport='" + stringReport + '\'' +
                ", dateOfLastReport=" + dateOfLastReport +
                ", owner=" + owner +
                '}';
    }
}
package pro.sky.telegrambot.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "reportsCat")
public class ReportCat {
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
    @JoinColumn(name = "ownerCat_id")
    private OwnerCat ownerCat;

    public ReportCat(Long chatId, String photoId, LocalDateTime dateOfLastReport, String stringReport, OwnerCat ownerCat) {
        this.chatId = chatId;
        this.photoId = photoId;
        this.stringReport = stringReport;
        this.dateOfLastReport = dateOfLastReport;
        this.ownerCat = ownerCat;
    }

    public ReportCat(Long chatId, String photoId, LocalDateTime dateOfLastReport, OwnerCat ownerCat) {
        this.chatId = chatId;
        this.photoId = photoId;
        this.dateOfLastReport = dateOfLastReport;
        this.ownerCat = ownerCat;
    }

    public ReportCat(Long chatId, String photoId, LocalDateTime dateOfLastReport) {
        this.chatId = chatId;
        this.photoId = photoId;
        this.dateOfLastReport = dateOfLastReport;
    }

    public ReportCat() {

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

    public OwnerCat getOwnerCat() {
        return ownerCat;
    }

    public void setOwnerCat(OwnerCat ownerCat) {
        this.ownerCat = ownerCat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportCat reportCat = (ReportCat) o;
        return Objects.equals(id, reportCat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ReportCat{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", photoId='" + photoId + '\'' +
                ", stringReport='" + stringReport + '\'' +
                ", dateOfLastReport=" + dateOfLastReport +
                ", ownerCat=" + ownerCat +
                '}';
    }
}

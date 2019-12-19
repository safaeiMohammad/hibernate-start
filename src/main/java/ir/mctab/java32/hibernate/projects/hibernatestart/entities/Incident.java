package ir.mctab.java32.hibernate.projects.hibernatestart.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "incident")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, length = 22)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "incident")
    private List<IncidentComment> incidentComments = new ArrayList<>();

    public Incident() {

    }

    public Incident(String title, String description, Date createDate) {
        this.title = title;
        this.description = description;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<IncidentComment> getIncidentComments() {
        return incidentComments;
    }

    public void setIncidentComments(List<IncidentComment> incidentComments) {
        this.incidentComments = incidentComments;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}

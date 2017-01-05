package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Table(name = "document")
@NamedQueries({
    @NamedQuery(name="Document.findByDocumentId", query="select d from Document d where d.documentId=:id"),
    @NamedQuery(name="Document.findDocuments", query="select d from Document d where d.documentType.documentType like :docType"),
    @NamedQuery(name="Document.findByTypeAndDateRange", query="select d from Document d where d.documentType=:docType and d.uploadDate >=:beginDate and d.uploadDate <= :endDate")
})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "document_document_id_seq", sequenceName = "document_document_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_document_id_seq")
    @Column(name="document_id", updatable=false)
    private Long documentId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "document_type")
    private DocumentType documentType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "group_id")
    private DocumentGroup documentGroup;

    @Column(name = "name")
    private String name;

    @Column(name = "document_path")
    private String documentPath;

    @Column(name = "upload_date")
    private Calendar uploadDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "format")
    private String format;

    @Column(name = "size")
    private Integer size;

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public DocumentGroup getDocumentGroup() {
        return documentGroup;
    }

    public void setDocumentGroup(DocumentGroup documentGroup) {
        this.documentGroup = documentGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public Calendar getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Calendar uploadDate) {
        this.uploadDate = uploadDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd'T'HH:mm'Z'";

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getUploadDateAsString() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(this.getUploadDate().getTime());
    }

}

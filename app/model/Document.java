package model;

import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Table(name = "document")
@NamedQueries({
    @NamedQuery(name="Document.findByType", query="select d from Document d where d.documentType=:docType"),
    @NamedQuery(name="Document.findByTypeAndDateRange", query="select d from Document d where d.documentType=:docType and d.uploadDate >=:beginDate and d.uploadDate <= :endDate")
})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "document_document_id_seq", sequenceName = "document_document_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_document_id_seq")
    @Column(name="document_id", updatable=false)
    private Long documentId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "document_type")
    private DocumentType documentType;

    @Column(name = "name")
    private String name;

    @Column(name = "document")
    private byte[] document;

    @Column(name = "upload_date")
    private Calendar uploadDate;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "format")
    private String format;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
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

    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

    public String getUploadDateAsString() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(this.getUploadDate().getTime());
    }

}

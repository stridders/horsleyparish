package model;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
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
    @Column(name = "document_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "document_seq")
    private Long documentId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "document_type", insertable = false, updatable = false)
    private DocumentType documentType;

    @Column(name = "name")
    private String name;

    @Column(name = "document")
    private byte[] document;

    @Column(name = "upload_date")
    private Calendar uploadDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
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

    /**
     * Returns a JSON String representation of the document object, minus the document itself
     * @return
     */
    public String toMetaDataString() {
        ObjectMapper mapper = new ObjectMapper();
        Document tempDoc = new Document();
        tempDoc = this;
        tempDoc.setDocument(null);
        try {
            return mapper.writeValueAsString(tempDoc);
        } catch(IOException ioe) {
            return null;
        }
    }

    /**
     * Returns a JSON String representation of the full document object,
     * which includes the document object (byte[] array) itself
     * @return
     */
    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch(IOException ioe) {
            return null;
        }
    }

}

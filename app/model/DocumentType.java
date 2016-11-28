package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "document_type")
@NamedQueries({
    @NamedQuery(name="DocumentType.findAll", query="select dt from DocumentType dt"),
    @NamedQuery(name="DocumentType.findType", query="select dt from DocumentType dt where dt.documentType = :docType")
})
public class DocumentType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "document_type")
    private String documentType;

    @Column(name = "description")
    private String description;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role", insertable = false, updatable = false)
    private Role role;

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}

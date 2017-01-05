package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "document_group")
@NamedQueries({
        @NamedQuery(name="DocumentGroup.findAll", query="select dg from DocumentGroup dg"),
        @NamedQuery(name="DocumentGroup.findByGroupAndType", query="select dg from DocumentGroup dg where dg.groupName = :groupName AND dg.documentType.documentType = :documentType"),
        @NamedQuery(name="DocumentGroup.findByType", query="select dg from DocumentGroup dg where dg.documentType = :documentType"),
})
public class DocumentGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "document_group_group_id_seq", sequenceName = "document_group_group_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_group_group_id_seq")
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_name")
    private String groupName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "document_type")
    private DocumentType documentType;

    @OneToMany(mappedBy="documentGroup")
    private List<Document> documents = new ArrayList<>();

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }


}

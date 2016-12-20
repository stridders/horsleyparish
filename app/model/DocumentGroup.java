package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "document_group")
@NamedQueries({
        @NamedQuery(name="DocumentGroup.findAll", query="select dg from DocumentGroup dg"),
        @NamedQuery(name="DocumentGroup.findByGroupName", query="select dg from DocumentGroup dg where dg.groupName = :groupName"),
})
public class DocumentGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "document_group_group_id_seq", sequenceName = "document_group_group_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_group_group_id_seq")
    @Column(name = "document_group_id")
    private Long documentGroupId;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "documentGroup")
    private List<Document> documents;

    public DocumentGroup() {
        this.documents = new ArrayList<>();
    }

    public Long getDocumentGroupId() {
        return documentGroupId;
    }

    public void setDocumentGroupId(Long documentGroupId) {
        this.documentGroupId = documentGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }


}

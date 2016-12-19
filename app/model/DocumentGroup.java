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
    @Column(name = "document_group_id")
    private String documentGroupId;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "documentGroup")
    private List<Document> documents;

    public DocumentGroup() {
        this.documents = new ArrayList<>();
    }

    public String getDocumentGroupId() {
        return documentGroupId;
    }

    public void setDocumentGroupId(String documentGroupId) {
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

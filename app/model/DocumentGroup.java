package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "document_group")
@NamedQueries({
        @NamedQuery(name="DocumentGroup.findAll", query="select dg from DocumentGroup dg"),
})
public class DocumentGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "document_group_id")
    private String documentGroupId;

    @Column(name = "group_name")
    private String groupName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "documentId", insertable = false, updatable = false)
    private Document document;

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

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

}

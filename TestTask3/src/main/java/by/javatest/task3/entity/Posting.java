package by.javatest.task3.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "postings")
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "mat_doc")
    private long matDoc;
    @Column(name = "item")
    private int item;
    @Column(name = "doc_date")
    private LocalDate docDate;
    @Column(name = "posting_date")
    private LocalDate postingDate;
    @Column(name = "material_description")
    private String materialDescription;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "bun")
    private String bun;
    @Column(name = "amountLC")
    private double amountLC;
    @Column(name = "crcy")
    private String crcy;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "authorized_posting")
    private boolean authorizedPosting;

    public Posting() {
    }

    public Posting(long matDoc, int item, LocalDate docDate, LocalDate postingDate, String materialDescription, int quantity, String bun, double amountLC, String crcy, String userName) {
        this.matDoc = matDoc;
        this.item = item;
        this.docDate = docDate;
        this.postingDate = postingDate;
        this.materialDescription = materialDescription;
        this.quantity = quantity;
        this.bun = bun;
        this.amountLC = amountLC;
        this.crcy = crcy;
        this.userName = userName;
    }

    public Posting(long matDoc, int item, LocalDate docDate, LocalDate postingDate, String materialDescription, int quantity, String bun, double amountLC, String crcy, String userName, boolean authorizedPosting) {
        this.matDoc = matDoc;
        this.item = item;
        this.docDate = docDate;
        this.postingDate = postingDate;
        this.materialDescription = materialDescription;
        this.quantity = quantity;
        this.bun = bun;
        this.amountLC = amountLC;
        this.crcy = crcy;
        this.userName = userName;
        this.authorizedPosting = authorizedPosting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMatDoc() {
        return matDoc;
    }

    public void setMatDoc(long matDoc) {
        this.matDoc = matDoc;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public LocalDate getDocDate() {
        return docDate;
    }

    public void setDocDate(LocalDate docDate) {
        this.docDate = docDate;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBun() {
        return bun;
    }

    public void setBun(String bun) {
        this.bun = bun;
    }

    public double getAmountLC() {
        return amountLC;
    }

    public void setAmountLC(double amountLC) {
        this.amountLC = amountLC;
    }

    public String getCrcy() {
        return crcy;
    }

    public void setCrcy(String crcy) {
        this.crcy = crcy;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isAuthorizedPosting() {
        return authorizedPosting;
    }

    public void setAuthorizedPosting(boolean authorizedPosting) {
        this.authorizedPosting = authorizedPosting;
    }

    @Override
    public String toString() {
        return "Posting{" +
                "matDoc=" + matDoc +
                ", item=" + item +
                ", docDate=" + docDate +
                ", postingDate=" + postingDate +
                ", materialDescription='" + materialDescription + '\'' +
                ", quantity=" + quantity +
                ", bun='" + bun + '\'' +
                ", amountLC=" + amountLC +
                ", crcy='" + crcy + '\'' +
                ", userName='" + userName + '\'' +
                ", authorizedPosting=" + authorizedPosting +
                '}';
    }

}

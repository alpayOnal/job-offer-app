package isteklifsistemi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Talep {
    @Id
    @GeneratedValue
    private long id;

    private String title;


    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private Category category;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private SubCategory subCategory;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TalepPropertyValue> properties = new ArrayList<>();

    private Date date;
    private String detail;
    private String city;
    private String district;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<TalepPropertyValue> getProperties() {
        return properties;
    }

    public void setProperties(List<TalepPropertyValue> properties) {
        this.properties = properties;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}

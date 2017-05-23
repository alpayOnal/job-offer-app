package isteklifsistemi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class MeslekProfili {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private Category category;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private SubCategory subCategory;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

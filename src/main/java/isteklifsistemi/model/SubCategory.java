package isteklifsistemi.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category parent;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<SubCategoryProperty> properties = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Set<SubCategoryProperty> getProperties() {
        return properties;
    }

    public void setProperties(Set<SubCategoryProperty> properties) {
        this.properties = properties;
    }
}

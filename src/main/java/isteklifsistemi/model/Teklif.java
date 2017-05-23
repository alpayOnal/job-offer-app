package isteklifsistemi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Teklif {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Talep talep;

    @OneToOne(fetch = FetchType.EAGER)
    @NotNull
    private User user;

    private String description;

    private int price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Talep getTalep() {
        return talep;
    }

    public void setTalep(Talep talep) {
        this.talep = talep;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

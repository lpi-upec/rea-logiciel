package fr.edenskull.demojpa.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Gokan EKINCI
 */
@Entity
@Table(name = "product", schema = "public")
public class ProductEntity {
    /**
     * Reference of the product
     */
    @Id
    private Long id;
    
    private String name;
    
    @Column(name = "url_image")
    private String urlImage;
    
    /**
     * Price in cents
     */
    private Integer price;
    
    private String description;

    @OneToOne
    @JoinColumn(name = "fk_id_theme", referencedColumnName = "id")
    private ThemeEntity theme;

    @OneToMany(mappedBy = "product")
    private List<TagEntity> tags;

    public ProductEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ThemeEntity getTheme() {
        return theme;
    }

    public void setTheme(ThemeEntity theme) {
        this.theme = theme;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }
}

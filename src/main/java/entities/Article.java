package entities;import lombok.*;import org.hibernate.envers.Audited;import javax.persistence.*;import java.io.Serializable;import java.util.List;@Entity@Table(name = "articles")@Getter@Setter@NoArgsConstructor@AllArgsConstructor@Builder@Auditedpublic class Article implements Serializable {    private static final long serialVersionUID = 1L;    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)    @Column(name = "id")    private Long id;    @Column(name = "name")    private String name;    @Column(name = "stock")    private int stock;    @Column(name = "price")    private double price;    //TODO: Relation Bidirectional...$$$    @OneToMany(mappedBy = "article", cascade = CascadeType.PERSIST)    private List<Detail> details;    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})    @JoinTable(name = "article_category",            joinColumns = @JoinColumn(name = "article_id"),            inverseJoinColumns = @JoinColumn(name = "category_id"),            uniqueConstraints = {@UniqueConstraint(columnNames = {"article_id", "category_id"})})    private List<Category> categories;}
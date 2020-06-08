@Entity
@Table(name="User")
@Data
@Getter
@Setter
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 15)
    @Column(unique = true)
    private String userName;

    @NotNull
    @NotBlank
    @Size(max = 15)
    private String password;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String lastName;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String lastName;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private Long phone;

    @OneToMany(mappedBy = "user")
    List<Admin> admin;
}
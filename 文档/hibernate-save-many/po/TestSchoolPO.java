
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Entity
@Table(name = "TEST_SCHOOL")
public class TestSchoolPO implements Serializable {

    private long id;
    private String name;
    private Set<TestClassPO> clasz;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DB")
    @SequenceGenerator(name = "SEQ_DB", sequenceName="SEQ_LOG_ID", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestSchoolPO that = (TestSchoolPO) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="schoolId")
    public Set<TestClassPO> getClasz() {
        return clasz;
    }

    public void setClasz(Set<TestClassPO> clasz) {
        this.clasz = clasz;
    }
}

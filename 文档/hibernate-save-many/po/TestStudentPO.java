
import javax.persistence.*;
import java.util.Objects;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Entity
@Table(name = "TEST_STUDENT")
public class TestStudentPO {
    private Long id;
    private Long classId;
    private String name;
    private TestClassPO clasz;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DB")
    @SequenceGenerator(name = "SEQ_DB", sequenceName="SEQ_LOG_ID", allocationSize = 1)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CLASS_ID", insertable=false, updatable=false)
    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
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
        TestStudentPO that = (TestStudentPO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(classId, that.classId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, classId, name);
    }

    @ManyToOne
    @JoinColumn(name="class_id")
    public TestClassPO getClasz() {
        return clasz;
    }

    public void setClasz(TestClassPO clasz) {
        this.clasz = clasz;
    }
}

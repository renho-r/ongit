
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Entity
@Table(name = "TEST_CLASS")
public class TestClassPO implements Serializable {

    private long id;
    private Long schoolId;
    private String name;
    private TestSchoolPO schoolz;
    private List<TestStudentPO> students;

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
    @Column(name="SCHOOL_ID", insertable=false, updatable=false)
    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
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
        TestClassPO that = (TestClassPO) o;
        return id == that.id &&
                Objects.equals(schoolId, that.schoolId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, schoolId, name);
    }

    @ManyToOne
    @JoinColumn(name="school_id")
    public TestSchoolPO getSchoolz() {
        return schoolz;
    }

    public void setSchoolz(TestSchoolPO schoolz) {
        this.schoolz = schoolz;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy="classId")
    public List<TestStudentPO> getStudents() {
        return students;
    }

    public void setStudents(List<TestStudentPO> students) {
        this.students = students;
    }
}

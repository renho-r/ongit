
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Service
public class TestServiceImpl implements ITestService {
    @Override
    public void saveAll() {

        TestSchoolPO school = new TestSchoolPO();
        school.setName("school-renho-1");

        Set<TestClassPO> claszs = new HashSet<>();

        TestClassPO clasz = new TestClassPO();
        clasz.setName("class-renho-1");
        clasz.setSchoolz(school);
        claszs.add(clasz);

        List<TestStudentPO> ss = new ArrayList<>();
        TestStudentPO s1 = new TestStudentPO();
        s1.setName("student-renho-1");
        s1.setClasz(clasz);
        ss.add(s1);

        s1 = new TestStudentPO();
        s1.setName("student-renho-2");
        s1.setClasz(clasz);
        ss.add(s1);

        clasz.setStudents(ss);

        clasz = new TestClassPO();
        clasz.setName("class-renho-2");
        clasz.setSchoolz(school);
        claszs.add(clasz);

        ss = new ArrayList<>();
        s1 = new TestStudentPO();
        s1.setName("student-renho-1");
        s1.setClasz(clasz);
        ss.add(s1);

        s1 = new TestStudentPO();
        s1.setName("student-renho-2");
        s1.setClasz(clasz);
        ss.add(s1);

        clasz.setStudents(ss);

        school.setClasz(claszs);

        DBUtils.save(school);
    }
}

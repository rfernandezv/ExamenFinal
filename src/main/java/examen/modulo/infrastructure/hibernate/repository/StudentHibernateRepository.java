package examen.modulo.infrastructure.hibernate.repository;

import examen.modulo.domain.entity.IStudentCalculator;
import examen.modulo.domain.entity.IStudentRule;
import examen.modulo.domain.entity.Student;
import examen.modulo.domain.entity.StudentAcademic;
import examen.modulo.domain.entity.StudentDoctorado;
import examen.modulo.domain.entity.StudentMaestria;
import examen.modulo.domain.repository.ModuloRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class StudentHibernateRepository implements ModuloRepository{
    private List<Student> students;
    private IStudentCalculator iStudentCalculator;
    private StudentAcademic studentAcademic;
    private List<IStudentRule> calculateRules;
    private IStudentRule iStudent;
    
    public StudentHibernateRepository () {
        students = new ArrayList();        
        students.add(new Student(1L,"Richar Marvin","Fernandez Vilchez","MAESTRIA"));
        students.add(new Student(1L,"Lissi","Fernandez Vilchez","MAESTRIA"));
        students.add(new Student(2L,"Adaia","Silvera Ortiz","PREGRADO"));
        students.add(new Student(3L,"Carlos","Vega Valqui","DOCTORADO"));
        students.add(new Student(3L,"Mario","Salinas","DOCTORADO"));
    }
    
    @Override
    public List<Student> getAll() throws Exception {
        return students;
    }

    @Override
    public List<Student> findStudentByType(String typeStudent) throws Exception {
        List<Student> lstStudent = new ArrayList<>();
        for(Student student :students) {
            if(student.getTypeGrade().equals(typeStudent)) {
                student.setAmount(100.00);
                lstStudent.add(student);                
            }
        }
        return lstStudent;
    }
    
}

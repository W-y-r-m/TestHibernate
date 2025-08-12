package org.example;

import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Tạo SessionFactory từ file cấu hình
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Tạo Session
        Session session = sessionFactory.openSession();

        try {
            // Bắt đầu giao dịch
            session.beginTransaction();

            // Tạo một đối tượng Student
            Student student = new Student(8, "NgaDC", "ngadc@gmail.com");

            Student s2 = null;


            // Lưu vào cơ sở dữ liệu
//            session.save(student);
//            session.persist(student);

            // Update vào Database
//            session.merge(student);

            // Delete in database
            session.delete(student);

            // Commit giao dịch
            session.getTransaction().commit();

//            System.out.println("Lưu student thành công!");

            // Truy xuất student từ cơ sở dữ liệu
//            session.beginTransaction();
//            Student retrievedStudent = session.get(Student.class, 1);
//            System.out.println("Student: " + retrievedStudent.getName() + ", " + retrievedStudent.getEmail());
//            session.getTransaction().commit();


//            System.out.println(retrievedStudent);

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
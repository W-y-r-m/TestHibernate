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
            Student student = new Student(7, "ThinhPD", "thinhpd@gmail.com");

            // Lưu vào cơ sở dữ liệu
            session.save(student);

            // Commit giao dịch
            session.getTransaction().commit();

            System.out.println("Lưu student thành công!");

            // Truy xuất student từ cơ sở dữ liệu
            session.beginTransaction();
            Student retrievedStudent = session.get(Student.class, 1L);
            System.out.println("Student: " + retrievedStudent.getName() + ", " + retrievedStudent.getEmail());
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
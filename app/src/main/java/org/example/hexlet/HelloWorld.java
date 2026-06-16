package org.example.hexlet;

import org.example.hexlet.dto.courses.CoursesPage;
import io.javalin.Javalin;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        app.get("/courses", ctx -> {
            var term = ctx.queryParam("term");
            var allCourses = new ArrayList<Course>();
            allCourses.add(new Course("Java", "ООП"));
            allCourses.add(new Course("JavaScript", "Frontend"));
            allCourses.add(new Course("SQL", "Базы данных"));

            List<Course> courses;

            if (term != null) {
                courses = CourseRepository.search(term);
            } else {
                courses = CourseRepository.getEntities();
            }
        var header = "Курсы";
        var page = new CoursesPage(courses, term, header);
        ctx.render("courses/index.jte", model("page", page));
    });
        app.start(7070);
}
}
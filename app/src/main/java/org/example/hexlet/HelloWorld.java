package org.example.hexlet;

import org.example.hexlet.dto.courses.CoursesPage;
import io.javalin.Javalin;
import org.example.hexlet.model.Course;

import java.util.ArrayList;

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

            ArrayList<Course> courses;

            if (term != null) {
                courses = new ArrayList<>(
                        allCourses.stream()
                                .filter(course ->
                                        course.getName().contains(term)
                                                || course.getDescription().contains(term))
                                .toList()
                );
            } else {
                courses = allCourses;
            }
        var header = "Курсы";
        var page = new CoursesPage(courses, term, header);
        ctx.render("courses/index.jte", model("page", page));
    });
        app.start(7070);
}
}
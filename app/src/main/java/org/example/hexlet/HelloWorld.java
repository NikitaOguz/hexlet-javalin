package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;

import java.util.List;

import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        var courses = List.of(
                new Course(1L, "Java", "Изучение языка Java"),
                new Course(2L, "Javalin", "Создание веб-приложений на Javalin")
        );

        app.get("/", ctx -> ctx.redirect("/courses"));

        app.get("/courses", ctx -> {
            var page = new CoursesPage(courses, "Курсы по программированию");
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            var id = Long.valueOf(ctx.pathParam("id"));

            var course = courses.stream()
                    .filter(c -> c.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Course not found"));

            var page = new CoursePage(course);

            ctx.render("courses/show.jte", model("page", page));
        });

        app.start(7070);
    }
}
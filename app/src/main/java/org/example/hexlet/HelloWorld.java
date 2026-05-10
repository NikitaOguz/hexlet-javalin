package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;

import java.util.List;

import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.redirect("/courses"));

        app.get("/courses", ctx -> {
            var courses = List.of(
                    new Course("Java", "Изучение Java"),
                    new Course("Javalin", "Создание веб-приложений")
            );

            var page = new CoursesPage(courses, "Курсы по программированию");

            ctx.render("courses/index.jte", model("page", page));
        });

        app.start(7070);
    }
}
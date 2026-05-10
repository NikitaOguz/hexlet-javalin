package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import static io.javalin.rendering.template.TemplateUtil.model;

import java.util.List;

import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.model.Course;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> ctx.redirect("/courses"));

        app.get("/courses", ctx -> {
            var allCourses = List.of(
                    new Course("Java", "Изучение языка Java"),
                    new Course("Javalin", "Создание веб-приложений"),
                    new Course("SQL", "Работа с базами данных")
            );

            var term = ctx.queryParam("term");

            var courses = allCourses;

            if (term != null && !term.isBlank()) {
                var normalizedTerm = term.toLowerCase();

                courses = allCourses.stream()
                        .filter(course ->
                                course.getName().toLowerCase().contains(normalizedTerm)
                                        || course.getDescription().toLowerCase().contains(normalizedTerm)
                        )
                        .toList();
            }

            var page = new CoursesPage(
                    courses,
                    "Курсы по программированию",
                    term
            );

            ctx.render("courses/index.jte", model("page", page));
        });

        app.start(7070);
    }
}
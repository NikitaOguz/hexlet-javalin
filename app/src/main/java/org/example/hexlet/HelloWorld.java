package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursesPage;
import org.apache.commons.text.StringEscapeUtils;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
            config.staticFiles.add("/public");
        });

        app.get("/courses", ctx -> {
            var java = new Course("Java", "ООП");
            java.setId(1L);
            var courses = List.of(java);
                    var header = "Курсы по программированию";
            var page = new CoursesPage(courses, header);
            ctx.render("courses/index.jte", model("page", page));
        });
        app.get("/users", ctx -> {
            var id = ctx.queryParam("id");

            ctx.render(
                    "users/show.jte",
                    model("id", id)
            );
        });
        app.start(7070);
    }
}
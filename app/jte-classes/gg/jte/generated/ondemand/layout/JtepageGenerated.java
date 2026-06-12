package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,15,15,15,15,20,20,20,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"utf-8\" />\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n    <title>Hexlet Javalin Example</title>\r\n    <link rel=\"stylesheet\" href=\"/application.css\">\r\n</head>\r\n<body>\r\n<header>\r\n    <a href=\"/\">Home</a>\r\n</header>\r\n");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\r\n<footer>\r\n    <a href=\"https://github.com/NikitaOguz\">My Github</a>\r\n</footer>\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, content);
	}
}

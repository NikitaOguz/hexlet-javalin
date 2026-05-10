@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
content = @`
    <h2>${page.getHeader()}</h2>

    @if(page.getCourses().isEmpty())
        <p>Пока нет курсов</p>
    @else
        @for(var course : page.getCourses())
            <div>
                <h3>${course.getName()}</h3>
                <p>${course.getDescription()}</p>
            </div>
        @endfor
    @endif
`
)
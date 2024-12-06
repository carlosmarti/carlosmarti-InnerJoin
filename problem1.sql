Select student.id, student.student_name
From class
Inner Join student
on class.class_title = student.class_title
Where student.class_title in ('Math', 'Physics')
public class Main {
    public static void main(String[] args) {
        // Crear una instancia del gestor académico
        GestorAcademicos gestor = new GestorAcademicos();

        // Agregar algunos estudiantes por defecto
        Estudiante estudiante1 = new Estudiante(1, "Luis", "lopez", "2023-05-01", "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "Yesenia", "Marroquin", "2020-06-02", "matriculado");
        Estudiante estudiante3 = new Estudiante(3, "Cristopher", "Quintanilla", "2017-06-07", "matriculado");
        Estudiante estudiante4 = new Estudiante(4, "Brandon", "Perez", "2015-06-11", "matriculado");

        // Matricular estudiantes
        gestor.matricularEstudiante(estudiante1);
        gestor.matricularEstudiante(estudiante2);
        gestor.matricularEstudiante(estudiante3);
        gestor.matricularEstudiante(estudiante4);


        // Agregar algunos cursos por defecto
        Cursos curso1 = new Cursos(1, "Programación de HTML", "Curso Avanzado de HTML", 4, "1.0");
        Cursos curso2 = new Cursos(2, "Curso de CSS y SQL", "Introduccion de SQL y CSS", 3, "1.0");
        Cursos curso3 = new Cursos(3, "Ciber Seguridad", "Introducción a las Ciber Seguridad", 5, "3.0");


        // Agregar cursos
        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);
        gestor.agregarCurso(curso3);

        // Inscribir estudiantes en cursos
        try {
            gestor.inscribirEstudianteCurso(estudiante1, curso1.getId());
            gestor.inscribirEstudianteCurso(estudiante1, curso2.getId());
            gestor.inscribirEstudianteCurso(estudiante2, curso1.getId());
            gestor.inscribirEstudianteCurso(estudiante3, curso3.getId());
            gestor.inscribirEstudianteCurso(estudiante4, curso2.getId());
            gestor.inscribirEstudianteCurso(estudiante3, curso3.getId());

        } catch (EstiduanteInscristo e) {
            System.out.println(e.getMessage());
        }

        // Imprimir estudiantes
        gestor.imprimirEstudiantes();

        // Imprimir cursos
        gestor.imprimirCursos();

        // Imprimir estudiantes por curso
        gestor.imprimirEstudiantesPorCurso();

        // Desinscribir un estudiante de un curso (ejemplo)
        try {
            gestor.desinscribirEstudianteCurso(estudiante1.id, curso1.getId());
        } catch (EstudianteNoInscrito e) {
            System.out.println(e.getMessage());
        }
    }
}